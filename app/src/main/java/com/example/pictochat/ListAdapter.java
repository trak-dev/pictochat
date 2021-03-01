package com.example.pictochat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter     {
    private Context context;
    private List<Items> itemsList;
    private LayoutInflater inflater;

    public ListAdapter(Context context, List<Items> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Items getItem(int position) {
        return itemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.list_item, null);
        Items currentItem = getItem(position);
        String sender = currentItem.getSender();
        String message = currentItem.getMessage();

        TextView userText = convertView.findViewById(R.id.user);
        userText.setText(sender);

        TextView mesageText = convertView.findViewById(R.id.message);
        mesageText.setText(message);
        return convertView;
    }
}
