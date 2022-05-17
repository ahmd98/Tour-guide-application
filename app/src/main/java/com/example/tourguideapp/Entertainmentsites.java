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

/**
 * A simple {@link Fragment} subclass.
 */
public class Entertainmentsites extends Fragment {
    private final ArrayList<Word> words = new ArrayList<>();
    private ListView listView;
    private WordAdapter wordAdapterClass;

    public Entertainmentsites() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.word_list, container, false);

        words.add(new Word("Skate Max", R.drawable.skate_max, 29.9628, 30.9269));
        words.add(new Word("City Stars Cinema", R.drawable.city_stars_cinema, 30.0725, 31.3464));
        words.add(new Word("Galaxy Cinema", R.drawable.galaxy_cinema, 30.0179, 31.2228));
        words.add(new Word("Sun City Cinema", R.drawable.sun_city_cinema, 30.1028, 31.3867));
        words.add(new Word("Fagnoon Village", R.drawable.fagnoon_village, 0, 0));
        words.add(new Word("Kidzanya", R.drawable.kidzanya, 0, 0));
        words.add(new Word("The National Theatre", R.drawable.national_theatre, 0, 0));


        listView = (ListView) view.findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (Word.getLatitude() == 0) {
                    Toast.makeText(getContext(), getString(R.string.missing_latitude_longtude), Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                            .setTitle(getString(R.string.dialog_title_location));

                    if (Word.getmImageResourceId() == R.drawable.fagnoon_village) {
                        builder.setMessage(getString(R.string.fagnoon_location));
                    } else if (Word.getmImageResourceId() == R.drawable.kidzanya) {
                        builder.setMessage(getString(R.string.kidzania_location));
                    } else if (Word.getmImageResourceId() == R.drawable.national_theatre) {
                        builder.setMessage(getString(R.string.national_theatre_location));

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
        wordAdapterClass = new WordAdapter(getActivity(), words, R.color.category_Entertainment);
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
