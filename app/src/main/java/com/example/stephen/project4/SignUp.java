package com.example.stephen.project4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//NOTE: Project4.java/xml IS THE WELCOME SCREEN
//      SignUp.java/xml IS THE ENTER VALUES SCREEN
//      Display.java/xml IS THE RESULTS SCREEN

public class SignUp extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    //puts the word pair entered into the database, returns to welcome screen
    public void onSubmitClick(View v) {
        if (v.getId() == R.id.submitPairButton) {
            EditText word = (EditText) findViewById(R.id.TFword);
            EditText synonym = (EditText) findViewById(R.id.TFsynonym);

            String wordStr = word.getText().toString();
            String synonymStr = synonym.getText().toString();

            //insert the details in the database
            Contact c = new Contact();
            c.setWord(wordStr);
            c.setSynonym(synonymStr);

            helper.insertContact(c);


            Toast toast = Toast.makeText(SignUp.this, "Pair saved successfully.", Toast.LENGTH_SHORT);
            toast.show();

            //returns to main screen
            Intent i = new Intent(SignUp.this, Project4.class);
            startActivity(i);
        }
    }
}
