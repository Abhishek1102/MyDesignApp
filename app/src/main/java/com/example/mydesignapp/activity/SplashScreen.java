package com.example.mydesignapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.mydesignapp.R;
import com.example.mydesignapp.helper.AppConstant;

public class SplashScreen extends AppCompatActivity {

    // Splash Screen
    private static int SPLASH_SCREEN_TIME_OUT = 3000;
    // after 3000ms next activity will be started

    SharedPreferences sharedPreferences;
    String prevstarted = "no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        // This method is used so that your splash activity can cover the entire screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //to change language
        AppConstant.setLanguage(getApplicationContext());


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                if (sharedPreferences.contains("loginnumber") && sharedPreferences.contains("loginpassword")) {
                    prevstarted = "yes";
                    if (prevstarted.equals("yes")) {
                        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(intent);
                    }

                } else {
                    Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(i);
                }
                finish();

            }

        }, SPLASH_SCREEN_TIME_OUT);
    }
}