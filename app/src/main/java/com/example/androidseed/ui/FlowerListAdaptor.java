package com.example.androidseed.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidseed.R;
import com.example.androidseed.models.Flower;
import com.squareup.picasso.Picasso;

/**
 * Created by asangamanage on 19/05/2016.
 */
public class FlowerListAdaptor extends ArrayAdapter<Flower> {

    final String IMAGE_HOST_URL = "http://services.hanselandpetal.com/photos/";

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
        ImageView imgFlower = (ImageView) convertView.findViewById(R.id.imgFlower);
        String url = IMAGE_HOST_URL + flower.photo;
        Picasso.with(getContext()).load(url).placeholder(android.R.drawable.ic_notification_overlay).into(imgFlower);
        txtFlowerName.setText(flower.name);
        txtFlowerDescription.setText(flower.category);
        return convertView;
    }

}
