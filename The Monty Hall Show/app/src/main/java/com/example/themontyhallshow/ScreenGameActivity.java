package com.example.themontyhallshow;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ScreenGameActivity extends AppCompatActivity {

    ImageView imageView1,imageView2,imageView3,imageView4,imageView5;
    AnimationDrawable animationDrawable1,animationDrawable2,animationDrawable3,animationDrawable4,animationDrawable5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_game);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);

        imageView1.setBackgroundResource(R.drawable.animation_open_luke);
        animationDrawable1 = (AnimationDrawable) imageView1.getDrawable();
        imageView2.setBackgroundResource(R.drawable.animation_open_luke);
        animationDrawable2 = (AnimationDrawable) imageView2.getDrawable();
        imageView3.setBackgroundResource(R.drawable.animation_open_luke);
        animationDrawable3 = (AnimationDrawable) imageView3.getDrawable();
        imageView4.setBackgroundResource(R.drawable.animation_open_luke);
        animationDrawable4 = (AnimationDrawable) imageView4.getDrawable();
        imageView5.setBackgroundResource(R.drawable.animation_open_luke);
        animationDrawable5 = (AnimationDrawable) imageView5.getDrawable();

    }

    @Override
    protected void onStart() {
        animationDrawable1.start();
        animationDrawable2.start();
        animationDrawable3.start();
        animationDrawable4.start();
        animationDrawable5.start();
        super.onStart();
    }
}