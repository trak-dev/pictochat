package com.example.pictochat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Ajout extends AppCompatActivity {
    EditText txtnom,txtprenom,txtville,txtdepartement;
    Button btnsave, btnback;
    DatabaseReference reff;
    Member member;
    long maxid = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        txtnom = (EditText)findViewById(R.id.txtnom);
        txtprenom = (EditText)findViewById(R.id.txtprenom);
        txtville = (EditText)findViewById(R.id.txtville);
        txtdepartement = (EditText)findViewById(R.id.txtdepartement);
        btnsave = (Button) findViewById(R.id.btnsave);
        btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if (datasnapshot.exists())
                    maxid = (datasnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int departement = Integer.parseInt(txtdepartement.getText().toString().trim());
                member.setNom(txtnom.getText().toString().trim());
                member.setPrenom(txtprenom.getText().toString().trim());
                member.setVille(txtville.getText().toString().trim());
                member.setDepartement(departement);
                reff.child(String.valueOf(maxid+1)).setValue(member);
                Toast.makeText(Ajout.this,"data inserted !",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void back() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
