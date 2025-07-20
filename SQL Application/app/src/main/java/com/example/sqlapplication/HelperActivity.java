package com.example.sqlapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.LinkedList;

public class HelperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DBHeLper dbHeLper;
        TextView tvOut;
        EditText eName, eSurname, eYear;
        Button btnAdd, btnGet, btnDel;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);

        dbHeLper = new DBHeLper(this);
        tvOut = findViewById(R.id.tv_out);

        eName = findViewById(R.id.edit_name);
        eSurname = findViewById(R.id.edit_surname);
        eYear = findViewById(R.id.edit_yeas);

        btnAdd = findViewById(R.id.button_add);
        btnGet = findViewById(R.id.button_get);
        btnDel = findViewById(R.id.button_delete);

        btnAdd.setOnClickListener(v -> {
            String name = eName.getText().toString();
            String surName = eSurname.getText().toString();
            int year = Integer.parseInt(eYear.getText().toString());

            Data data = new Data(name,surName,year);
            dbHeLper.addOne(data);

            // очистить поля ввода
            eName.setText("");
            eSurname.setText("");
            eYear.setText("");
        });

        btnGet.setOnClickListener(v -> {
            LinkedList<Data> list = dbHeLper.getAll();
            String text = "";
            for(Data d : list){
                text = text  + d.name + " " + d.surname + " " + d.age + "\n";
            }
            tvOut.setText(text);
        });

        btnDel.setOnClickListener(v -> {
            dbHeLper.deleteAll();
        });
    }
}