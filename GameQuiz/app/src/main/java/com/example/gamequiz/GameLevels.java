package com.example.gamequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_levels);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(GameLevels.this,MainActivity.class);
            startActivity(intent);
        });

        TextView textView1 = findViewById(R.id.textView1);
        textView1.setOnClickListener(v -> {
            Intent intent = new Intent(GameLevels.this, Level1.class);
            startActivity(intent);
        });

    }
}