
package johannes.co.sleepapp;

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class SchemaActivity extends Activity {
	
    private TextView mTimeDisplay, mTimeDisplay1, mTimeDisplay2, mTimeDisplay3, mTimeDisplay4, mTimeDisplay5;
    private Button mPickTime;

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
        weekDay[4] = "Fri";
        weekDay[5] = "Sat";
        weekDay[6] = "Sun"; 
        

        // capture our View elements        
        mTimeDisplay = (TextView) findViewById(R.id.timeDisplay);
        mTimeDisplay1 = (TextView) findViewById(R.id.timeDisplay1);
        mTimeDisplay2 = (TextView) findViewById(R.id.timeDisplay2);
        mTimeDisplay3 = (TextView) findViewById(R.id.timeDisplay3);
        mTimeDisplay4 = (TextView) findViewById(R.id.timeDisplay4);
        mTimeDisplay5 = (TextView) findViewById(R.id.timeDisplay5);
        mPickTime = (Button) findViewById(R.id.pickTime);

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
        //TODO fixa så att updateDisplay uppdaterar alla textfält (snyggt)
        //TODO 24h-format i dialogen
        //TODO välj veckodag i dialogen
    }
        
    
    
 // updates the time we display in the TextView
    private void updateDisplay() {
    	int day = 0, wakeDay = 0, wakeHour;
    	    		
    	if (mHour>15){
    		wakeHour = mHour - 16;
    		wakeDay++;
    	}
    	else 
    		wakeHour = mHour + 8;
    	mTimeDisplay.setText(
    			new StringBuilder()
    			.append(pad(mHour)).append(":")
				.append(pad(mMinute)).append(("    " + weekDay[day] +"\t\t\t\t"))
				.append(pad(wakeHour)).append(":")
				.append(pad(mMinute)).append(("    " + weekDay[wakeDay])));  
    	
    	mHour = mHour+4;
    	day++;
    	if (mHour>23){
    		mHour = mHour-24;
    		day++;
    	}
    	wakeDay = day;
    	if (mHour>15){
    		wakeHour = mHour - 16;
    		wakeDay++;
    	}
    	else 
    		wakeHour = mHour + 8;
    	mTimeDisplay1.setText(
    			new StringBuilder()
    			.append(pad(mHour)).append(":")
				.append(pad(mMinute)).append(("    " + weekDay[day] +"\t\t\t\t"))
				.append(pad(wakeHour)).append(":")
				.append(pad(mMinute)).append(("    " + weekDay[wakeDay]))); 
    	
    	mHour = mHour+4;
    	day++;
    	if (mHour>23){
    		mHour = mHour-24;
    		day++;
    	}
    	wakeDay = day;
    	if (mHour>15){
    		wakeHour = mHour - 16;
    		wakeDay++;
    	}
    	else 
    		wakeHour = mHour + 8;
    	mTimeDisplay2.setText(
    			new StringBuilder()
    			.append(pad(mHour)).append(":")
				.append(pad(mMinute)).append(("    " + weekDay[day] +"\t\t\t\t"))
				.append(pad(wakeHour)).append(":")
				.append(pad(mMinute)).append(("    " + weekDay[wakeDay])));   
    	
    	mHour = mHour+4;
    	day++;
    	if (mHour>23){
    		mHour = mHour-24;
    		day++;
    	}
    	wakeDay = day;
    	if (mHour>15){
    		wakeHour = mHour - 16;
    		wakeDay++;
    	}
    	else 
    		wakeHour = mHour + 8;
    	mTimeDisplay3.setText(
    			new StringBuilder()
    			.append(pad(mHour)).append(":")
				.append(pad(mMinute)).append(("    " + weekDay[day] +"\t\t\t\t"))
				.append(pad(wakeHour)).append(":")
				.append(pad(mMinute)).append(("    " + weekDay[wakeDay])));  	
    	
    	mHour = mHour+4;
    	day++;
    	if (mHour>23){
    		mHour = mHour-24;
    		day++;
    	}
    	wakeDay = day;
    	if (mHour>15){
    		wakeHour = mHour - 16;
    		wakeDay++;
    	}
    	else 
    		wakeHour = mHour + 8;
    	mTimeDisplay4.setText(
    			new StringBuilder()
    			.append(pad(mHour)).append(":")
				.append(pad(mMinute)).append(("    " + weekDay[day] +"\t\t\t\t"))
				.append(pad(wakeHour)).append(":")
				.append(pad(mMinute)).append(("    " + weekDay[wakeDay])));
    	
    	mHour = mHour+4;
    	day++;
    	if (mHour>23){
    		mHour = mHour-24;
    		day++;
    		if (day>6)
    			day = 0;
    	}
    	wakeDay = day;
    	if (mHour>15){
    		wakeHour = mHour - 16;
    		wakeDay++;
    		if (wakeDay>6)
    			wakeDay=0;
    	}
    	else 
    		wakeHour = mHour + 8;
    	mTimeDisplay5.setText(
    			new StringBuilder()
    			.append(pad(mHour)).append(":")
				.append(pad(mMinute)).append(("    " + weekDay[day] +"\t\t\t\t"))
				.append(pad(wakeHour)).append(":")
				.append(pad(mMinute)).append(("    " + weekDay[wakeDay])));
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