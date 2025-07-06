package com.example.sqlapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button buttonClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClick = findViewById(R.id.button_click);

        buttonClick.setOnClickListener(v -> {
            SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, age INTEGER, UNIQUE (name))");
            db.execSQL("INSERT INTO users VALUES ('Olga', 21),('Victor',35)");

            Cursor query = db.rawQuery("SELECT * FROM users", null);

            TextView textView = findViewById(R.id.sample_text);
            textView.setText("");

            while (query.moveToNext()){
               String name = query.getString(0);
               int age = query.getInt(1);
               textView.append("Name: " + name + " Age" + age + "\n");
            }
            query.close();
            db.close();
        });
    }
}