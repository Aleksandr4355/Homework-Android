package com.example.testmenuapplicationdz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class FragmentRegist extends Fragment {

    EditText emailRegist, passwordRegist, repeatPasswordRegist;
    Button buttonRegist;
    DataBaseHelper myDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_regist, container, false);

        emailRegist = view.findViewById(R.id.email_regist);
        passwordRegist = view.findViewById(R.id.password_regist);
        repeatPasswordRegist = view.findViewById(R.id.repeat_password_regist);

        buttonRegist = view.findViewById(R.id.button_regist);

        myDB = new DataBaseHelper(getContext());

        buttonRegist.setOnClickListener(v -> {
            String email = emailRegist.getText().toString();
            String password = passwordRegist.getText().toString();
            String confirmPassword = repeatPasswordRegist.getText().toString();

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(getContext(), "All fields are mandatory", Toast.LENGTH_SHORT).show();
            } else {
                if (password.equals(confirmPassword)) {
                    boolean checkUserEmail = myDB.checkEmail(email);
                    if (!checkUserEmail) {
                        boolean insert = myDB.registerUser(email, password);
                        if (insert) {
                            Toast.makeText(getContext(), "Пользователь зарегестрирован", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Ошибка регистрации", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "Такой логин уже зарегестрирован, введите другой логин", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Пароль не совпадает", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}