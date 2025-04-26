package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ResultDialog3x3 <T> extends Dialog {

    private final String message;
    private  final ScreenGame3x3 screenGame3X3;

    public ResultDialog3x3(@NonNull Context context, String message, ScreenGame3x3 screenGame3X3) {
        super(context);
        this.message = message;
        this.screenGame3X3 = screenGame3X3;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dialog);

        TextView messageText = findViewById(R.id.messageText);
        Button startAganeButton = findViewById(R.id.startAgainButton);

        messageText.setText(message);

        startAganeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenGame3X3.restartMatch();
                dismiss();
            }
        });
    }
}