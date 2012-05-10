//Copyright [2012] [Johannes Schygge]
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package edu.chalmers.dat255.johannesco.sleepapp.main;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SleepDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String SLEEP_TABLE_NAME = "Wake-Up Times";
    private static final String DATABASE_NAME = "test";
    private static final String KEY_WORD = "test1";
    private static final String KEY_DEFINITION = "test2";
    private static final String SLEEP_TABLE_CREATE =
                "CREATE TABLE " + SLEEP_TABLE_NAME + " (" +
                KEY_WORD + " INT, " +
                KEY_DEFINITION + " INT);";

    SleepDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SLEEP_TABLE_CREATE);
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}