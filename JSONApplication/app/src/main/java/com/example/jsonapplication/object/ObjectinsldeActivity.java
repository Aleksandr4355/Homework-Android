package com.example.jsonapplication.object;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jsonapplication.R;
import com.google.gson.Gson;

public class ObjectinsldeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectinslde);

        Gson gson  = new Gson();
//        Cours cours = new Cours("java", 399);
//        People people = new People("Vadim", "vadim@gmail.com", 20, cours);
//        String json = gson.toJson(people);
//        Log.d("Test", json);

        String json = "{\"age\":20,\"cours\":{\"course_name\":\"java\",\"price\":399},\"email\":\"vadim@gmail.com\",\"name\":\"Vadim\"}";
        People people = gson.fromJson(json, People.class);
        Log.d("Test1", people.toString());

    }
}