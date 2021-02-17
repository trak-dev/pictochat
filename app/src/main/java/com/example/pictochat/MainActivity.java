package com.example.pictochat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnadd,btnshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnshow = (Button) findViewById(R.id.btnshow);
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
    }
    public void openAjout() {
        Intent intent = new Intent(this, Ajout.class);
        startActivity(intent);
    }
    public void openAffichage() {
        Intent intent = new Intent(this, Affichage.class);
        startActivity(intent);
    }
}