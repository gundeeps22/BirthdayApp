package com.example.gundeepsingh.birthdayapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onClick(View view) {
        Intent i = new Intent (this,SurpriseScreen.class);


        final EditText nameInput = (EditText) findViewById(R.id.name_in);
        String name = nameInput.getText().toString();
        i.putExtra("nameMessage",name);

        startActivity(i);
    }
}
