package com.example.stephen.project4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

//NOTE: Project4.java/xml IS THE WELCOME SCREEN
//      SignUp.java/xml IS THE ENTER VALUES SCREEN
//      Display.java/xml IS THE RESULTS SCREEN

public class Display extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        //gets the word's synonym from the welcome screen and displays it
        String synonymStr = getIntent().getStringExtra("synonym");
        TextView synonymStr_tv = (TextView)findViewById(R.id.TVsynonym);
        synonymStr_tv.setText(synonymStr);
    }
}
