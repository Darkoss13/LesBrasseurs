//Onglet pour rejoindre une partie
// Choix du rôle du joueur, le choix de son pseudonyme, et le test d'identifiant partie qui est sur le fichier text
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class RejoindrePartie extends AppCompatActivity
{
    EditText editPseudonyme, editIdPartieJoueur;
    Spinner spinnerChoixRole;
    Button join_game;
    String strEditIdPartieJoueur, strEditPseudonyme;

    //private static final int WRITE_EXTERNAL_STORAGE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejoindre_partie);

        this.editPseudonyme = (EditText) findViewById(R.id.editPseudonyme);
        this.spinnerChoixRole = (Spinner) findViewById(R.id.spinnerChoixRole);
        this.editIdPartieJoueur = (EditText) findViewById(R.id.editIdPartieJoueur);
        this.join_game = (Button) findViewById(R.id.join_game);


        List<String> categories = new ArrayList<>();
        categories.add(0, "");
        categories.add("Détaillant");
        categories.add("Grossiste");
        categories.add("Distributeur");
        categories.add("Brasseur");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerChoixRole.setAdapter(dataAdapter);

        spinnerChoixRole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (parent.getItemAtPosition(position).equals(""))
                {
                    Toast.makeText(RejoindrePartie.this, "Veuillez choisir un rôle", Toast.LENGTH_SHORT).show();
                }

                //POPUP qui permet de préciser ce que le joueur à selectionné

                //String item = parent.getItemAtPosition(position).toString();
                //Toast.makeText(parent.getContext(), "Selected:" +item,Toast.LENGTH_SHORT).show();

                if (parent.getItemAtPosition(position).equals("Détaillant"))
                {
                    join_game.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            strEditIdPartieJoueur = editIdPartieJoueur.getText().toString().trim();
                            strEditPseudonyme = editPseudonyme.getText().toString().trim();

                            if (strEditIdPartieJoueur.isEmpty() || strEditPseudonyme.isEmpty())
                            {
                                Toast.makeText(RejoindrePartie.this, "Veuillez entrer la / les champs manquants", Toast.LENGTH_SHORT).show();
                            }

                            else
                            {
                                try
                                {
                                    if (checkCode(strEditIdPartieJoueur))
                                    { //test pour la connexion entre l'id que le joueur entre et celui du MJ
                                        Intent intent = new Intent(RejoindrePartie.this, Detaillant.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(RejoindrePartie.this, "Vous n'avez pas entré le bon mot de passe", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                            }

                        }
                    });
                }

                if (parent.getItemAtPosition(position).equals("Grossiste"))
                {
                    join_game.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            strEditIdPartieJoueur = editIdPartieJoueur.getText().toString().trim();
                            strEditPseudonyme = editPseudonyme.getText().toString().trim();

                            if (strEditIdPartieJoueur.isEmpty() || strEditPseudonyme.isEmpty())
                            {
                                Toast.makeText(RejoindrePartie.this, "Veuillez entrer la / les champs manquants", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                try
                                {
                                    if (checkCode(strEditIdPartieJoueur))
                                    { //test pour la connexion entre l'id que le joueur entre et celui du MJ
                                        Intent intent = new Intent(RejoindrePartie.this, Grossiste.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(RejoindrePartie.this, "Vous n'avez pas entré le bon mot de passe", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                }

                if (parent.getItemAtPosition(position).equals("Distributeur"))
                {
                    join_game.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            strEditIdPartieJoueur = editIdPartieJoueur.getText().toString().trim();
                            strEditPseudonyme = editPseudonyme.getText().toString().trim();

                            if (strEditIdPartieJoueur.isEmpty() || strEditPseudonyme.isEmpty())
                            {
                                Toast.makeText(RejoindrePartie.this, "Veuillez entrer la / les champs manquants", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                try
                                {
                                    if (checkCode(strEditIdPartieJoueur))
                                    { //test pour la connexion entre l'id que le joueur entre et celui du MJ
                                        Intent intent = new Intent(RejoindrePartie.this, Distributeur.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(RejoindrePartie.this, "Vous n'avez pas entré le bon mot de passe", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                }

                if (parent.getItemAtPosition(position).equals("Brasseur"))
                {
                    join_game.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            strEditIdPartieJoueur = editIdPartieJoueur.getText().toString().trim();
                            strEditPseudonyme = editPseudonyme.getText().toString().trim();

                            if (strEditIdPartieJoueur.isEmpty() || strEditPseudonyme.isEmpty())
                            {
                                Toast.makeText(RejoindrePartie.this, "Veuillez entrer la / les champs manquants", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                try
                                {
                                    if (checkCode(strEditIdPartieJoueur))
                                    { //test pour la connexion entre l'id que le joueur entre et celui du MJ
                                        Intent intent = new Intent(RejoindrePartie.this, Brasseur.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(RejoindrePartie.this, "Vous n'avez pas entré le bon mot de passe", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                catch (IOException e)
                                {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Bouton qui permet de revenir sur la page création partie/rejoindre partie
        Button annuler = (Button) findViewById(R.id.precedent_button);
        annuler.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(RejoindrePartie.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //Pour comparer le mot de passe que le joueur entre pour rejoindre la partie
    private boolean checkCode(String strEditIdPartieJoueur) throws IOException
    {
        String temp;
        File path = Environment.getExternalStorageDirectory();
        File dir = new File(path + "/My Files/");
        String fileName = "MesDonnees.txt";
        File file = new File(dir, fileName);

        if (file.exists())
        {
            try
            {
                BufferedReader br = new BufferedReader(new FileReader(file));
                temp = br.readLine();
                while (temp != null)
                {
                    if (strEditIdPartieJoueur.equals(temp))
                    {
                        br.close();
                        return true;
                    }
                    temp = br.readLine();
                }
                br.close();
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

/*
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case WRITE_EXTERNAL_STORAGE_CODE: {
                //if request is cancelled, the result arrays are empty
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    saveToTxtFile(mText);
                }
                else {
                    Toast.makeText(this, "storage permission is required", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    // méthode pour sauvegarder dans le fichier texte
    private void saveToTxtFile(String mText) {
        //String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(System.currentTimeMillis());
        try {
            File path = Environment.getExternalStorageDirectory();
            File dir = new File(path + "/My Files/");
            dir.mkdir();

            String fileName = "MesDonnees.txt";
            //String fileName = "MyFile_" +timeStamp+".txt";

            File file = new File(dir, fileName);

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(mText);
            bw.close();

            Toast.makeText(this, fileName+" is saved to\n" +dir, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }*/
}