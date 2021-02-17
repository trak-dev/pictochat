package com.example.pictochat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnadd = (Button) findViewById(R.id.btnadd);
        Button btnshow = (Button) findViewById(R.id.btnshow);
        Button buttonlast = (Button) findViewById(R.id.buttonlast);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAjout();
            }
        });
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAffichage();
            }
        });
        buttonlast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testLast();
            }
        });
    }
    public void openAjout() {
        Intent intent = new Intent(this, Ajout.class);
        startActivity(intent);
    }
    public void openAffichage() {
        Intent intent = new Intent(this, Affichage.class);
        startActivity(intent);
    }
    public void testLast() {
        Intent intent = new Intent(this, last.class);
        startActivity(intent);
    }
}