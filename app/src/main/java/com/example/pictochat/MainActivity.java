package com.example.pictochat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText pseudo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnadd = findViewById(R.id.btnadd);
        pseudo = findViewById(R.id.editPseudo);
        btnadd.setOnClickListener(v -> {
            String pseudoValue = pseudo.getText().toString();
            if (pseudoValue.isEmpty()){
                Toast.makeText(MainActivity.this, "peudo invalide" + pseudoValue, Toast.LENGTH_SHORT).show();
            } else {
                chat();
            }
        });
    }
    public void chat() {
        String pseudoValue = pseudo.getText().toString();
        Intent intent = new Intent(this, Chat.class);
        intent.putExtra("key",pseudoValue);
        startActivity(intent);
    }
}