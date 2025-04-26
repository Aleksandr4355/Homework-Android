package com.example.gamequiz;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Level1 extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        TextView textLevels = findViewById(R.id.textView);
        setContentView(R.string.level);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final ImageView imgLeft = findViewById(R.id.img_left);
        final ImageView imgRight = findViewById(R.id.img_right);
        // Скругление углов (обьединяет картинку и созданый стиль) android:background="@drawable/style_img_uneversal" app:srcCompat="@drawable/imgtest"
        imgLeft.setClipToOutline(true);
        imgRight.setClipToOutline(true);

        //вызов диологового окна в начале игры
        dialog  =new Dialog(this); //создание новое дитологового окна
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialog.setContentView(R.layout.preview_dialog);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диологового окна
        dialog.setCancelable(false); // окна нельзя закрыть кликом за приделами окна

        // конпка назад
        TextView buttonClose = dialog.findViewById(R.id.button_close);
        buttonClose.setOnClickListener(v -> {
            Intent intent = new Intent(Level1.this,GameLevels.class);
            startActivity(intent);
            dialog.dismiss(); //закрытие диологового окна
        });

        Button btnContinue = dialog.findViewById(R.id.button_continue);
        btnContinue.setOnClickListener(v -> {
            dialog.dismiss();//закрытие лиолового окна
        });

        dialog.show();//показать диологовое окно

        // Кнопка назад из окна уровнем
        Button btnBack = findViewById(R.id.button_back_level1);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(Level1.this,GameLevels.class);
            startActivity(intent);
        });
    }
}