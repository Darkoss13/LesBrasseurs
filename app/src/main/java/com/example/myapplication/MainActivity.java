//Point de départ du programme, permet de choisir entre soit créer une partie, soit en rejoidnre une et d'afficher les instructions si le joueur le
// souhaite
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView create_game, join_game;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Onglet créer une partie
        this.create_game = (TextView) findViewById(R.id.create_game);
        create_game.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent creerPartie = new Intent(getApplicationContext(), CreerPartie.class); //var intend qui permet de démarrer une action et d'effectuer une action (ex: créer une act)
                startActivity(creerPartie); //je lance ma nouvelle activité mais je suis obligé de fermer l'autre
                finish();
            }
        });

        //Onglet rejoindre une partie
        this.join_game = (TextView) findViewById(R.id.join_game);
        join_game.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent rejoindrePartie = new Intent(getApplicationContext(), RejoindrePartie.class);
                startActivity(rejoindrePartie);
                finish();
            }
        });

        final Button instruction = (Button) findViewById(R.id.aide);
        instruction.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent menuAide = new Intent(MainActivity.this, Instruction.class);
                startActivity(menuAide);
                finish();
            }
        });
    }

}
//create_game.setEnabled(false);
//join_game.setEnabled(false);