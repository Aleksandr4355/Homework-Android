package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ResultDialog extends Dialog {

    private final String message;
    private  final ScreenGamePlayerPlayer3x3 screenGamePlayerPlayer3x3;

    public ResultDialog(@NonNull Context context, String message,  ScreenGamePlayerPlayer3x3 screenGamePlayerPlayer3x3) {
        super(context);
        this.message = message;
        this.screenGamePlayerPlayer3x3 = screenGamePlayerPlayer3x3;
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
                screenGamePlayerPlayer3x3.restartMatch();
                dismiss();
            }
        });
    }
}