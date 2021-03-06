package com.example.pictochat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Creation_room extends AppCompatActivity {
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_room);
        TextView roomName = (TextView) findViewById(R.id.editTextSalonName);
        TextView txtView = (TextView) findViewById(R.id.textViewMdpRoom);
        EditText password = (EditText) findViewById(R.id.editTextMdpRoom);
        RadioButton non = (RadioButton) findViewById(R.id.radioButtonNon);
        RadioButton oui = (RadioButton) findViewById(R.id.radioButtonOui);
        password.setText("null");

        non.setOnClickListener(v -> {
                txtView.setVisibility(View.VISIBLE);
        password.setVisibility(View.VISIBLE);
        oui.setChecked(false);
        password.setText("");
        });
        oui.setOnClickListener(v -> {
                txtView.setVisibility(View.INVISIBLE);
        password.setVisibility(View.INVISIBLE);
        password.setText("null");
        });

        findViewById(R.id.buttonCreerSalon).setOnClickListener(v -> {
            if (roomName.getText().toString().isEmpty()) {
                Toast.makeText(Creation_room.this, "Merci de saisir un nom de salle ! ", Toast.LENGTH_SHORT).show();
            } else if (non.isChecked()) {
                if (password.getText().toString().isEmpty() || password.getText().toString().equals("")) {
                    Toast.makeText(Creation_room.this, "Merci de saisir un mot de passe ! ", Toast.LENGTH_SHORT).show();
                } else {
                    showDialog();
                }
            } else {
                showDialog();
            }
        });
    }

    private void showDialog() {

        TextView txtViewMdp = (TextView) findViewById(R.id.textMdpDialog);
        TextView roomName = (TextView) findViewById(R.id.editTextSalonName);
        EditText editTextMdp = (EditText) findViewById(R.id.editMdpDialog);
        EditText passwordEdit = (EditText) findViewById(R.id.editTextMdpRoom);
        String password = passwordEdit.getText().toString();
        String room = roomName.getText().toString();

        AlertDialog.Builder builder = new AlertDialog.Builder(Creation_room.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(Creation_room.this).inflate(
                R.layout.activity_dialog,
                (ConstraintLayout) findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        AlertDialog alertDialog = builder.create();

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        alertDialog.show();
        EditText editPseudo = (EditText) view.findViewById(R.id.editPseudo);
        String pseudo = editPseudo.getText().toString();
        view.findViewById(R.id.buttonDialog).setOnClickListener(v -> goToChat(editPseudo.getText().toString(), password, room));
    }
    public void goToChat(String pseudo, String password, String room) {
        Intent intent = new Intent(this, Chat.class);
        intent.putExtra("pseudo", pseudo);
        intent.putExtra("room", room);
        if (!password.equals("null")) {
            FirebaseDatabase.getInstance().getReference().child(room).child("Password").setValue(password);
            FirebaseDatabase.getInstance().getReference().child(room).child("Private").setValue(1);
            startActivity(intent);
        } else {
            FirebaseDatabase.getInstance().getReference().child(room).child("Password").setValue(password);
            FirebaseDatabase.getInstance().getReference().child(room).child("Private").setValue(0);
            startActivity(intent);
        }
    }
}