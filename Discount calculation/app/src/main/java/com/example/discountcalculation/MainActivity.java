package com.example.discountcalculation;

import android.content.Intent;
import android.content.SharedPreferences;
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

    EditText editTextInput, editTextInputDiscount;
    Button buttonSale, buttonDiscount, buttonClear;
    TextView result, resultDiscount, textViewDiscount, textViewResultDiscount;
    SharedPreferences sharedPreferences;
    private static final String SHARED_SALE = "sale";
    private static final String KEY_PRICE = "price";
    private static final String KEY_DISCOUNT = "discount";
    private static final String KEY_RESULT_DISCOUNT1 = "resultDiscount1";
    private static final String KEY_RESULT_PRICE_DISCOUNT1 = "resultPriceDiscount1";
    private static final String KEY_RESULT_DISCOUNT2 = "resultDiscount2";
    private static final String KEY_RESULT_PRICE_DISCOUNT2 = "resultPriceDiscount2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.edit_text_input_sale);
        buttonSale = findViewById(R.id.button_sale);
        result = findViewById(R.id.result);
        resultDiscount = findViewById(R.id.result_discount);

        buttonSale.setOnClickListener(v -> {
            String text = editTextInput.getText().toString();
            int value = Integer.parseInt(text);
            double resultDouble = 0;
            if (value >= 500 && value < 1000) {
                resultDouble = value * 0.03;
                Toast.makeText(this, "Скидка составляет: 3%", Toast.LENGTH_SHORT).show();
            } else if (value >= 1000) {
                resultDouble = value * 0.05;
                Toast.makeText(this, "Скидка составляет: 5%", Toast.LENGTH_SHORT).show();
            } else if (value < 500) {
                Toast.makeText(this, "Минимавльная сумма покупки для скидки 500 руб.", Toast.LENGTH_SHORT).show();
            }

            resultDouble = Math.ceil(resultDouble);
            value = (int) (value - resultDouble);
            result.setText("Ваша скидка: " + resultDouble);
            resultDiscount.setText("Стоймость товаров со скидкой: " + value);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_PRICE, editTextInput.getText().toString());
            editor.putString(KEY_RESULT_DISCOUNT1, result.getText().toString());
            editor.putString(KEY_RESULT_PRICE_DISCOUNT1, resultDiscount.getText().toString());
            editor.apply();
        });

        editTextInputDiscount = findViewById(R.id.edit_text_input_discount);
        buttonDiscount = findViewById(R.id.button_discount);
        textViewDiscount = findViewById(R.id.text_view_discount);
        textViewResultDiscount = findViewById(R.id.text_view_result_discount);

        buttonDiscount.setOnClickListener(v -> {
            double valueSumSale = Double.parseDouble(editTextInput.getText().toString());
            double valueDiscount = Double.parseDouble(editTextInputDiscount.getText().toString());
            double discount = 0;
            double resultDiscount = 0;
            discount = (valueSumSale * valueDiscount) / 100;
            discount = Math.ceil(discount);
            resultDiscount = valueSumSale - discount;
            textViewDiscount.setText("Ваша скидка: " + discount);
            textViewResultDiscount.setText("Стоймость товаров со скидкой: " + resultDiscount);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_PRICE, editTextInput.getText().toString());
            editor.putString(KEY_DISCOUNT, editTextInputDiscount.getText().toString());
            editor.putString(KEY_RESULT_DISCOUNT2, textViewDiscount.getText().toString());
            editor.putString(KEY_RESULT_PRICE_DISCOUNT2, textViewResultDiscount.getText().toString());
            editor.apply();
        });

        sharedPreferences = getSharedPreferences(SHARED_SALE, MODE_PRIVATE);
        String price = sharedPreferences.getString(KEY_PRICE, null);
        String discount = sharedPreferences.getString(KEY_DISCOUNT, null);
        String resultDiscount1 = sharedPreferences.getString(KEY_RESULT_DISCOUNT1, null);
        String resultPriceDiscount1 = sharedPreferences.getString(KEY_RESULT_PRICE_DISCOUNT1, null);
        String resultDiscount2 = sharedPreferences.getString(KEY_RESULT_DISCOUNT2, null);
        String resultPriceDiscount2 = sharedPreferences.getString(KEY_RESULT_PRICE_DISCOUNT2, null);


        if (price != null || discount != null || resultDiscount1 != null || resultPriceDiscount1 != null || resultDiscount2 != null || resultPriceDiscount2 != null ) {
            editTextInput.setText(price);
            editTextInputDiscount.setText(discount);
            result.setText(resultDiscount1);
            resultDiscount.setText(resultPriceDiscount1);
            textViewDiscount.setText(resultDiscount2);
            textViewResultDiscount.setText(resultPriceDiscount2);
        }

        buttonClear = findViewById(R.id.buttonClear);

        buttonClear.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            editTextInput.setText("");
            editTextInputDiscount.setText("");
            result.setText("Скидка");
            resultDiscount.setText("Результат");
            textViewDiscount.setText("Скидка");
            textViewResultDiscount.setText("Результат");
        });

    }
}