package com.example.fragmentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    Button fistFragmentBtn, secondFragmentBtn;
    Fragment1 fistFragment = new Fragment1();
    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fistFragmentBtn = findViewById(R.id.fragment_1btn);
        secondFragmentBtn = findViewById(R.id.fragment_2btn);


        replaceFragment(fistFragment);

        fistFragmentBtn.setOnClickListener(v -> {
            replaceFragment(fistFragment);
        });

        secondFragmentBtn.setOnClickListener(v -> {
            Fragment2 secondFragment = new Fragment2();
            replaceFragment(secondFragment);
        });
        data = findViewById(R.id.data);

        Intent intent = getIntent();
        String getData = intent.getStringExtra("key");
        data.setText(getData);
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit(); // подтверждения замены
    }
}