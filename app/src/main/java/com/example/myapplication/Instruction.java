//Onglet instruction de la partie
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instruction extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        Button annuler = (Button) findViewById(R.id.precedent_button);
        annuler.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Instruction.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
