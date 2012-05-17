//   Copyright [2012] [Johannes Schygge, Daniel Warme, Karl Lawenius, Gusstav Mellgren]
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

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class SchemaActivity extends Activity implements OnClickListener {
	
	public SQLiteDatabase db;
	
	private TextView[] mTimeDisplay = new TextView[6];
//    private TextView mTimeDisplay, mTimeDisplay1, mTimeDisplay2, mTimeDisplay3, mTimeDisplay4, mTimeDisplay5;
    private Button mPickTime, backButton;

    private String[] weekDay = new String[7]; 
    public long timeMillis;
    private int mHour, mDay, mMinute; 

    static final int TIME_DIALOG_ID = 0;
    
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schema);
        
        weekDay[0] = "Sun";
        weekDay[1] = "Mon";
        weekDay[2] = "Tue";
        weekDay[3] = "Wed";
        weekDay[4] = "Thu";
        weekDay[5] = "Fri\t";
        weekDay[6] = "Sat";         
        

        // capture our View elements        
        mTimeDisplay[0] = (TextView) findViewById(R.id.timeDisplay);
        mTimeDisplay[1] = (TextView) findViewById(R.id.timeDisplay1);
        mTimeDisplay[2] = (TextView) findViewById(R.id.timeDisplay2);
        mTimeDisplay[3] = (TextView) findViewById(R.id.timeDisplay3);
        mTimeDisplay[4] = (TextView) findViewById(R.id.timeDisplay4);
        mTimeDisplay[5] = (TextView) findViewById(R.id.timeDisplay5);
        mPickTime = (Button) findViewById(R.id.pickTime);
        backButton = (Button)findViewById(R.id.back_button); 
        
        backButton.setOnClickListener(this);

        // add a click listener to the button
        mPickTime.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
			public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });

        // get the current time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        //Get current day. If current day is Sunday, mDay=1
        mDay = c.get(Calendar.DAY_OF_WEEK); 

        // display the current date
//        updateDisplay();
        
        //TODO 24h-format i dialogen
        //TODO välj veckodag i dialogen
        
    }
    public void onClick(View button) {
    	
    	switch (button.getId()) {
    			
    		case R.id.back_button:
    			Intent intent3 = new Intent(this, MenuActivity.class);
    			startActivity(intent3);
    		break;
    	}
    }
    
    
 // updates the time we display in the TextView
    private void updateDisplay() {
    	int wakeDay = 0, wakeHour, day = mDay-1;
    	
    	convertToMillis(mHour, mMinute);
    	
    	for (int i=0; i<6; i++){
    		
    		if (day>6){
    			day=0;
    		}
    		
    		wakeDay = day;
    		if (mHour>15){
        		wakeHour = mHour - 16;
        		wakeDay++;
        	}
        	else 
        		wakeHour = mHour + 8;
    		if (wakeDay>6)
    			wakeDay = 0;
    		
//    		db.beginTransaction();
//    		   try {
    			   db.execSQL("INSERT INTO WUT (test1) " + "VALUES (" + mHour + ")", null);
//    		     db.setTransactionSuccessful();
//    		   } finally {
//    		     db.endTransaction();
//    		   }
    		
    		
        	mTimeDisplay[i].setText(
        			new StringBuilder()
        			.append(pad(mHour)).append(":")
    				.append(pad(mMinute)).append(("    " + weekDay[day] +"\t\t\t\t\t\t"))
    				.append(pad(wakeHour)).append(":")
    				.append(pad(mMinute)).append(("    " + weekDay[wakeDay])));  
    		
        	mHour = mHour+4;
        	day++;
        	if (mHour>23){
        		mHour = mHour-24;
        		day++;
        	}
    	}
    }

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
    
 // the callback received when the user "sets" the time in the dialog
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
        new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mHour = hourOfDay;
                mMinute = minute;
                updateDisplay();
            }
        };
        
        @Override
        protected Dialog onCreateDialog(int id) {
            switch (id) {
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this,
                        mTimeSetListener, mHour, mMinute, false);
            }
            return null;
        }

        
        public void convertToMillis(int hour, int min){
        	timeMillis = hour * 60 * 60 * 1000 + min;
        }
}