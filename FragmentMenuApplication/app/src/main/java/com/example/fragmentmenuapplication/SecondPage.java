package com.example.fragmentmenuapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.ViewSwitcher;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondPage extends Fragment {
    EditText date,time;

    ImageButton  beforceButton, nextButton;
    ImageSwitcher imageSwitcher;

    int index = 0;
    int [] mas = {R.drawable.inedible_1,R.drawable.inedible_5,R.drawable.inedible_7,R.drawable.edible_3};
    DatePickerDialog.OnDateSetListener dateSetListener;
    TimePickerDialog.OnTimeSetListener timeSetListener;
    Calendar calendar;

    EditText editText;
    Button add;
    RecyclerView recyclerView;
    List<String> dataList = new ArrayList<>();
    DataAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_page, container, false);

        date = view.findViewById(R.id.dateInput);
        time = view.findViewById(R.id.timeInput);

        date.setFocusable(false);
        time.setFocusable(false);

        date.setOnClickListener(v -> {
            showDateDialog(date);
        });

        time.setOnClickListener(v -> {
            showTimeDialog(time);
        });

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

        beforceButton= view.findViewById(R.id.before);
        nextButton = view.findViewById(R.id.next);
        imageSwitcher = view.findViewById(R.id.imageSwitcher);

        beforceButton.setOnClickListener(v -> {
            index--;
            if (index < 0){
                index = mas.length-1;
            }
            imageSwitcher.setImageResource(mas[index]);
        });
        nextButton.setOnClickListener(v -> {
            index++;
            if (index == mas.length){
                index = 0;
            }
            imageSwitcher.setImageResource(mas[index]);
        });
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getActivity().getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setMaxWidth(250);
                imageView.setMaxWidth(350);
                return imageView;
            }
        });

        imageSwitcher.setImageResource(mas[index]);

        return view;
    }

    private void showTimeDialog(EditText time) {
        calendar = Calendar.getInstance();

        timeSetListener = new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                time.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
        new TimePickerDialog(getContext(), timeSetListener, calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
    }

    private void showDateDialog(EditText date) {
        calendar = Calendar.getInstance();

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

                date.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
        new DatePickerDialog(getContext(), dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}