package com.example.gundeepsingh.birthdayapp2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static int timeout = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent homeIntent = new Intent (MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, timeout);
    }
}
