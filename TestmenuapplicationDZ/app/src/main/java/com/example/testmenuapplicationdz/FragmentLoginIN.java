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

public class FragmentLoginIN extends Fragment {

    EditText emailLoginIN, passwordLoginIN;
    Button buttonIN;
    DataBaseHelper myDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_login_in, container, false);

        emailLoginIN = view.findViewById(R.id.email_login_in);
        passwordLoginIN = view.findViewById(R.id.password_login_in);

        buttonIN = view.findViewById(R.id.button_login_in);

        myDB = new DataBaseHelper(getContext());

        buttonIN.setOnClickListener(v -> {
            String email = emailLoginIN.getText().toString();
            String password = passwordLoginIN.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(getContext(), "Заполните все поля", Toast.LENGTH_SHORT).show();
            } else {
                if (myDB.checkUser(email, password)) {
                    Toast.makeText(getContext(), "Успешный вход", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), ProfileLoginInActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "Не правильный email или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}