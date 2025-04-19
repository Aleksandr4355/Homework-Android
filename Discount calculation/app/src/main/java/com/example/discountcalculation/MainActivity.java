package com.example.discountcalculation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextInput;
    Button button_sale;
    TextView result, result_discount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.edit_text_input);
        button_sale = findViewById(R.id.button_sale);
        result = findViewById(R.id.result);
        result_discount = findViewById(R.id.result_discount);

        button_sale.setOnClickListener(v -> {
            String text = editTextInput.getText().toString();
            int value = Integer.parseInt(text);
            double resultDouble = 0;
            if (value >= 500 && value < 1000) {
                resultDouble = value * 0.03;
                Toast.makeText(this, "Скидка составляет: 3%", Toast.LENGTH_SHORT).show();
            } else if (value >= 1000) {
                resultDouble = value * 0.05;
                Toast.makeText(this, "Скидка составляет: 5%", Toast.LENGTH_SHORT).show();
            }else if (value < 500){
                Toast.makeText(this, "Минимавльная сумма покупки для скидки 500 руб.", Toast.LENGTH_SHORT).show();
            }

            resultDouble = Math.ceil(resultDouble);
            value = (int) (value - resultDouble);
            result.setText(String.valueOf("Ваша скидка: " + resultDouble));
            result_discount.setText(String.valueOf("Стоймость товаров со скидкой: " + value));
        });

    }
}