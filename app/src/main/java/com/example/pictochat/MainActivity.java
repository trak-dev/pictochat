package com.example.pictochat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btncreat,btnsalon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        btncreat = (Button) findViewById(R.id.btncreat);
        btnsalon = (Button) findViewById(R.id.btnrejoindre);
        btncreat.setOnClickListener(v -> openCreat());
        btnsalon.setOnClickListener(v -> openListSalon());
    }
    public void openCreat() {
        Intent intent = new Intent(this,Creation_room.class);
        startActivity(intent);
    }
   public void openListSalon() {
        Intent intent = new Intent(this,List_room.class);
        startActivity(intent);
    }
}