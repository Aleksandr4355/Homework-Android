package com.example.gamexo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class PlayingField extends AppCompatActivity {

    private final List<int[]> combinationList = new ArrayList<>();

    private TextView playerOneName;
    private TextView playerTwoName;

    private int activePlayer = 1;
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;

    private int currentScoreOne = 0;
    private int currentScoreTwo = 0;
    private int totalSelectBoxes = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_field);
        changePlayerTurn(activePlayer);

        playerOneName = findViewById(R.id.playerOneName);
        playerTwoName = findViewById(R.id.playerTwoName);

        combinationList.add(new int[]{0, 1, 2});
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{1, 4, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{0, 4, 8});
        combinationList.add(new int[]{2, 4, 6});

        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(0)) {
                    perFormAction((ImageView) v, 0);
                }
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(1)) {
                    perFormAction((ImageView) v, 1);
                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(2)) {
                    perFormAction((ImageView) v, 2);
                }
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(3)) {
                    perFormAction((ImageView) v, 3);
                }
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(4)) {
                    perFormAction((ImageView) v, 4);
                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(5)) {
                    perFormAction((ImageView) v, 5);
                }
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(6)) {
                    perFormAction((ImageView) v, 6);
                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(7)) {
                    perFormAction((ImageView) v, 7);
                }
            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(8)) {
                    perFormAction((ImageView) v, 8);
                }
            }
        });
    }

    private void perFormAction(ImageView imageView, int selectedBoxPosition) {
        boxPositions[selectedBoxPosition] = activePlayer;
        imageView.setBackgroundResource(R.drawable.while_box);
        imageView.setScaleType(ImageView.ScaleType.CENTER);

        playerOneName = findViewById(R.id.playerOneName);
        playerTwoName = findViewById(R.id.playerTwoName);

        TextView scorePlayerA = findViewById(R.id.scoreOne);
        TextView scorePlayerB = findViewById(R.id.scoreTwo);

        if (activePlayer == 1) {
            imageView.setImageResource(R.drawable.ximage);

            if (checkResult()) {
                ResultDialog resultDialog = new ResultDialog(PlayingField.this, playerOneName.getText().toString() + " is a Winner!", PlayingField.this);
                resultDialog.setCancelable(false);
                resultDialog.show();

                currentScoreOne++;
                scorePlayerA.setText(String.valueOf(currentScoreOne));

            } else if (totalSelectBoxes == 9) {
                ResultDialog resultDialog1 = new ResultDialog(PlayingField.this, "Match Draw", PlayingField.this);
                resultDialog1.setCancelable(false);
                resultDialog1.show();
            } else {
                changePlayerTurn(2);
                totalSelectBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.oimage);

            if (checkResult()) {
                ResultDialog resultDialog = new ResultDialog(PlayingField.this, playerTwoName.getText().toString() + " is a Winner!", PlayingField.this);
                resultDialog.setCancelable(false);
                resultDialog.show();

                currentScoreTwo++;
                scorePlayerB.setText(String.valueOf(currentScoreTwo));

            } else if (totalSelectBoxes == 9) {
                ResultDialog resultDialog1 = new ResultDialog(PlayingField.this, "Match Draw", PlayingField.this);
                resultDialog1.setCancelable(false);
                resultDialog1.show();
            } else {
                changePlayerTurn(1);
                totalSelectBoxes++;
            }
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

    private void changePlayerTurn(int currentPlayerTurn) {
        activePlayer = currentPlayerTurn;

        LinearLayout playerOneLayoutOuter = findViewById(R.id.playerOneLayoutOuter);
        LinearLayout playerTwoLayoutOuter = findViewById(R.id.playerTwoLayoutOuter);

        if (activePlayer == 1) {
            playerOneLayoutOuter.setBackgroundResource(R.drawable.blue_border);
            playerTwoLayoutOuter.setBackgroundResource(R.drawable.while_box);
        } else {
            playerTwoLayoutOuter.setBackgroundResource(R.drawable.red_border);
            playerOneLayoutOuter.setBackgroundResource(R.drawable.while_box);
        }
    }

    private boolean isBoxSelectable(int boxPosition) {
        boolean response = false;
        if (boxPositions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }

    public void restartMatch() {
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        activePlayer = 1;
        totalSelectBoxes = 1;

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        image1.setImageResource(R.drawable.while_box);
        image2.setImageResource(R.drawable.while_box);
        image3.setImageResource(R.drawable.while_box);
        image4.setImageResource(R.drawable.while_box);
        image5.setImageResource(R.drawable.while_box);
        image6.setImageResource(R.drawable.while_box);
        image7.setImageResource(R.drawable.while_box);
        image8.setImageResource(R.drawable.while_box);
        image9.setImageResource(R.drawable.while_box);
    }
}