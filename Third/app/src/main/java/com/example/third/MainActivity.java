package com.example.third;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        TextView textView = findViewById(R.id.textColor);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton) {
                    textView.setTextColor(Color.parseColor("#009212"));
                } else if (checkedId == R.id.radioButton2) {
                    textView.setTextColor(Color.parseColor("#FF6F00"));
                }
            }
        });
        Button chooseColor = findViewById(R.id.changeColor);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    chooseColor.setBackgroundColor(Color.parseColor("#009212"));
                } else {
                    chooseColor.setBackgroundColor(Color.parseColor("#FF6F00"));
                }
            }
        });

        Switch mySwitch = findViewById(R.id.switch1);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mySwitch.setTextColor(Color.parseColor("#FF6F00"));
                } else {
                    mySwitch.setTextColor(Color.parseColor("#009212"));
                }
            }
        });

        ConstraintLayout constraintLayout = findViewById(R.id.main);
        SwitchMaterial switchMaterial = findViewById(R.id.switchMaterial);

        switchMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchMaterial.isChecked()) {
                    switchMaterial.setThumbDrawable(getDrawable(R.drawable.baseline_add_alarm_24));
                    switchMaterial.setText("Turn on Nitght mode");
                    constraintLayout.setBackgroundResource(R.color.bg);
                    switchMaterial.setThumbTintList(ColorStateList.valueOf(Color.GREEN));
                    switchMaterial.setTrackTintList(ColorStateList.valueOf(Color.parseColor("#004CFF")));
                } else {
                    switchMaterial.setThumbDrawable(getDrawable(R.drawable.baseline_adb_24));
                    switchMaterial.setTrackTintList(ColorStateList.valueOf(Color.parseColor("#FF6F00")));
                    constraintLayout.setBackgroundResource(R.color.yellow);
                }
            }
        });

        TextView sampleTextView = findViewById(R.id.sampleText);
        CheckBox boldCheckBox = findViewById(R.id.boldChecrBox);
        CheckBox italicCheckBox = findViewById(R.id.italicCheckBox2);

        boldCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if(italicCheckBox.isChecked()){
                        sampleTextView.setTypeface(null, Typeface.BOLD_ITALIC);
                    }else{
                        sampleTextView.setTypeface(null, Typeface.BOLD);
                    }
                } else {
                    if (italicCheckBox.isChecked()){
                        sampleTextView.setTypeface(null, Typeface.ITALIC);
                    }else {
                        sampleTextView.setTypeface(null, Typeface.NORMAL);
                    }
                }
            }
        });

        italicCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (boldCheckBox.isChecked()){
                        sampleTextView.setTypeface(null, Typeface.BOLD_ITALIC);
                    }else {
                        sampleTextView.setTypeface(null, Typeface.ITALIC);
                    }
                } else {
                    if (boldCheckBox.isChecked()){
                        sampleTextView.setTypeface(null, Typeface.BOLD);
                    }else {
                        sampleTextView.setTypeface(null, Typeface.NORMAL);
                    }


                }
            }
        });

//        Button chooseColor = findViewById(R.id.changeColor);
//        chooseColor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                RadioGroup radioGroup = findViewById(R.id.radioGroup);
//                int checkedButtonIndex = radioGroup.getCheckedRadioButtonId();
//                TextView textView  = findViewById(R.id.textColor);
//                if(checkedButtonIndex == R.id.radioButton){
//                    textView.setTextColor(Color.parseColor("#009212"));
//                } else if (checkedButtonIndex == R.id.radioButton2) {
//                    textView.setTextColor(Color.parseColor("#FF6F00"));
//                }
//            }
//        });

    }
}