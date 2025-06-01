package com.example.fragmentmenuapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdPage extends Fragment {

    SearchView  searchView;
    ListView listView;

    ArrayAdapter <String> adapter;

    ArrayList <String> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three_page, container, false);

        searchView  = view.findViewById(R.id.search);
        listView = view.findViewById(R.id.list_view);

        arrayList = new ArrayList<>();
        arrayList.add("Архангелськ");
        arrayList.add("Ворониж");
        arrayList.add("Астрахань");
        arrayList.add("Владимир");
        arrayList.add("Волгород");
        arrayList.add("Ставраполь");
        arrayList.add("Адлер");
        arrayList.add("Выборог");
        arrayList.add("Самара");
        arrayList.add("Смоленск");

        adapter = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return view;
    }
}