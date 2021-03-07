package com.example.pictochat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class List_room extends AppCompatActivity {
    DatabaseReference reff;
    long maxid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_room);
        ListView listView = findViewById(R.id.listRoom);
        Button retour = findViewById(R.id.button2);
        ArrayList < String > listRooms = new ArrayList<>();
        ArrayList < Integer > liststatus = new ArrayList<>();
        ArrayList < String > listpassword = new ArrayList<>();
        ArrayList < Long > listmessages = new ArrayList<>();
        List < Room > itemsList = new ArrayList < > ();
        reff = FirebaseDatabase.getInstance().getReference();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(List_room.this, android.R.layout.simple_list_item_1, listRooms);
        retour.setOnClickListener(v -> back());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    maxid = (snapshot.getChildrenCount());
                    listpassword.clear();
                    listRooms.clear();
                    liststatus.clear();
                    listmessages.clear();
                    itemsList.clear();
                    for(DataSnapshot ds : snapshot.getChildren()) {
                        listRooms.add(ds.getKey());
                        listpassword.add(ds.child("Password").getValue().toString());
                        liststatus.add(ds.child("Private").getValue(Integer.class));
                        listmessages.add(ds.child("Messages").getChildrenCount());
                    }
                    for (int j = 0; j < maxid; j++) {
                        itemsList.add(new Room("" + listRooms.get(j), liststatus.get(j), ""+ listpassword.get(j), listmessages.get(j) ));
                    }
                    listView.setAdapter(new ListRoomAdapter(List_room.this, itemsList));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        listView.setAdapter(arrayAdapter);
    }
    private void back() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}