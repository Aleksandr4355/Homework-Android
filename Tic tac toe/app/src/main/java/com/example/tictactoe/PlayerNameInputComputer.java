package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerNameInputComputer extends AppCompatActivity {

    private String computer = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_computer_name_input);

        EditText playerNameOne;
        Button butStart;

        String getFieldSize = getIntent().getStringExtra("fieldSizeComputer");

        playerNameOne = findViewById(R.id.player_name_one_computer);
        butStart = findViewById(R.id.butStartComputer);

        butStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getPlayerNameOne = playerNameOne.getText().toString();

                if (getPlayerNameOne.isEmpty()) {
                    Toast.makeText(PlayerNameInputComputer.this, "Please enter player name", Toast.LENGTH_SHORT).show();
                } else {
                    if(getFieldSize.equals("3")){
                        Intent intent = new Intent(PlayerNameInputComputer.this, ScreenGame3x3.class);
                        intent.putExtra("playerNameOne", getPlayerNameOne);
                        intent.putExtra("computer", computer);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(PlayerNameInputComputer.this, ScreenGame5X5.class);
                        intent.putExtra("playerNameOne", getPlayerNameOne);
                        intent.putExtra("computer", computer);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}