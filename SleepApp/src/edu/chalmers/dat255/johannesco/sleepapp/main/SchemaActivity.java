
package edu.chalmers.dat255.johannesco.sleepapp.main;

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class SchemaActivity extends Activity implements OnClickListener {
	
//	public SQLiteDatabase db;
	
	private TextView[] mTimeDisplay = new TextView[6];
//    private TextView mTimeDisplay, mTimeDisplay1, mTimeDisplay2, mTimeDisplay3, mTimeDisplay4, mTimeDisplay5;
    private Button mPickTime, backButton;

    private String[] weekDay = new String[7]; 
    private int mHour;
    private int mMinute;

    static final int TIME_DIALOG_ID = 0;
    
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schema);
        
        weekDay[0] = "Mon";
        weekDay[1] = "Tue";
        weekDay[2] = "Wed";
        weekDay[3] = "Thu";
        weekDay[4] = "Fri\t";
        weekDay[5] = "Sat";
        weekDay[6] = "Sun"; 
        

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
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });

        // get the current time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // display the current date
        updateDisplay();
        
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
    	int day = 0, wakeDay = 0, wakeHour;
    	
    	for (int i=0; i<6; i++){
    		
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
//    		     INSERT mHour INTO 
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
}