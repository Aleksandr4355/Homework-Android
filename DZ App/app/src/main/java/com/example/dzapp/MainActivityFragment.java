package com.example.dzapp;

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

public class MainActivityFragment extends AppCompatActivity {
    Button fistFragmentBtn, secondFragmentBtn,  threeFragmentBtn;
    Fragment1 fistFragment = new Fragment1();
    Fragment2 secondFragment = new Fragment2();
    Fragment3 threeFragment = new Fragment3();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);

        fistFragmentBtn = findViewById(R.id.fragment_1btn);
        secondFragmentBtn = findViewById(R.id.fragment_2btn);
        threeFragmentBtn = findViewById(R.id.fragment_3btn);

        replaceFragment(fistFragment);

        fistFragmentBtn.setOnClickListener(v -> {
            replaceFragment(fistFragment);
        });

        secondFragmentBtn.setOnClickListener(v -> {
            replaceFragment(secondFragment);
        });

        threeFragmentBtn.setOnClickListener(v -> {
            replaceFragment(threeFragment);
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit(); // подтверждения замены
    }

}