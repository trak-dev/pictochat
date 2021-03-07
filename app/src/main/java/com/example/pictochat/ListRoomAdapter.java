package com.example.pictochat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListRoomAdapter extends BaseAdapter     {
    private Context context;
    private List<Room> itemsList;
    private LayoutInflater inflater;

    public ListRoomAdapter(Context context, List<Room> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Room getItem(int position) {
        return itemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams", "SetTextI18n"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Room currentItem = getItem(position);
        String name = currentItem.getName();
        String password = currentItem.getPassword();
        Long messages = currentItem.getCompte_messages();
        Integer status = currentItem.getStatus();
            convertView = inflater.inflate(R.layout.list_item_room, null);
            TextView roomName = convertView.findViewById(R.id.room_name);
            roomName.setText(name);
            TextView numberMessages = convertView.findViewById(R.id.room_members);
            numberMessages.setText(messages + " Messages");
        ImageView lock = convertView.findViewById(R.id.room_status_locked);
        if (status.equals(1)) {
            lock.setVisibility(View.VISIBLE);
        }else {
            lock.setVisibility(View.INVISIBLE);
        }

        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(context, JoinRoom.class);
            intent.putExtra("room", name);
            intent.putExtra("status", status);
            intent.putExtra("password", password);
            context.startActivity(intent);
        });
        return convertView;
    }
}

