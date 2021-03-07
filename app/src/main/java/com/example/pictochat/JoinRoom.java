package com.example.pictochat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class JoinRoom extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Bundle extras = getIntent().getExtras();
        String room = extras.getString("room");
        int status = extras.getInt("status");
        String password = extras.getString("password");
        EditText editPseudo = findViewById(R.id.editPseudo);
        TextView textView = findViewById(R.id.textMdpDialog);
        EditText passwordArea = findViewById(R.id.editMdpDialog);
        Button validate = findViewById(R.id.buttonDialog);
        if  (status == 1) {
            textView.setVisibility(View.VISIBLE);
            passwordArea.setVisibility(View.VISIBLE);
            validate.setOnClickListener(v -> {
                if (passwordArea.getText().toString().equals(password)){
                    Intent intent = new Intent(this, Chat.class);
                    intent.putExtra("room", room);
                    intent.putExtra("pseudo",editPseudo.getText().toString());
                    startActivity(intent);
                }   else {
                    Toast.makeText(this, "Mot de passe incorrect ! ", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            textView.setVisibility(View.GONE);
            passwordArea.setVisibility(View.GONE);
            passwordArea.setText(password);
            validate.setOnClickListener(v -> {
                if (editPseudo.getText().toString().isEmpty()){
                    Toast.makeText(this, "Merci de saisir un pseudo ! ", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(this, Chat.class);
                    intent.putExtra("room", room);
                    intent.putExtra("pseudo",editPseudo.getText().toString());
                    startActivity(intent);
                }
            });
        }
    }
}
