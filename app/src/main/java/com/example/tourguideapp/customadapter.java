package com.example.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class customadapter extends ArrayAdapter<Word> {

    private AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());

    public customadapter(@NonNull Context context, ArrayList<Word> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word word = getItem(position);
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageResource(word.getmImageResourceId());

        TextView textView = (TextView) view.findViewById(R.id.landmark_text_view);
        textView.setText(word.getMlandmark());

        return view;
    }

}
