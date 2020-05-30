// Classe du joueur Grossiste
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Grossiste extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grossiste);

        //création du tableau pour afficher les données des semaines
        //données du tableau
        final String[] col1 = {"col1:ligne1", "col1:ligne2"};
        final String[] col2 = {"col2:ligne1", "col2:ligne2"};

        TableLayout table = (TableLayout) findViewById(R.id.tabDonnées);
        TableRow row; //création d'un élément : ligne
        TextView tv1, tv2; // création des cellules

        //pour chaque ligne
        for (int i=0;i<col1.length;i++)
        {
            row = new TableRow(this); //création d'une nouvelle ligne

            tv1 = new TextView(this); //création d'une cellule
            tv1.setText(col1[i]); //ajout du texte
            tv1.setGravity(Gravity.CENTER); //centrage dans la cellule
            // adaptation de la largeur de la colonne à l'écran
            tv1.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));

            //2ème cellule
            tv2 = new TextView(this); //création d'une cellule
            tv2.setText(col2[i]); //ajout du texte
            tv2.setGravity(Gravity.CENTER); //centrage dans la cellule
            // adaptation de la largeur de la colonne à l'écran
            tv2.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1));

            // ajout des cellules à la ligne
            row.addView(tv1);
            row.addView(tv2);

            //ajout de la ligne au tableau
            table.addView(row);
        }
    }
}