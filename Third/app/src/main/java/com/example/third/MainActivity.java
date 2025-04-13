package com.example.third;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    private int currentProgress = 0;
    private ProgressBar progressBar;

    private EditText editTextKeyword;
    private ChipGroup chipGroup;

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
        mySwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                mySwitch.setTextColor(Color.parseColor("#FF6F00"));
            } else {
                mySwitch.setTextColor(Color.parseColor("#009212"));
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

        Button buttonForProgress = findViewById(R.id.buttonForProgress);
        buttonForProgress.setOnClickListener(v -> {
            ProgressBar pb =  findViewById(R.id.progressBar);
            pb.setVisibility(View.VISIBLE);
        });

        Button buttonStartProgressHorizontal = findViewById(R.id.startHorizontalProgress);
        progressBar = findViewById(R.id.progressBarHorizontal);

        buttonStartProgressHorizontal.setOnClickListener(v -> {
            currentProgress = currentProgress + 10;
            progressBar.setProgress(currentProgress);
            progressBar.setMax(100);
        });

        editTextKeyword = findViewById(R.id.editTextKeyword);
        chipGroup =findViewById(R.id.chipGroup);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonShow = findViewById(R.id.buttonShow);
        buttonAdd.setOnClickListener(v -> {
            addNewChip();
        });
        buttonShow.setOnClickListener(v -> {
            showSelection();
        });

//        Chip chip1 = findViewById(R.id.chip);
//        chip1.setOnClickListener(v -> {
//            Toast.makeText(this, "Action Completed", Toast.LENGTH_SHORT).show();
//        });


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

    private void showSelection(){
        String s = null;
        int count = chipGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            Chip child = (Chip) chipGroup.getChildAt(i);
            if (!child.isChecked()){
               continue;
            }
            if(s == null){
                s = child.getText().toString();
            }else{
                s += ", " + child.getText().toString();
            }
        }
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
    private void addNewChip(){
        String keyword = editTextKeyword.getText().toString();
        if(keyword.isEmpty()){
            Toast.makeText(this, "Please enter the keyword", Toast.LENGTH_SHORT).show();
            return;
        }
        LayoutInflater inflater = LayoutInflater.from(this);
        Chip newChip = (Chip) inflater.inflate(R.layout.layout_chip_antry,this.chipGroup, false);
        newChip.setText(keyword);
        chipGroup.addView(newChip);
        editTextKeyword.setText("");

        newChip.setOnCloseIconClickListener(v -> {
            handleChipCloseIconClicked((Chip) v);
        });
    }
    private void handleChipCloseIconClicked(Chip chip){
     ChipGroup parent = (ChipGroup) chip.getParent();
     parent.removeView(chip);
    }
}