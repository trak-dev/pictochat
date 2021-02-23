package com.example.pictochat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class Chat extends AppCompatActivity {

    private EditText edit;
    long maxid;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        edit = findViewById(R.id.editText);
        Button add = findViewById(R.id.buttonAdd);
        ListView listView = findViewById(R.id.listView);
        ArrayList<String> list = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item, list);
        listView.setAdapter(adapter);
            reff = FirebaseDatabase.getInstance().getReference().child("Member");
            reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                    if (datasnapshot.exists()) {
                        maxid = (datasnapshot.getChildrenCount());
                    }
                    list.clear();
                    for (DataSnapshot snapshot : datasnapshot.getChildren()){
                        list.add(snapshot.getValue().toString());
                        listView.setSelection(listView.getAdapter().getCount()-1);
                    }
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        add.setOnClickListener((v) -> {
            String txt_name = edit.getText().toString();
            if (txt_name.isEmpty()){
                Toast.makeText(Chat.this, "Champ vide", Toast.LENGTH_SHORT).show();
            }else {
                FirebaseDatabase.getInstance().getReference().child("Member").child(String.valueOf(maxid+1)).setValue(txt_name);
                listView.setSelection(listView.getAdapter().getCount()-1);
                edit.setText("");
            }
        });
    }
}