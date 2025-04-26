package com.example.tictactoe;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScreenGame3x3 extends AppCompatActivity {

    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
    private final List<int[]> combinationList = new ArrayList<>();
    private final List<int[]> combinationListComputer = new ArrayList<>();
    private int activePlayer = 1;
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int totalSelectBoxes = 1;
    private int currentScoreOne = 0;
    private int currentScoreTwo = 0;

    private int numberProgressComputer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_game_player_player_3x3);

        String computer = getIntent().getStringExtra("computer");

        TextView playerOneName = findViewById(R.id.playerOneName);
        TextView playerTwoName = findViewById(R.id.playerTwoName);

        if (computer.equals("0")) {
            String getPlayerOneName = getIntent().getStringExtra("playerNameOne");
            String getPlayerTwoName = getIntent().getStringExtra("playerNameTwo");
            playerOneName.setText(getPlayerOneName);
            playerTwoName.setText(getPlayerTwoName);
        } else {
            String getPlayerOneName = getIntent().getStringExtra("playerNameOne");
            playerOneName.setText(getPlayerOneName);
            playerTwoName.setText("Computer");
        }


        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        combinationList.add(new int[]{0, 1, 2});
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{1, 4, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{0, 4, 8});
        combinationList.add(new int[]{2, 4, 6});

        changePlayerTurn(activePlayer);

    }

    public void clickTableBox(View view) {
        if (view.getId() == R.id.image1) {
            if (isBoxSelectable(0)) {
                perFormAction((ImageView) view, 0);
            }
        } else if (view.getId() == R.id.image2) {
            if (isBoxSelectable(1)) {
                perFormAction((ImageView) view, 1);
            }
        } else if (view.getId() == R.id.image3) {
            if (isBoxSelectable(2)) {
                perFormAction((ImageView) view, 2);
            }
        } else if (view.getId() == R.id.image4) {
            if (isBoxSelectable(3)) {
                perFormAction((ImageView) view, 3);
            }
        } else if (view.getId() == R.id.image5) {
            if (isBoxSelectable(4)) {
                perFormAction((ImageView) view, 4);
            }
        } else if (view.getId() == R.id.image6) {
            if (isBoxSelectable(5)) {
                perFormAction((ImageView) view, 5);
            }
        } else if (view.getId() == R.id.image7) {
            if (isBoxSelectable(6)) {
                perFormAction((ImageView) view, 6);
            }
        } else if (view.getId() == R.id.image8) {
            if (isBoxSelectable(7)) {
                perFormAction((ImageView) view, 7);
            }
        } else if (view.getId() == R.id.image9) {
            if (isBoxSelectable(8)) {
                perFormAction((ImageView) view, 8);
            }
        }
    }

    private void perFormAction(ImageView imageView, int selectedBoxPosition) {
        String computer = getIntent().getStringExtra("computer");

        if (computer.equals("0")) {
            perFormActionPlayer(imageView, selectedBoxPosition);
        } else {
            perFormActionComputer(imageView, selectedBoxPosition);
        }
    }

    private void perFormActionPlayer(ImageView imageView, int selectedBoxPosition) {
        boxPositions[selectedBoxPosition] = activePlayer;
        imageView.setBackgroundResource(R.drawable.classic_box);
        imageView.setScaleType(ImageView.ScaleType.CENTER);

        TextView playerOneName = findViewById(R.id.playerOneName);
        TextView playerTwoName = findViewById(R.id.playerTwoName);

        TextView scorePlayerA = findViewById(R.id.scoreOne);
        TextView scorePlayerB = findViewById(R.id.scoreTwo);

        if (activePlayer == 1) {
            imageView.setImageResource(R.drawable.ximage);

            if (checkResult()) {
                ResultDialog3x3 resultDialog3x3 = new ResultDialog3x3(ScreenGame3x3.this, playerOneName.getText().toString() + " is a Winner!", ScreenGame3x3.this);
                resultDialog3x3.setCancelable(false);
                resultDialog3x3.show();

                currentScoreOne++;
                scorePlayerA.setText(String.valueOf(currentScoreOne));

            } else if (totalSelectBoxes == 9) {
                ResultDialog3x3 resultDialog3x3 = new ResultDialog3x3(ScreenGame3x3.this, "Match Draw", ScreenGame3x3.this);
                resultDialog3x3.setCancelable(false);
                resultDialog3x3.show();
            } else {
                changePlayerTurn(2);
                totalSelectBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.oimage);

            if (checkResult()) {
                ResultDialog3x3 resultDialog3x3 = new ResultDialog3x3(ScreenGame3x3.this, playerTwoName.getText().toString() + " is a Winner!", ScreenGame3x3.this);
                resultDialog3x3.setCancelable(false);
                resultDialog3x3.show();

                currentScoreTwo++;
                scorePlayerB.setText(String.valueOf(currentScoreTwo));

            } else if (totalSelectBoxes == 9) {
                ResultDialog3x3 resultDialog3x3 = new ResultDialog3x3(ScreenGame3x3.this, "Match Draw", ScreenGame3x3.this);
                resultDialog3x3.setCancelable(false);
                resultDialog3x3.show();
            } else {
                changePlayerTurn(1);
                totalSelectBoxes++;
            }
        }
    }

    private void perFormActionComputer(ImageView imageView, int selectedBoxPosition) {
        TextView playerOneName = findViewById(R.id.playerOneName);
        TextView scorePlayerA = findViewById(R.id.scoreOne);
        TextView scorePlayerB = findViewById(R.id.scoreTwo);
        imageView.setBackgroundResource(R.drawable.classic_box);
        imageView.setScaleType(ImageView.ScaleType.CENTER);

        boxPositions[selectedBoxPosition] = activePlayer;
        imageView.setImageResource(R.drawable.ximage);

        if (checkResult()) {
            ResultDialog3x3 resultDialog3x3 = new ResultDialog3x3(ScreenGame3x3.this, playerOneName.getText().toString() + " is a Winner!", ScreenGame3x3.this);
            resultDialog3x3.setCancelable(false);
            resultDialog3x3.show();
            currentScoreOne++;
            scorePlayerA.setText(String.valueOf(currentScoreOne));
        } else if (totalSelectBoxes == 9) {
            ResultDialog3x3 resultDialog3x3 = new ResultDialog3x3(ScreenGame3x3.this, "Match Draw", ScreenGame3x3.this);
            resultDialog3x3.setCancelable(false);
            resultDialog3x3.show();
        }
        totalSelectBoxes++;
        changePlayerTurn(2);

        if (totalSelectBoxes < 9) {

            progressComputer();
            if (checkResult()) {
                ResultDialog3x3 resultDialog3x3 = new ResultDialog3x3(ScreenGame3x3.this, "Computer is a Winner!", ScreenGame3x3.this);
                resultDialog3x3.setCancelable(false);
                resultDialog3x3.show();
                currentScoreTwo++;
                scorePlayerB.setText(String.valueOf(currentScoreTwo));
            }
            totalSelectBoxes++;
            changePlayerTurn(1);
        }
    }

    private void progressComputer() {
        ImageView[] arrayImage = {image1, image2, image3, image4, image5, image6, image7, image8, image9};
        Random random = new Random();

        do {
            numberProgressComputer = random.nextInt(9);
        } while (!isBoxSelectable(numberProgressComputer));
        boxPositions[numberProgressComputer] = activePlayer;
        arrayImage[numberProgressComputer].setBackgroundResource(R.drawable.classic_box);
        arrayImage[numberProgressComputer].setScaleType(ImageView.ScaleType.CENTER);
        arrayImage[numberProgressComputer].setImageResource(R.drawable.oimage);
    }

    private boolean isBoxSelectable(int boxPosition) {
        boolean response = false;
        if (boxPositions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        activePlayer = currentPlayerTurn;

        ImageView playerOneLayoutOuter = findViewById(R.id.imageX);
        ImageView playerTwoLayoutOuter = findViewById(R.id.imageO);

        if (activePlayer == 1) {
            playerTwoLayoutOuter.setBackgroundResource(R.drawable.oimage);
            playerOneLayoutOuter.setBackgroundResource(R.drawable.bold_image_x);
        } else {
            playerOneLayoutOuter.setBackgroundResource(R.drawable.ximage);
            playerTwoLayoutOuter.setBackgroundResource(R.drawable.bold_image_0);
        }
    }

    private boolean checkResult() {
        boolean response = false;
        for (int i = 0; i < combinationList.size(); i++) {
            final int[] combination = combinationList.get(i);
            if (boxPositions[combination[0]] == activePlayer && boxPositions[combination[1]] == activePlayer && boxPositions[combination[2]] == activePlayer) {
                response = true;
            }
        }
        return response;
    }

    public void restartMatch() {
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        activePlayer = 1;
        totalSelectBoxes = 1;

        changePlayerTurn(activePlayer);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        image1.setImageResource(R.drawable.classic_box);
        image2.setImageResource(R.drawable.classic_box);
        image3.setImageResource(R.drawable.classic_box);
        image4.setImageResource(R.drawable.classic_box);
        image5.setImageResource(R.drawable.classic_box);
        image6.setImageResource(R.drawable.classic_box);
        image7.setImageResource(R.drawable.classic_box);
        image8.setImageResource(R.drawable.classic_box);
        image9.setImageResource(R.drawable.classic_box);
    }
}