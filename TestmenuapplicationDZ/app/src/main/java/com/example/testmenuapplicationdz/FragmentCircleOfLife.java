package com.example.testmenuapplicationdz;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;


public class FragmentCircleOfLife extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_circle_of_life, container, false);

        Spinner spinnerCircle = view.findViewById(R.id.spinner_circle);
       TextView textSpinner = view.findViewById(R.id.text_spinner);

       spinnerCircle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//               int position1 = spinnerCircle.getSelectedItemPosition();
               String description = getDescriptionPosition(position);
               textSpinner.setText(description);
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        return view;
    }

    private String getDescriptionPosition(int position) {
        String [] description =  getResources().getStringArray(R.array.description_of_temp);
        return description[position];
    }
}