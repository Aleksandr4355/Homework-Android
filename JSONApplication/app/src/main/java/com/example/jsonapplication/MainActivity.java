package com.example.jsonapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

//        Student student = new Student("Anna", "anna@gmail.com", 25);
//        String json = gson.toJson(student);
//     System.out.println(json);
//        Log.d(TAG, json); //вывод информации

        String data = "{\"age\":25,\"email\":\"anna@gmail.com\",\"name\":\"Anna\"}";
        Student student = gson.fromJson(data, Student.class);
        Log.d(TAG, student.toString());

    }
}