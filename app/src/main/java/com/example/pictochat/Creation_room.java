package com.example.pictochat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Creation_room extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_room);
    }

    public void hide(View view) {

        TextView txtView = (TextView)findViewById(R.id.textViewMdpRoom);
        EditText editText = (EditText)findViewById(R.id.editTextMdpRoom);

        Button non = (Button)findViewById(R.id.radioButtonNon);
        Button oui = (Button)findViewById(R.id.radioButtonOui);

        non.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.setVisibility(View.VISIBLE);
                editText.setVisibility(View.VISIBLE);
            }
        });
        oui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.INVISIBLE);
            }
        });
    }
}