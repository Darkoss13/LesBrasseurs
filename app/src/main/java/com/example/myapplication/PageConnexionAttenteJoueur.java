//Page qui permet de regrouper les joueurs et d'attendre que tous le monde soient connectés à la partie pour pouvoir la lancer
//Cette page demande uniquement des ressources réseaux
//Les 4 joueurs doivent être synchronisés en même à une partie et le Maître du jeu doit pouvoir la lancer quand les joueurs ont
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PageConnexionAttenteJoueur extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_connexion_attente_joueur);
    }
}
