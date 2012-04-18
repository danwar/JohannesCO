//http://developer.android.com/resources/tutorials/views/hello-timepicker.html

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


public class SleepAppActivity extends Activity {
	
    private TextView mTimeDisplay, mTimeDisplay1, mTimeDisplay2, mTimeDisplay3;
    private Button mPickTime;

    private int mHour;
    private int mMinute;
    private int day = 0;

    static final int TIME_DIALOG_ID = 0;
    
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // capture our View elements
        
        mTimeDisplay = (TextView) findViewById(R.id.timeDisplay);
        mTimeDisplay1 = (TextView) findViewById(R.id.timeDisplay1);
        mTimeDisplay2 = (TextView) findViewById(R.id.timeDisplay2);
        mTimeDisplay3 = (TextView) findViewById(R.id.timeDisplay3);
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
        //TODO fixa så att updateDisplay uppdaterar alla textfält
    }
        
    
    
 // updates the time we display in the TextView
    private void updateDisplay() {
    	    		
    	mTimeDisplay.setText(
    			new StringBuilder()
    				.append(pad(mHour)).append(":")
    				.append(pad(mMinute)).append(("    " + day)));
    	
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