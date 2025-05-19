package com.example.themontyhallshow;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Random;

public class ScreenGameActivity extends AppCompatActivity {

    ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
    Dialog dialog;
    AnimationDrawable animationDrawable1, animationDrawable2, animationDrawable3, animationDrawable4, animationDrawable5;

    TextView textDialog;

    private int countCloseSafe = 0;
    private final int[] arraySafe = {0, 0, 0, 0, 0};
    Random random = new Random();
    int numberVictory, number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_game);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);

        ImageView[] arrayImageView = {imageView1, imageView2, imageView3, imageView4, imageView5};

        animationDrawable1 = (AnimationDrawable) imageView1.getDrawable();
        animationDrawable2 = (AnimationDrawable) imageView2.getDrawable();
        animationDrawable3 = (AnimationDrawable) imageView3.getDrawable();
        animationDrawable4 = (AnimationDrawable) imageView4.getDrawable();
        animationDrawable5 = (AnimationDrawable) imageView5.getDrawable();

        windowsDialogPreview();

        numberVictory = random.nextInt(5);

        // обработка нажатия на первую кнопку
        imageView1.setOnClickListener(v -> {
            if (countCloseSafe != 3) {
                if (arraySafe[0] != 1) {
                    do {
                        number = random.nextInt(5);
                    } while (numberVictory == number || arraySafe[number] == 1 || number == 0);
                    arraySafe[number] = 1;

                    // анимация поворота вентиля
//                    arrayImageView[number].setBackgroundResource(R.drawable.animation_turn_handle);
//                    ((AnimationDrawable)  arrayImageView[number].getDrawable()).start();

                    if (countCloseSafe == 0){
                        windowsDialog("И так вы выбрали один из сейфов. Теперь я после каждого вашего хода, буду открывать один пустой сейф. Запомните у вас есть право сменить выбраный сейф. Желаю удачи дорогой гость. ");
                    }
                    arrayImageView[number].setImageResource(R.drawable.safe_empty);
                    countCloseSafe++;
                }
            } else {
                if (numberVictory == 0) {
                    arraySafe[0] = 1;
                    imageView1.setImageResource(R.drawable.safe_full);
                    for (int i = 0; i < arraySafe.length; i++) {
                        if (arraySafe[i] == 0) {
                            arrayImageView[i].setImageResource(R.drawable.safe_empty);
                        }
                    }
                    windowsDialog("Поздравляю, вы выйграли!");
                } else {
                    imageView1.setImageResource(R.drawable.safe_empty);
                    arrayImageView[numberVictory].setImageResource(R.drawable.safe_full);
                    windowsDialog("Оу, какая жалость вы проиграли!");
                }
            }
        });

        // обработка нажатия на вторую кнопку
        imageView2.setOnClickListener(v -> {
            if (countCloseSafe != 3) {
                if (arraySafe[1] != 1) {
                    do {
                        number = random.nextInt(5);
                    } while (numberVictory == number || arraySafe[number] == 1 || number == 1);
                    arraySafe[number] = 1;
                    arrayImageView[number].setImageResource(R.drawable.safe_empty);
                    countCloseSafe++;
                }
            } else {
                if (numberVictory == 1) {
                    arraySafe[1] = 1;
                    imageView2.setImageResource(R.drawable.safe_full);
                    for (int i = 0; i < arraySafe.length; i++) {
                        if (arraySafe[i] == 0) {
                            arrayImageView[i].setImageResource(R.drawable.safe_empty);
                        }
                    }
                    windowsDialog("Поздравляю, вы выйграли!");
                } else {
                    imageView2.setImageResource(R.drawable.safe_empty);
                    arrayImageView[numberVictory].setImageResource(R.drawable.safe_full);
                    windowsDialog("Оу, какая жалость вы проиграли!");
                }
            }
        });

        // обработка нажатия на третью кнопку
        imageView3.setOnClickListener(v -> {
            if (countCloseSafe != 3) {
                if (arraySafe[2] != 1) {
                    do {
                        number = random.nextInt(5);
                    } while (numberVictory == number || arraySafe[number] == 1 || number == 2);
                    arraySafe[number] = 1;
                    arrayImageView[number].setImageResource(R.drawable.safe_empty);
                    countCloseSafe++;
                }
            } else {
                if (numberVictory == 2) {
                    arraySafe[2] = 1;
                    imageView3.setImageResource(R.drawable.safe_full);
                    for (int i = 0; i < arraySafe.length; i++) {
                        if (arraySafe[i] == 0) {
                            arrayImageView[i].setImageResource(R.drawable.safe_empty);
                        }
                    }
                    windowsDialog("Поздравляю, вы выйграли!");
                } else {
                    imageView3.setImageResource(R.drawable.safe_empty);
                    arrayImageView[numberVictory].setImageResource(R.drawable.safe_full);
                    windowsDialog("Оу, какая жалость вы проиграли!");
                }
            }
        });

        // обработка нажатия на четвертую кнопку
        imageView4.setOnClickListener(v -> {
            if (countCloseSafe != 3) {
                if (arraySafe[3] != 1) {
                    do {
                        number = random.nextInt(5);
                    } while (numberVictory == number || arraySafe[number] == 1 || number == 3);
                    arraySafe[number] = 1;
                    arrayImageView[number].setImageResource(R.drawable.safe_empty);
                    countCloseSafe++;
                }
            } else {
                if (numberVictory == 3) {
                    arraySafe[3] = 1;
                    imageView4.setImageResource(R.drawable.safe_full);
                    for (int i = 0; i < arraySafe.length; i++) {
                        if (arraySafe[i] == 0) {
                            arrayImageView[i].setImageResource(R.drawable.safe_empty);
                        }
                    }
                    windowsDialog("Поздравляю, вы выйграли!");
                } else {
                    imageView4.setImageResource(R.drawable.safe_empty);
                    arrayImageView[numberVictory].setImageResource(R.drawable.safe_full);
                    windowsDialog("Оу, какая жалость вы проиграли!");
                }
            }
        });

        // обработка нажатия на пятую кнопку
        imageView5.setOnClickListener(v -> {
            if (countCloseSafe != 3) {
                if (arraySafe[4] != 1) {
                    do {
                        number = random.nextInt(5);
                    } while (numberVictory == number || arraySafe[number] == 1 || number == 4);
                    arraySafe[number] = 1;
                    arrayImageView[number].setImageResource(R.drawable.safe_empty);
                    countCloseSafe++;
                }
            } else {
                if (numberVictory == 4) {
                    arraySafe[4] = 1;
                    imageView5.setImageResource(R.drawable.safe_full);
                    for (int i = 0; i < arraySafe.length; i++) {
                        if (arraySafe[i] == 0) {
                            arrayImageView[i].setImageResource(R.drawable.safe_empty);
                        }
                    }
                    windowsDialog("Поздравляю, вы выйграли!");
                } else {
                    imageView5.setImageResource(R.drawable.safe_empty);
                    arrayImageView[numberVictory].setImageResource(R.drawable.safe_full);
                    windowsDialog("Оу, какая жалость вы проиграли!");
                }
            }
        });
    }
    private void windowsDialogPreview() {
        // вызов диалогового окна в начале игры
        dialog = new Dialog(this);  // создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // скрываем заголовок
        dialog.setContentView(R.layout.activity_dialog_preview);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  // прозрачный фон диалогового окна
        dialog.setCancelable(false);  // окно нельзя закрыть кликом за пределами окна
        textDialog = dialog.findViewById(R.id.text_dialog);

        // кнопка Назад
        TextView btnClose = dialog.findViewById(R.id.button_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScreenGameActivity.this, MainActivity.class);
                startActivity(intent);
                dialog.dismiss();  // закрытие диалогового окна
            }
        });

        // кнопка Продолжить
        Button btnContinue = dialog.findViewById(R.id.button_continue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimationOpenLuke();
                dialog.dismiss();  // закрытие диалогового окна
            }
        });
        dialog.show();  // показать диалоговое окно
        dialog.getWindow().setLayout(1800, 1000);
    }
    private void windowsDialog(String text) {
        // вызов диалогового окна в начале игры
        dialog = new Dialog(this);  // создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // скрываем заголовок
        dialog.setContentView(R.layout.activity_dialog_preview);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  // прозрачный фон диалогового окна
        dialog.setCancelable(false);  // окно нельзя закрыть кликом за пределами окна
        textDialog = dialog.findViewById(R.id.text_dialog);

        // кнопка Назад
        TextView btnClose = dialog.findViewById(R.id.button_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();  // закрытие диалогового окна
            }
        });

        // кнопка Продолжить
        Button btnContinue = dialog.findViewById(R.id.button_continue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(countCloseSafe == 3){
                    Intent intent = new Intent(ScreenGameActivity.this, ScreenGameActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                dialog.dismiss();  // закрытие диалогового окна
            }
        });
        textDialog.setText(text);
        dialog.show();  // показать диалоговое окно
        dialog.getWindow().setLayout(1600, 900);
    }
    private void startAnimationOpenLuke() {
        animationDrawable1.start();
        animationDrawable2.start();
        animationDrawable3.start();
        animationDrawable4.start();
        animationDrawable5.start();
    }
}