package com.example.stephen.project4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//NOTE: Project4.java/xml IS THE WELCOME SCREEN
//      SignUp.java/xml IS THE ENTER VALUES SCREEN
//      Display.java/xml IS THE RESULTS SCREEN

public class Project4 extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project4);
    }

    //two options depending on button clicked
    public void onButtonClick(View v){

        //searches the database for word entered, returning its synonym
        if(v.getId() == R.id.findPairButton){
            EditText word = (EditText)findViewById(R.id.TFword);
            String wordStr = word.getText().toString();

            String synonymStr = helper.searchSynonym(wordStr);

            Intent i = new Intent(Project4.this, Display.class);
            //i.putExtra("word", wordStr);
            i.putExtra("synonym", synonymStr);
            startActivity(i);
        }

        //directs to the screen where user enters pair into the database
        else if(v.getId() == R.id.enterValuesButton){
            Intent i = new Intent(Project4.this, SignUp.class);
            startActivity(i);
        }
    }
}
