package com.example.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EnemySelectionScreen extends AppCompatActivity {

    private String fieldSize = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enemy_selection_screen);

        Button player_player = findViewById(R.id.player_player);
        Button player_computer = findViewById(R.id.player_computer);

        player_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!fieldSize.equals("0")) {
                    Intent intent = new Intent(EnemySelectionScreen.this, PlayerNameInput.class);
                    intent.putExtra("fieldSizePlayer", fieldSize);
                    startActivity(intent);
                }else {
                    Toast.makeText(EnemySelectionScreen.this, "select field size", Toast.LENGTH_SHORT).show();
                }
            }
        });

        player_computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!fieldSize.equals("0")) {
                        Intent intent = new Intent(EnemySelectionScreen.this, PlayerComputerComplexity.class);
                        intent.putExtra("fieldSizeComputer", fieldSize);
                        startActivity(intent);
                }else {
                    Toast.makeText(EnemySelectionScreen.this, "select field size", Toast.LENGTH_SHORT).show();
                }
            }
        });

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButtonFieldSize3) {
                    fieldSize = "3";
                } else if (checkedId == R.id.radioButtonFieldSize5) {
                    fieldSize = "5";
                }
            }
        });

//        field_3x3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fieldSize = "3";
//                field_5x5.setEnabled(false);
//                if (!field_3x3.isChecked()) {
//                    field_5x5.setEnabled(true);
//                }
//
//            }
//        });
//
//        field_5x5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fieldSize = "5";
//                field_3x3.setEnabled(false);
//                if (!field_5x5.isChecked()) {
//                    field_3x3.setEnabled(true);
//                }
//            }
//        });


    }
}