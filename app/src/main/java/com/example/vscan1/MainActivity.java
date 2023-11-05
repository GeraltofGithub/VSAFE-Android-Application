package com.example.vscan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    LottieAnimationView lottie;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);
        lottie = findViewById(R.id.animsplash);

        //text.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
        lottie.animate();//.setDuration(2000).setStartDelay(2900);
        lottie.playAnimation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),login.class);
                startActivity(i);
            }
        },5000);
    }
}
