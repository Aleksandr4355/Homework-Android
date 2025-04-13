package com.example.third;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private int pressingButtonSum = 0;
    private Chronometer chronometer;

    private boolean checkStart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button but1 = findViewById(R.id.button1);
        Button but2 = findViewById(R.id.button2);
        Button but3 = findViewById(R.id.button3);
        Button but4 = findViewById(R.id.button4);
        Button but5 = findViewById(R.id.button5);
        Button but6 = findViewById(R.id.button6);
        Button but7 = findViewById(R.id.button7);
        Button but8 = findViewById(R.id.button8);
        Button but9 = findViewById(R.id.button9);

        Button buttonStart = findViewById(R.id.buttonStartGame);
        Button buttonClear = findViewById(R.id.buttonClear);

        chronometer = findViewById(R.id.chronometer);

        SwitchCompat switchCompat = findViewById(R.id.switchCompat1);

        but1.setOnClickListener(v -> {
            if (checkStart) {
                but1.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg1)));
                but1.setEnabled(false);
                pressingButtonSum++;
                StopGame();
            }
        });
        but2.setOnClickListener(v -> {
            if (checkStart) {
                but2.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg1)));
                but2.setEnabled(false);
                pressingButtonSum++;
                StopGame();
            }
        });
        but3.setOnClickListener(v -> {
            if (checkStart) {
                but3.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg1)));
                but3.setEnabled(false);
                pressingButtonSum++;
                StopGame();
            }

        });
        but4.setOnClickListener(v -> {
            if (checkStart) {
                but4.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg1)));
                but4.setEnabled(false);
                pressingButtonSum++;
                StopGame();
            }


        });
        but5.setOnClickListener(v -> {
            if (checkStart) {
                but5.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg1)));
                but5.setEnabled(false);
                pressingButtonSum++;
                StopGame();
            }
        });
        but6.setOnClickListener(v -> {
            if (checkStart) {
                but6.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg1)));
                but6.setEnabled(false);
                pressingButtonSum++;
                StopGame();
            }

        });
        but7.setOnClickListener(v -> {
            if (checkStart) {
                but7.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg1)));
                but7.setEnabled(false);
                pressingButtonSum++;
                StopGame();
            }

        });
        but8.setOnClickListener(v -> {
            if (checkStart) {
                but8.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg1)));
                but8.setEnabled(false);
                pressingButtonSum++;
                StopGame();
            }

        });
        but9.setOnClickListener(v -> {
            if (checkStart) {
                but9.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg1)));
                but9.setEnabled(false);
                pressingButtonSum++;
                StopGame();
            }
        });

        buttonStart.setOnClickListener(v -> {
            checkStart = true;
            chronometer.start();
            buttonStart.setEnabled(false);
        });

        buttonClear.setOnClickListener(v -> {
            chronometer.setBase(SystemClock.elapsedRealtime());

            but1.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg)));
            but2.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg)));
            but3.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg)));
            but4.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg)));
            but5.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg)));
            but6.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg)));
            but7.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg)));
            but8.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg)));
            but9.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.bg)));

            but9.setEnabled(true);
            but1.setEnabled(true);
            but2.setEnabled(true);
            but3.setEnabled(true);
            but4.setEnabled(true);
            but5.setEnabled(true);
            but6.setEnabled(true);
            but7.setEnabled(true);
            but8.setEnabled(true);
            but9.setEnabled(true);

            buttonStart.setEnabled(true);

            pressingButtonSum = 0;

            checkStart = false;
        });

        ConstraintLayout constraintlayout = findViewById(R.id.main1);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    constraintlayout.setBackgroundColor(Color.parseColor("#FFFFB8"));
                } else {
                    constraintlayout.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                }
            }
        });
    }

    private void StopGame() {
        if (pressingButtonSum == 9) {
            chronometer.stop();
        }
    }
}