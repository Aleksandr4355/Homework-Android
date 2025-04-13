package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerNameInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_player_name_input);

        EditText playerNameOne;
        EditText playerNameTwo;
        Button butStart;

        String getFieldSize = getIntent().getStringExtra("fieldSizePlayer");


        playerNameOne = findViewById(R.id.player_name_one);
        playerNameTwo = findViewById(R.id.player_name_two);
        butStart = findViewById(R.id.butStart);

        butStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getPlayerNameOne = playerNameOne.getText().toString();
                String getPlayerNameTwo = playerNameTwo.getText().toString();

                if (getPlayerNameOne.isEmpty() || getPlayerNameTwo.isEmpty()) {
                    Toast.makeText(PlayerNameInput.this, "Please enter player name", Toast.LENGTH_SHORT).show();
                } else {
                    if(getFieldSize.equals("3")){
                        Intent intent = new Intent(PlayerNameInput.this, ScreenGamePlayerPlayer3x3.class);
                        intent.putExtra("playerNameOne", getPlayerNameOne);
                        intent.putExtra("playerNameTwo", getPlayerNameTwo);
                        startActivity(intent);
                    }else  if (getFieldSize.equals("5")){
                        Intent intent = new Intent(PlayerNameInput.this, ScreenGamePlayerPlayer5x5.class);
                        intent.putExtra("playerNameOne", getPlayerNameOne);
                        intent.putExtra("playerNameTwo", getPlayerNameTwo);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}