package com.example.fragmentmenuapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FouthPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FouthPage extends Fragment {

    TextView textView, textViewLang;
    NumberPicker numberPicker, numberPickerLand;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fouth_page, container, false);

        textView = view.findViewById(R.id.textViewNumberPicked);
        numberPicker = view.findViewById(R.id.number_picked);

        numberPicker.setMaxValue(10);
        numberPicker.setMinValue(0);
        numberPicker.setValue(5);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                textView.setText("Selected: " + newVal);
            }
        });

        textView = view.findViewById(R.id.textViewCountryPicked);
        numberPickerLand = view.findViewById(R.id.city_picked);

         Language.initLanguages();

         numberPickerLand.setMaxValue(Language.getLanguageArrayList().size() - 1);
         numberPickerLand.setMinValue(0);
         numberPickerLand.setDisplayedValues(Language.languageNames());

         numberPickerLand.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
             @Override
             public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                 textView.setText("Selected: " + Language.getLanguageArrayList().get(newVal).getName());
             }
         });

        return view;
    }
}