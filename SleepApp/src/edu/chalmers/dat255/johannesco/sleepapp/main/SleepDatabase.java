package edu.chalmers.dat255.johannesco.sleepapp.main;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SleepDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String SLEEP_TABLE_NAME = "Wake_Up_Times";
    private static final String DATABASE_NAME = "test";
    private static final String KEY_WORD = "test1";
//    private static final String KEY_DEFINITION = "test2";
    private static final String SLEEP_TABLE_CREATE =
                "CREATE TABLE " + SLEEP_TABLE_NAME + " (" +
                KEY_WORD + " INT);";

    SleepDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    	System.out.println("db string: " + SLEEP_TABLE_CREATE);
        db.execSQL(SLEEP_TABLE_CREATE);
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}