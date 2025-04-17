package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultDialog5x5 extends Dialog {

    private final String message;
    private  final ScreenGamePlayerPlayer5X5 screenGamePlayerPlayer5x5;

    public ResultDialog5x5(@NonNull Context context, String message, ScreenGamePlayerPlayer5X5 screenGamePlayerPlayer5x5) {
        super(context);
        this.message = message;
        this.screenGamePlayerPlayer5x5 = screenGamePlayerPlayer5x5;
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
                screenGamePlayerPlayer5x5.restartMatch();
                dismiss();
            }
        });
    }
}