package com.example.pictochat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
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

        findViewById(R.id.buttonCreerSalon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }
    
    private void showDialog(){

        TextView txtViewMdp = (TextView)findViewById(R.id.textMdpDialog);
        EditText editTextMdp = (EditText) findViewById(R.id.editMdpDialog);
        AlertDialog.Builder builder = new AlertDialog.Builder(Creation_room.this,R.style.AlertDialogTheme);
        View view= LayoutInflater.from(Creation_room.this).inflate(
                R.layout.activity_dialog,
                (ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);

                /*switch(){
                    //private a 0 ou 1
                    case R.id.radioButtonNon:
                        if()// la condition si le private est a 1
                            //si non est checked
                                ((TextView) view.findViewById(R.id.textTitreDialog)).setText(getResources().getString(R.string.dialog_titre_private_room));
                                ((TextView) view.findViewById(R.id.textMdpDialog)).setText(getResources().getString(R.string.textView_mdp));
                                txtViewMdp.setVisibility(view.VISIBLE);
                                editTextMdp.setVisibility(view.VISIBLE);
                            break;

                    case R.id.radioButtonOui:
                        if()        // la condition si le private est a 0
                                    //si oui
                            ((TextView) view.findViewById(R.id.textTitreDialog)).setText(getResources().getString(R.string.dialog_titre));
                            break;
                }
                */
        
        ((TextView) view.findViewById(R.id.textPseudo)).setText(getResources().getString(R.string.textView_pseudo));
        ((Button) view.findViewById(R.id.buttonDialog)).setText(getResources().getString(R.string.button_dialog));

        AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        if(alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        alertDialog.show();
    }
}

