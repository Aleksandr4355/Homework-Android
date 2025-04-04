package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerComputerComplexity extends AppCompatActivity {

    Button  butEasily;
    Button  butHard;

    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_computer_complexity);
    }
    public void playGame(View view){
        butEasily = findViewById(R.id.butEasily);
        butHard = findViewById(R.id.butHard);
        if(view.getId() == R.id.butEasily){
            level =  1;
            Intent intent = new Intent(PlayerComputerComplexity.this,ScreenGamePlayerComputer.class);
            intent.putExtra("easily", level);
            startActivity(intent);
        } else if (view.getId() == R.id.butHard) {
            level =  2;
            Intent intent = new Intent(PlayerComputerComplexity.this,ScreenGamePlayerComputer.class);
            intent.putExtra("easily", level);
            startActivity(intent);
        }
    }
}