package com.example.dzapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private String operator;
    private String firstNumber;
    boolean isNew = true;
    Button butReset,butResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.dz_3);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        editText = findViewById(R.id.editText);
        butReset = findViewById(R.id.reset);
        butResult = findViewById(R.id.equals1);

        butReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("0");
                isNew = true;
            }
        });

        butResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String secondNumber = editText.getText().toString();
                Double result = 0.0;
                if(operator.equals("-")){
                    result = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
                } else if (operator.equals("+")) {
                    result = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
                }else if (operator.equals("/")) {
                    result = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
                }else if (operator.equals("*")) {
                    result = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
                }
                editText.setText(result.toString());
                isNew = true;
            }
        });

    }

    public void clickNumber(View view) {
        if (isNew) {
            editText.setText("");
        }
        isNew = false;
        String number = editText.getText().toString();
        if (view.getId() == R.id.but1) {
            number += "1";
        } else if (view.getId() == R.id.but2) {
            number += "2";
        } else if (view.getId() == R.id.but3) {
            number += "3";
        } else if (view.getId() == R.id.but4) {
            number += "4";
        } else if (view.getId() == R.id.but5) {
            number += "5";
        } else if (view.getId() == R.id.but6) {
            number += "6";
        } else if (view.getId() == R.id.but7) {
            number += "7";
        } else if (view.getId() == R.id.but8) {
            number += "8";
        } else if (view.getId() == R.id.but9) {
            number += "9";
        } else if (view.getId() == R.id.but0) {
            number += "0";
        }
        editText.setText(number);
    }

    public void Operation(View view) {
        isNew = true;
        firstNumber = editText.getText().toString();
        if (view.getId() == R.id.plus) {
            operator = "+";
        } else if (view.getId() == R.id.minus) {
            operator = "-";
        } else if (view.getId() == R.id.divide) {
            operator = "/";
        } else if (view.getId() == R.id.multiply) {
            operator = "*";
        }
    }
}