package com.example.lesson_second;

import static android.os.Looper.prepare;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    private MediaPlayer sound1, sound2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageButton img1 = findViewById(R.id.buttonImg1);
        ImageButton img2 = findViewById(R.id.buttonImg2);
        Button butStop = findViewById(R.id.buttonStop);

        sound1 = MediaPlayer.create(this, R.raw.sound_1);
        sound2 = MediaPlayer.create(this, R.raw.sound_2);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayButton(sound1, sound2);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayButton(sound2, sound1);
            }
        });

        Button button = findViewById(R.id.back);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        butStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sound1.isPlaying()) {
                    sound1.stop();
                    try {
                        sound1.prepare();
                        sound1.seekTo(0);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    sound2.stop();
                    try {
                        sound2.prepare();
                        sound2.seekTo(0);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    public void soundPlayButton(MediaPlayer sound1, MediaPlayer sound2) {
        if (sound1.isPlaying()) {
            sound1.pause();
            sound2.seekTo(0);
            sound1.setLooping(false);
        }
        if (sound2.isPlaying()) {
            sound2.pause();
            sound1.seekTo(0);
            sound2.setLooping(false);
        }
        sound1.start();
        sound1.setLooping(true);
    }

//    public void goBack(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }
}