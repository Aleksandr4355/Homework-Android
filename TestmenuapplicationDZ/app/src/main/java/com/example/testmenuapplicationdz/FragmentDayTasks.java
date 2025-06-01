package com.example.testmenuapplicationdz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDayTasks#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDayTasks extends Fragment {
    EditText editText;
    Button add;
    RecyclerView recyclerView;
    List<String> dataList = new ArrayList<>();
    DataAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        editText  = view.findViewById(R.id.editText);
        add = view.findViewById(R.id.add);
        recyclerView = view.findViewById(R.id.recycleView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        adapter = new DataAdapter(dataList);
        recyclerView.setAdapter(adapter);
        add.setOnClickListener(v -> {
            String data = editText.getText().toString();
            dataList.add(data);
            editText.setText("");
            adapter.notifyDataSetChanged();
        });
        return view;
    }
}