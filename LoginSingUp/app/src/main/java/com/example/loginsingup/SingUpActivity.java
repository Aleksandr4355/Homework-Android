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

public class SingUpActivity extends AppCompatActivity {

    private EditText emailSingUp, passwordSingUP, passwordConfirmSingUp;
    private Button singUpButton;
    private DataBaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        emailSingUp =findViewById(R.id.sing_up_email);
        passwordSingUP = findViewById(R.id.sign_up_password);
        passwordConfirmSingUp = findViewById(R.id.sing_up_confirm_password);

        singUpButton = findViewById(R.id.sing_up_button);

        myDB = new DataBaseHelper(this);

        insertUser();
    }
    private  void  insertUser(){
        singUpButton.setOnClickListener(v -> {
            String email = emailSingUp.getText().toString();
            String password = passwordSingUP.getText().toString();
            String confirmPassword = passwordConfirmSingUp.getText().toString();

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                Toast.makeText(this, "ALL fields are mandatory", Toast.LENGTH_SHORT).show();
            }else{
                if(password.equals(confirmPassword)){
                    boolean checkUserEmail = myDB.checkEmail(email);
                    if (!checkUserEmail){
                        boolean insert = myDB.registerUser(email, password);
                        if(insert){
                            Toast.makeText(this, "Пользователь успешно зарегистрирован", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(this, LoginActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(this, "Ошибка регистрации", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(this, "Пользователь с таким емаилом зарегистрирован", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}