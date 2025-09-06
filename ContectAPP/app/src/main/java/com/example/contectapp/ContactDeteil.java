package com.example.contectapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import java.util.Calendar;
import java.util.Locale;

public class ContactDeteil extends AppCompatActivity {

    private TextView nameTV, phoneTV, emailTV, addedTV, updateTV, noteTV;
    private ImageView profileTV;

    private String id;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_deteil);

        dbHelper = new DBHelper(this);

        Intent intent = getIntent();
        id = intent.getStringExtra("contactId");

        nameTV = findViewById(R.id.name_tv);
        phoneTV = findViewById(R.id.phone_tv);
        emailTV = findViewById(R.id.email_tv);
        addedTV = findViewById(R.id.added_time_tv);
        updateTV = findViewById(R.id.update_time_tv);
        noteTV = findViewById(R.id.note_tv);
        profileTV = findViewById(R.id.profile_tv);

        loadDataById();
    }

    private void loadDataById() {
        String selectQuery= "SELECT * FROM " + Contacts.TABLE_NAME + " WHERE " + Contacts.C_ID + " = \"" + id + "\"";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                String name = "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_NAME));
                String image = "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_IMAGE));
                String phone = "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_PHONE));
                String email = "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_EMAIL));
                String note = "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_NOTE));
                String addTime = "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_ADDED_TIME));
                String updateTime = "" + cursor.getString(cursor.getColumnIndexOrThrow(Contacts.C_UPDATED_TIME));

                Calendar calendar = Calendar.getInstance(Locale.getDefault());
                calendar.setTimeInMillis(Long.parseLong(addTime));
                String  timeAdd = "" + DateFormat.format("dd/MM/yy hh:mm:ss", calendar.getTime());

                calendar.setTimeInMillis(Long.parseLong(updateTime));

                nameTV.setText(name);
                phoneTV.setText(phone);
                emailTV.setText(email);
                noteTV.setText(note);
                addedTV.setText(timeAdd);
                updateTV.setText(updateTime);

                if (image.equals("null")){
                    profileTV.setImageResource(R.drawable.baseline_person_24);
                }else{
                    profileTV.setImageURI(Uri.parse(image));
                }
            }while (cursor.moveToNext());
        }
        db.close();
    }
}