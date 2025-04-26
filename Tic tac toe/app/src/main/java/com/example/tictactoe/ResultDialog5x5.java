package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ResultDialog5x5 extends Dialog {

    private final String message;
    private  final ScreenGame5X5 screenGame5X5;

    public ResultDialog5x5(@NonNull Context context, String message, ScreenGame5X5 screenGame5X5) {
        super(context);
        this.message = message;
        this.screenGame5X5 = screenGame5X5;
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
                screenGame5X5.restartMatch();
                dismiss();
            }
        });
    }
}