package com.example.androidseed.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.androidseed.R;
import com.example.androidseed.models.Flower;

/**
 * Created by asangamanage on 19/05/2016.
 */
public class FlowerListAdaptor extends ArrayAdapter<Flower> {
    public FlowerListAdaptor(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Flower flower = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.flowerlistitem, parent, false);
        }
        TextView txtFlowerName = (TextView) convertView.findViewById(R.id.txtFlowerName);
        TextView txtFlowerDescription = (TextView) convertView.findViewById(R.id.txtFlowerDescription);
        txtFlowerName.setText(flower.name);
        txtFlowerDescription.setText(flower.category);
        return convertView;
    }
}
