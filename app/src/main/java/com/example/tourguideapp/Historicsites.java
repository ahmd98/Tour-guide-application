package com.example.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class Historicsites extends Fragment {

    private final ArrayList<Word> words = new ArrayList<>();
    private ListView listView;
    private WordAdapter wordAdapter;

    public Historicsites() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.word_list, container, false);

        words.add(new Word("The Pyramids", R.drawable.the_pyramids, 29.9773, 31.1325));
        words.add(new Word("Mohamed Ali Masjid", R.drawable.mohamed_ali_masjid, 30.0287, 31.2599));
        words.add(new Word("The Azhar Masjed", R.drawable.azhar_masjid, 30.0457, 31.2627));
        words.add(new Word("The Baron Palace", R.drawable.baron_palace, 30.0867, 31.3303));
        words.add(new Word("The Babylon Fortress", R.drawable.babylon_fortress, 30.0059, 31.2301));
        words.add(new Word("The Coptic Museum", R.drawable.coptic_museum, 30.0060, 31.2302));
        words.add(new Word("The Egyptian Museum", R.drawable.egyptian_museum, 30.0478, 31.2336));
        words.add(new Word("The Cairo Tower", R.drawable.cairo_tower, 30.0459, 31.2243));

        listView = (ListView) view.findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                Uri uri = Uri.parse("geo:" + word.getLatitude() + "," + word.getLongtude() + "?z=16");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        wordAdapter = new WordAdapter(getActivity(), words, R.color.category_Historic);
        listView.setAdapter(wordAdapter);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        words.clear();
        wordAdapter.notifyDataSetChanged();
    }
}
