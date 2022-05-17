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

public class restaurantsites extends Fragment {
    private final ArrayList<Word> words = new ArrayList<>();
    private ListView listView;
    private WordAdapter wordAdapterClass;

    public restaurantsites() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.word_list, container, false);


        words.add(new Word("Abu El Seid Restaurant", R.drawable.abu_el_seid_restaurant, 30.0594, 31.2242));
        words.add(new Word("Nola Sweets Restaurant", R.drawable.nola_sweets_restaurant, 30.0614, 31.2227));
        words.add(new Word("Bella Restaurant", R.drawable.bella_restaurant, 30.0363, 31.2295));
        words.add(new Word("Ristorante Tuscany", R.drawable.ristorante_tuscany, 30.0571, 31.2246));
        words.add(new Word("El-Fishawy Cafe", R.drawable.el_fishawy_cafe, 30.0474, 31.2623));

        listView = (ListView) view.findViewById(R.id.list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                Uri uri = Uri.parse("geo:" + word.getLatitude() + ","
                        + word.getLongtude() + "?z=16");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        wordAdapterClass = new WordAdapter(getActivity(), words, R.color.category_Restaurants);
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
