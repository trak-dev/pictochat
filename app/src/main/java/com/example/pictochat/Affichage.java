package com.example.pictochat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Affichage extends AppCompatActivity {
    TextView last_prenom,last_nom,last_ville,last_departement;
    Button btnback;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
        last_prenom = (TextView)findViewById(R.id.last_prenom);
        last_nom = (TextView)findViewById(R.id.last_nom);
        last_ville = (TextView)findViewById(R.id.last_ville);
        last_departement = (TextView)findViewById(R.id.last_departement);
        btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
        reff = FirebaseDatabase.getInstance().getReference().child("Member").child(String.valueOf("2"));
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                String nom = datasnapshot.child("nom").getValue().toString();
                String ville = datasnapshot.child("ville").getValue().toString();
                String prenom = datasnapshot.child("prenom").getValue().toString();
                String departement = datasnapshot.child("departement").getValue().toString();
                last_prenom.setText(prenom);
                last_nom.setText(nom);
                last_ville.setText(ville);
                last_departement.setText(departement);
            }
// test
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    public void back() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}