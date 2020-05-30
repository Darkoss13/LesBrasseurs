//Permet de creer une partie, créer le fichier, parametrer la partie (nbr de tour, stock ini, id de la partie)
// IL FAUT FAIRE LA PARTIE DU CHOIX DU SCENARIO
package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CreerPartie extends AppCompatActivity
{
    EditText editNbrTours, editStockIni, editIdPartie;
    Button create_game;

    String mNbrTours, mStockIni, mEditIdPartie;
    private static final int WRITE_EXTERNAL_STORAGE_CODE = 1; //Pour le fichier, permet l'écriture sur un fichier externe


    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_partie);

        this.editNbrTours = (EditText) findViewById(R.id.editNbrTours);
        this.editStockIni = (EditText) findViewById(R.id.editStockIni);
        this.editIdPartie = (EditText) findViewById(R.id.editIdPartie);
        this.create_game = (Button) findViewById(R.id.create_game);

        create_game.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mNbrTours = editNbrTours.getText().toString().trim(); // trim() permet d'enlever les espaces av et apr
                mStockIni = editStockIni.getText().toString().trim();
                mEditIdPartie = editIdPartie.getText().toString().trim();


                if (mNbrTours.isEmpty() || mStockIni.isEmpty() || mEditIdPartie.isEmpty())
                { //utilissateur n'a rien rentré
                    Toast.makeText(CreerPartie.this, "Veuillez rentrer la valeur manquante", Toast.LENGTH_SHORT).show();
                }
                else
                { //si il a rentré toutes les valeurs
                    // si le joueur OS >= marshamallow
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    {
                        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED)
                        {
                            String [] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                            //show popup for runtime permission
                            requestPermissions(permissions, WRITE_EXTERNAL_STORAGE_CODE);
                        }
                        else
                        {
                            //permission already granted,save data
                            saveToTxtFile();
                        }
                    }
                    else
                    {
                        saveToTxtFile();
                    }
                    Intent creerPartie = new Intent(getApplicationContext(), PageConnexionAttenteJoueur.class);
                    startActivity(creerPartie);
                    finish();
                }
            }
        });

        Button annuler = (Button) findViewById(R.id.precedent_button);
        annuler.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(CreerPartie.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        switch (requestCode)
        {
            case WRITE_EXTERNAL_STORAGE_CODE:
                {
                //if request is cancelled, the result arrays are empty
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    saveToTxtFile();
                }
                else
                {
                    Toast.makeText(this, "storage permission is required", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    // méthode pour sauvegarder dans le fichier texte
    private void saveToTxtFile()
    {
        //String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(System.currentTimeMillis());
        try
        {
            File path = Environment.getExternalStorageDirectory();
            File dir = new File(path + "/My Files/");
            dir.mkdir(); //mkdir pour make directory --> création d'un repertoire

            String fileName = "MesDonnees.txt";
            //String fileName = "MyFile_" +timeStamp+".txt";

            File file = new File(dir, fileName);

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Configuration de la partie"); bw.newLine();
            bw.write(mNbrTours); bw.newLine();
            bw.write(mStockIni); bw.newLine();
            //bw.write(scénario);
            bw.write(mEditIdPartie); bw.newLine(); bw.newLine();
/*
            //Test pour afficher les valeurs en tant que joueur dans un tableau, j'écris déjà maintenant toutes les valaurs
            //bw.write(); bw.newLine();
            bw.write("Semaine 1 : "); bw.write(10;10;10;10;10;10;10;10;10;10;10;10) ; bw.newLine();
            bw.write("Semaine 2 : "); bw.write(8;2;7;2;18;15;0;7;8;5;20;1) ; bw.newLine();
            bw.write("Semaine 3 : "); bw.write(4;2;4;7;11;10;5;9;19;20;10;4) ; bw.newLine();

*/
            bw.close();

            Toast.makeText(this, fileName+" is saved to\n" +dir, Toast.LENGTH_SHORT).show();

        } catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
