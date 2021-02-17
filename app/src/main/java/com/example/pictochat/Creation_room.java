package com.example.pictochat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Creation_room extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_room);

        TextView txtView = (TextView)findViewById(R.id.textViewMdpRoom);
        EditText editText = (EditText)findViewById(R.id.editTextMdpRoom);

        RadioButton non = (RadioButton)findViewById(R.id.radioButtonNon);
        RadioButton oui = (RadioButton)findViewById(R.id.radioButtonOui);

        non.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.setVisibility(v.VISIBLE);
                editText.setVisibility(v.VISIBLE);
                oui.setChecked(false);

            }
        });
        oui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.setVisibility(v.INVISIBLE);
                editText.setVisibility(v.INVISIBLE);
            }
        });
    }
}

