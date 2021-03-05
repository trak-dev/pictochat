package com.example.pictochat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Chat extends AppCompatActivity {

    private EditText edit;
    long maxid;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Bundle extras = getIntent().getExtras();
        edit = findViewById(R.id.editText);
        Button clean = findViewById(R.id.buttonclean);
        Button add = findViewById(R.id.buttonAdd);
        ListView listView = findViewById(R.id.listView);
        String pseudo = extras.getString("key");
        List<Items> itemsList = new ArrayList<>();
        ArrayList<String> listmessage = new ArrayList<>();
        ArrayList<String> listsenders = new ArrayList<>();
        reff = FirebaseDatabase.getInstance().getReference().child("Room1").child("Messages");
        reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                    if (datasnapshot.exists()) {
                        maxid = (datasnapshot.getChildrenCount());
                        listmessage.clear();
                        listsenders.clear();
                        itemsList.clear();
                        for (int i = 1 ; i <= maxid ; i++) {
                            listmessage.add(datasnapshot.child(String.valueOf(i)).child("Message").getValue().toString());
                            listsenders.add(datasnapshot.child(String.valueOf(i)).child("Sender").getValue().toString());
                        }
                        for (int j = 0 ; j < maxid ; j++) {
                            itemsList.add(new Items(""+ listmessage.get(j),""+ listsenders.get(j), ""+pseudo));
                        }
                        listView.setAdapter(new ListAdapter( Chat.this,itemsList));
                        listView.setSelection(listView.getAdapter().getCount()-1);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        add.setOnClickListener((v) -> {
            String txt_name = edit.getText().toString();
            if (txt_name.isEmpty()){
                Toast.makeText(Chat.this, "Champ vide ! ", Toast.LENGTH_SHORT).show();
            }else {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("Sender",pseudo);
                hashMap.put("Message" ,txt_name);
                FirebaseDatabase.getInstance().getReference().child("Room1").child("Messages").child(String.valueOf(maxid+1)).setValue(hashMap);
                //listView.setSelection(listView.getAdapter().getCount()-1);
                edit.setText("");
            }
        });
        clean.setOnClickListener((v) -> {
            edit.setText("");
        });
    }
}