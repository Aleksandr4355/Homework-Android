package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EnemySelectionScreen extends AppCompatActivity {

    private int fieldInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enemy_selection_screen);

        Button player_player = findViewById(R.id.player_player);
        Button player_computer = findViewById(R.id.player_computer);
        CheckBox field_3x3 = findViewById(R.id.field_3X3);
        CheckBox field_5x5 = findViewById(R.id.field_5x5);

        player_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (field_3x3.isChecked() || field_5x5.isChecked()) {
                    Intent intent = new Intent(EnemySelectionScreen.this, PlayerNameInput.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(EnemySelectionScreen.this, "select field size", Toast.LENGTH_SHORT).show();
                }
            }
        });

        player_computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (field_3x3.isChecked() || field_5x5.isChecked()) {
                    Intent intent = new Intent(EnemySelectionScreen.this, PlayerComputerComplexity.class);
                    intent.putExtra("fieldSize", fieldInt);
                    startActivity(intent);
                }else {
                    Toast.makeText(EnemySelectionScreen.this, "select field size", Toast.LENGTH_SHORT).show();
                }
            }
        });

        field_3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fieldInt = 3;
                field_5x5.setEnabled(false);
                if (!field_3x3.isChecked()) {
                    field_5x5.setEnabled(true);
                }

            }
        });

        field_5x5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fieldInt = 5;
                field_3x3.setEnabled(false);
                if (!field_5x5.isChecked()) {
                    field_3x3.setEnabled(true);
                }
            }
        });


    }
}