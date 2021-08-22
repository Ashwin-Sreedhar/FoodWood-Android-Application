package com.foodwood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        ImageView i = findViewById(R.id.imageView);
        TextView t = findViewById(R.id.a);
        Animation fadeIn = AnimationUtils.loadAnimation(Splashscreen.this,R.anim.fade_in);

        i.startAnimation(fadeIn);
        t.startAnimation(fadeIn);


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sleep(2000);
                        startActivity(new Intent(Splashscreen.this,MainActivity.class));
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
    }
}
