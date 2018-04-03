package com.example.stephen.project4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;

//NOTE: Project4.java/xml IS THE WELCOME SCREEN
//      SignUp.java/xml IS THE ENTER VALUES SCREEN
//      Display.java/xml IS THE RESULTS SCREEN

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "pairs.db";
    private static final String TABLE_NAME = "pairs";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_SYNONYM = "synonym";

    private static final String TABLE_CREATE =
            "create table "+ TABLE_NAME + " (id integer primary key autoincrement, word text not null, " +
                    "synonym text not null)";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //searches database for the synonym of the word entered
    public String searchSynonym(String synonym){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select word, synonym from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b; // a is the word entered, b is the synonym
        b = "Word not found.";

        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if(a.equals(synonym)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b; //returns synonym or word not found
    }

    //puts the word pair into the database
    public void insertContact(Contact c){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_WORD, c.getWord());
        values.put(COLUMN_SYNONYM, c.getSynonym());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        this.onCreate(sqLiteDatabase);
    }
}
