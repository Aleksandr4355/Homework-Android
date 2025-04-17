package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScreenGamePlayerPlayer5X5 extends AppCompatActivity {

    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9, image11, image12, image13, image14, image15, image16, image17, image18, image19, image20, image21, image22, image23, image24, image25, image10;
    private final List<int[]> combinationList = new ArrayList<>();
    private int activePlayer = 1;
    private int[] boxPositions = new int[25];
    private int totalSelectBoxes = 1;
    private int currentScoreOne = 0;
    private int currentScoreTwo = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Arrays.fill(boxPositions, 0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_game_player_player_5x5);



        TextView playerOneName = findViewById(R.id.playerOneName);
        TextView playerTwoName = findViewById(R.id.playerTwoName);

        String getPlayerOneName = getIntent().getStringExtra("playerNameOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerNameTwo");

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
        image10 = findViewById(R.id.image10);
        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);
        image13 = findViewById(R.id.image13);
        image14 = findViewById(R.id.image14);
        image15 = findViewById(R.id.image15);
        image16 = findViewById(R.id.image16);
        image17 = findViewById(R.id.image17);
        image18 = findViewById(R.id.image18);
        image19 = findViewById(R.id.image19);
        image20 = findViewById(R.id.image20);
        image21 = findViewById(R.id.image21);
        image22 = findViewById(R.id.image22);
        image23 = findViewById(R.id.image23);
        image24 = findViewById(R.id.image24);
        image25 = findViewById(R.id.image25);

        combinationList.add(new int[]{0, 1, 2, 3, 4});
        combinationList.add(new int[]{5, 6, 7, 8, 9});
        combinationList.add(new int[]{10, 11, 12, 13, 14});
        combinationList.add(new int[]{15, 16, 17, 18, 19});
        combinationList.add(new int[]{20, 21, 22, 23, 24});
        combinationList.add(new int[]{0, 5, 10, 15, 20});
        combinationList.add(new int[]{1, 6, 11, 16, 21});
        combinationList.add(new int[]{2, 7, 12, 17, 22});
        combinationList.add(new int[]{3, 8, 13, 18, 23});
        combinationList.add(new int[]{4, 9, 14, 19, 24});
        combinationList.add(new int[]{0, 7, 13, 19, 24});
        combinationList.add(new int[]{5, 9, 13, 17, 21});
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
        }else if (view.getId() == R.id.image10) {
            if (isBoxSelectable(9)) {
                perFormAction((ImageView) view, 9);
            }
        }else if (view.getId() == R.id.image11) {
            if (isBoxSelectable(10)) {
                perFormAction((ImageView) view, 10);
            }
        }else if (view.getId() == R.id.image12) {
            if (isBoxSelectable(11)) {
                perFormAction((ImageView) view, 11);
            }
        }else if (view.getId() == R.id.image13) {
            if (isBoxSelectable(12)) {
                perFormAction((ImageView) view, 12);
            }
        }else if (view.getId() == R.id.image14) {
            if (isBoxSelectable(13)) {
                perFormAction((ImageView) view, 13);
            }
        }else if (view.getId() == R.id.image15) {
            if (isBoxSelectable(14)) {
                perFormAction((ImageView) view, 14);
            }
        }else if (view.getId() == R.id.image16) {
            if (isBoxSelectable(15)) {
                perFormAction((ImageView) view, 15);
            }
        }else if (view.getId() == R.id.image17) {
            if (isBoxSelectable(16)) {
                perFormAction((ImageView) view, 16);
            }
        }else if (view.getId() == R.id.image18) {
            if (isBoxSelectable(17)) {
                perFormAction((ImageView) view, 17);
            }
        }else if (view.getId() == R.id.image19) {
            if (isBoxSelectable(18)) {
                perFormAction((ImageView) view, 18);
            }
        }else if (view.getId() == R.id.image20) {
            if (isBoxSelectable(19)) {
                perFormAction((ImageView) view, 19);
            }
        }else if (view.getId() == R.id.image21) {
            if (isBoxSelectable(20)) {
                perFormAction((ImageView) view, 20);
            }
        }else if (view.getId() == R.id.image22) {
            if (isBoxSelectable(21)) {
                perFormAction((ImageView) view, 21);
            }
        }else if (view.getId() == R.id.image23) {
            if (isBoxSelectable(22)) {
                perFormAction((ImageView) view, 22);
            }
        }else if (view.getId() == R.id.image24) {
            if (isBoxSelectable(23)) {
                perFormAction((ImageView) view, 23);
            }
        }else if (view.getId() == R.id.image25) {
            if (isBoxSelectable(24)) {
                perFormAction((ImageView) view, 24);
            }
        }
    }

    private void perFormAction(ImageView imageView, int selectedBoxPosition) {
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
                ResultDialog5x5 resultDialog5x5 = new ResultDialog5x5(ScreenGamePlayerPlayer5X5.this, playerOneName.getText().toString() + " is a Winner!", ScreenGamePlayerPlayer5X5.this);
                resultDialog5x5.setCancelable(false);
                resultDialog5x5.show();

                currentScoreOne++;
                scorePlayerA.setText(String.valueOf(currentScoreOne));

            } else if (totalSelectBoxes == 25) {
                ResultDialog5x5 resultDialog5x5 = new ResultDialog5x5(ScreenGamePlayerPlayer5X5.this, "Match Draw", ScreenGamePlayerPlayer5X5.this);
                resultDialog5x5.setCancelable(false);
                resultDialog5x5.show();
            } else {
                changePlayerTurn(2);
                totalSelectBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.oimage);

            if (checkResult()) {
                ResultDialog5x5 resultDialog5x5 = new ResultDialog5x5(ScreenGamePlayerPlayer5X5.this, playerTwoName.getText().toString() + " is a Winner!", ScreenGamePlayerPlayer5X5.this);
                resultDialog5x5.setCancelable(false);
                resultDialog5x5.show();

                currentScoreTwo++;
                scorePlayerB.setText(String.valueOf(currentScoreTwo));

            } else if (totalSelectBoxes == 25) {
                ResultDialog5x5 resultDialog5x5 = new ResultDialog5x5(ScreenGamePlayerPlayer5X5.this, "Match Draw", ScreenGamePlayerPlayer5X5.this);
                resultDialog5x5.setCancelable(false);
                resultDialog5x5.show();
            } else {
                changePlayerTurn(1);
                totalSelectBoxes++;
            }
        }
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
            if (boxPositions[combination[0]] == activePlayer && boxPositions[combination[1]] == activePlayer && boxPositions[combination[2]] == activePlayer && boxPositions[combination[3]] == activePlayer && boxPositions[combination[4]] == activePlayer) {
                response = true;
            }
        }
        return response;
    }

    public void restartMatch() {
        boxPositions = new int[25];
        Arrays.fill(boxPositions, 0);
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
        image10 = findViewById(R.id.image10);
        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);
        image13 = findViewById(R.id.image13);
        image14 = findViewById(R.id.image14);
        image15 = findViewById(R.id.image15);
        image16 = findViewById(R.id.image16);
        image17 = findViewById(R.id.image17);
        image18 = findViewById(R.id.image18);
        image19 = findViewById(R.id.image19);
        image20 = findViewById(R.id.image20);
        image21 = findViewById(R.id.image21);
        image22 = findViewById(R.id.image22);
        image23 = findViewById(R.id.image23);
        image24 = findViewById(R.id.image24);
        image25 = findViewById(R.id.image25);

        image1.setImageResource(R.drawable.classic_box);
        image2.setImageResource(R.drawable.classic_box);
        image3.setImageResource(R.drawable.classic_box);
        image4.setImageResource(R.drawable.classic_box);
        image5.setImageResource(R.drawable.classic_box);
        image6.setImageResource(R.drawable.classic_box);
        image7.setImageResource(R.drawable.classic_box);
        image8.setImageResource(R.drawable.classic_box);
        image9.setImageResource(R.drawable.classic_box);
        image10.setImageResource(R.drawable.classic_box);
        image11.setImageResource(R.drawable.classic_box);
        image12.setImageResource(R.drawable.classic_box);
        image13.setImageResource(R.drawable.classic_box);
        image14.setImageResource(R.drawable.classic_box);
        image15.setImageResource(R.drawable.classic_box);
        image16.setImageResource(R.drawable.classic_box);
        image17.setImageResource(R.drawable.classic_box);
        image18.setImageResource(R.drawable.classic_box);
        image19.setImageResource(R.drawable.classic_box);
        image20.setImageResource(R.drawable.classic_box);
        image21.setImageResource(R.drawable.classic_box);
        image22.setImageResource(R.drawable.classic_box);
        image23.setImageResource(R.drawable.classic_box);
        image24.setImageResource(R.drawable.classic_box);
        image25.setImageResource(R.drawable.classic_box);
    }
}