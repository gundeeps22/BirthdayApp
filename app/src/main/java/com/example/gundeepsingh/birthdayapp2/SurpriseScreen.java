package com.example.gundeepsingh.birthdayapp2;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Timer;
import java.util.TimerTask;

public class SurpriseScreen extends AppCompatActivity {

    int count = 0;
    String[] colors = {"#F8BBD0", "#C2185B", "#448AFF", "#9C27B0", "#E1BEE7", "#FFFFFF"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surprise_screen);
        final RelativeLayout surprise = (RelativeLayout) findViewById(R.id.surprise_me);
        Bundle nameData = getIntent().getExtras();


        if (nameData == null){
            return;
        }
        String name_out = nameData.getString("nameMessage");
        String finalout = "Happy Birthday " + name_out + " !";
        final TextView outputText = (TextView) findViewById(R.id.output_txt);

        outputText.setText(finalout);

        MediaPlayer phbs = MediaPlayer.create(SurpriseScreen.this, R.raw.phbs);
        phbs.start();
        surprise.setBackgroundColor(Color.parseColor("#C2185B"));

       Thread i = new Thread(){
           @Override
           public void run(){
               while(!isInterrupted()) {
                   try {
                       Thread.sleep(5000);
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               count++;
                               if (count >= 5) {
                                   count = 0;
                               }

                               surprise.setBackgroundColor(Color.parseColor(colors[count]));
                           }
                       });
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       };
       i.start();

    }

}

