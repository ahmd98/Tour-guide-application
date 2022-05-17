package com.example.tourguideapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Gardensites extends Fragment {

    private final ArrayList<Word> words = new ArrayList<>();
    private ListView listView;
    private WordAdapter wordAdapterClass;

    public Gardensites() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.word_list, container, false);
        words.add(new Word("Japanese Garden", R.drawable.japanese_garden, 29.5056, 31.2025));
        words.add(new Word("Al-Andalus Garden", R.drawable.andalus_garden, 0, 0));
        words.add(new Word("Al-Asmak Garden", R.drawable.asmak_park, 0, 0));
        words.add(new Word("Botanical Garden", R.drawable.botanical_garden, 0, 0));
        words.add(new Word("Family Park", R.drawable.family_park, 0, 0));
        words.add(new Word("International Garden", R.drawable.international_garden, 0, 0));


        listView = (ListView) view.findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (Word.getLatitude() == 0) {
                    Toast.makeText(getContext(), getString(R.string.missing_latitude_longtude), Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                            .setTitle(getString(R.string.dialog_title_location));
                    if (Word.getmImageResourceId() == R.drawable.andalus_garden) {
                        builder.setMessage(R.string.andalus_park_location);
                    } else if (Word.getmImageResourceId() == R.drawable.asmak_park) {
                        builder.setMessage(R.string.asmak_park_location);
                    } else if (Word.getmImageResourceId() == R.drawable.botanical_garden) {
                        builder.setMessage(R.string.orman_botanical_park_location);
                    } else if (Word.getmImageResourceId() == R.drawable.family_park) {
                        builder.setMessage(R.string.family_park_location);
                    } else if (Word.getmImageResourceId() == R.drawable.international_garden) {
                        builder.setMessage(R.string.international_park_location);
                    }
                    builder.show();
                } else {
                    Word word = words.get(position);
                    Uri uri = Uri.parse("geo:" + word.getLatitude() + "," + word.getLongtude() + "?z=16");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

            }
        });
        wordAdapterClass = new WordAdapter(getActivity(), words, R.color.category_Garden);
        listView.setAdapter(wordAdapterClass);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        words.clear();
        wordAdapterClass.notifyDataSetChanged();
    }

}
