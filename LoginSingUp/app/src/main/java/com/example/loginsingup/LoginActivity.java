package com.example.loginsingup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    private EditText loginEmail, loginPassword;
    private Button loginButton;
    private DataBaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);

        myDB = new DataBaseHelper(this);

        loginUser();
    }

    private void loginUser() {
        loginButton.setOnClickListener(v -> {
            String email = loginEmail.getText().toString();
            String password = loginPassword.getText().toString();
            boolean log = myDB.checkUser(email, password);

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            }else{
               if (log) {
                   Toast.makeText(this, "Успешный вход", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(this, HomeActivity.class);
                   startActivity(intent);
               }else{
                   Toast.makeText(this, "Не правильный email или пароль", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}