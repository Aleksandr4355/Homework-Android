package com.example.dzapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private TextView result;
    private EditText num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        num1 = findViewById(R.id.editNumber1);
        num2 = findViewById(R.id.editNumber2);
        result = findViewById(R.id.result);

    }

    public void OperationNumber(View view) {
        double numbers = 0;
        String operation = "";
        if (view.getId() == R.id.bu1) {
            numbers = Double.parseDouble(num1.getText().toString()) + Double.parseDouble(num2.getText().toString());
            operation = "+";
        } else if (view.getId() == R.id.bu2) {
            numbers = Double.parseDouble(num1.getText().toString()) - Double.parseDouble(num2.getText().toString());
            operation = "-";
        } else if (view.getId() == R.id.bu3) {
            numbers = Double.parseDouble(num1.getText().toString()) / Double.parseDouble(num2.getText().toString());
            operation = "/";
        } else if (view.getId() == R.id.bu4) {
            numbers = Double.parseDouble(num1.getText().toString()) * Double.parseDouble(num2.getText().toString());
            operation = "*";
        }
        if ((num1.getText().toString().equals("0") || num2.getText().toString().equals("0")) && operation.equals("/")) {
            result.setText("ошибка");
            showInfo("Делить на ноль нельзя");
        } else {
            result.setText("Result: " + num1.getText() + " " + operation + " " + num2.getText() + " = " + String.valueOf(numbers));
        }
    }

    public void showInfo(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}