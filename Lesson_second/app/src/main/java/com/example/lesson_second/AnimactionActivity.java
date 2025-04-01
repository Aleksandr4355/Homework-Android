package com.example.lesson_second;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AnimactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animaction);

        ImageView imageView = findViewById(R.id.boy_img);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(imageView.isActivated())
                ((AnimationDrawable) imageView.getDrawable()).start();

//                Animation out = AnimationUtils.loadAnimation(AnimactionActivity.this, R.anim.anim_alpha);
//                Animation out = AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim_alpha);
//                imageView.startAnimation(out);

                Animation translate = AnimationUtils.loadAnimation(AnimactionActivity.this, R.anim.anim_translate);
                imageView.startAnimation(translate);
            }
        });

        ImageView myImageView = findViewById(R.id.boy_img_0);
        Button buttonRotateCenter = findViewById(R.id.rotateCenter);
        Button buttonRotateCorner = findViewById(R.id.rotateCorner);

        Animation animationRotateCenter = AnimationUtils.loadAnimation(this,R.anim.rotate_center);
        Animation animationRotateCorner = AnimationUtils.loadAnimation(this,R.anim.rotate_corner);

        buttonRotateCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageView.startAnimation(animationRotateCenter);
            }
        });

        buttonRotateCorner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageView.startAnimation(animationRotateCorner);
            }
        });

        Animation scale = AnimationUtils.loadAnimation(this,R.anim.shrink);
        imageView.startAnimation(scale);

        ObjectAnimator rotation = ObjectAnimator.ofFloat(myImageView, "rotation", 90);
        ObjectAnimator tRy = ObjectAnimator.ofFloat(myImageView, "translationY", 300);

        AnimatorSet set = new AnimatorSet();
        set.play(rotation).with(tRy);
        set.setDuration(1000);
        set.start();
    }
}