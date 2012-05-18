/*   Copyright [2012] [Johannes Schygge, Daniel Warme, Karl Lawenius, Gustav Mellgren]
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*/


package edu.chalmers.dat255.johannesco.sleepapp.main;

import java.util.Calendar;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class SchemaActivity extends Activity implements OnClickListener {	
	
	private TextView[] mTimeDisplay = new TextView[6];
	private Button mPickTime, backButton;
 
    private int mHour, mDay, mMinute; 

    static final int TIME_DIALOG_ID = 0;
    
    // Datafil
    SharedPreferences sleepData;
    
    // Converter
    Converter convert;
    
    // Constants
    Constants constant;

    
	
    /** Körs när activityn skapas. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schema);
        
        // Skapa koppling till datafil
        sleepData = getSharedPreferences(Constants.filename, 0);
        
        // Instansiera converter
        convert = new Converter();
             
        //Instansiera constants
        constant = new Constants();

        // Skapa elementen        
        mTimeDisplay[0] = (TextView) findViewById(R.id.timeDisplay);
        mTimeDisplay[1] = (TextView) findViewById(R.id.timeDisplay1);
        mTimeDisplay[2] = (TextView) findViewById(R.id.timeDisplay2);
        mTimeDisplay[3] = (TextView) findViewById(R.id.timeDisplay3);
        mTimeDisplay[4] = (TextView) findViewById(R.id.timeDisplay4);
        mTimeDisplay[5] = (TextView) findViewById(R.id.timeDisplay5);        
        
        // Buttons och klicklyssnare.
        backButton = (Button)findViewById(R.id.back_button); 
        
        backButton.setOnClickListener(this);
        mPickTime = (Button) findViewById(R.id.pickTime);
        mPickTime.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
			public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });
        // TODO Lägg till "Spara"-knapp
        
        
        // Få nuvarande tid
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        // Få nuvarande dag. Söndag = 1
        mDay = c.get(Calendar.DAY_OF_WEEK); 

        // Uppdatera displayen om sleepTime "har ett värde"
        if (sleepData.contains("sleepTime")){
        	updateDisplay();
        }
        
        
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
    
    
 // TODO Första gången applikationen startar ska man gå och lägga sig 14.00 på måndag  
 // TODO Lägg ihop updateDisplay-metoderna till en   
 // Uppdaterar TextView-fälten när Activityn startas, ingen data sparas (men laddas)
    private void updateDisplay() {
    	int wakeDay = 0, wakeHour, day = mDay-1, hour, min;
    	
    	sleepData = getSharedPreferences(Constants.filename, 0);
    	int returnedMillis = sleepData.getInt("sleepTime", 0);
    	hour = convert.millisToHour(returnedMillis);
    	min = convert.millisToMin(returnedMillis);
    	
    	for (int i=0; i<6; i++){
    		
    		if (day>6){
    			day=0;
    		}
    		
    		wakeDay = day;
    		if (hour>15){
        		wakeHour = hour - 16;
        		wakeDay++;
        	}
        	else 
        		wakeHour = hour + 8;
    		if (wakeDay>6)
    			wakeDay = 0;    		
    		
        	mTimeDisplay[i].setText(
        			new StringBuilder()
        			.append(pad(hour)).append(":")
    				.append(pad(min)).append(("    " + constant.weekDay[day] +"\t\t\t\t\t\t"))
    				.append(pad(wakeHour)).append(":")
    				.append(pad(min)).append(("    " + constant.weekDay[wakeDay])));  
    		
        	hour = hour+4;
        	day++;
        	if (hour>23){
        		hour = hour-24;
        		day++;
        	}
    	}
    }
    
    // Uppdatering av TextView-fälten efter att ny tid har valts, sparar data
    private void updateDisplay1() {
    	int wakeDay = 0, wakeHour, day = mDay-1, hour = mHour, min = mMinute;
    	
    	for (int i=0; i<6; i++){
    		
    		if (day>6){
    			day=0;
    		}
    		
    		wakeDay = day;
    		if (hour>15){
        		wakeHour = hour - 16;
        		wakeDay++;
        	}
        	else 
        		wakeHour = hour + 8;
    		if (wakeDay>6)
    			wakeDay = 0;    		
    		
        	mTimeDisplay[i].setText(
        			new StringBuilder()
        			.append(pad(hour)).append(":")
    				.append(pad(min)).append(("    " + constant.weekDay[day] +"\t\t\t\t\t\t"))
    				.append(pad(wakeHour)).append(":")
    				.append(pad(min)).append(("    " + constant.weekDay[wakeDay])));  
    		
        	hour = hour+4;
        	day++;
        	if (hour>23){
        		hour = hour-24;
        		day++;
        	}
    	}
    	
    	//Raderna nedan sparar tiden i sleepData, dessa ska sedan ligga i "Spara"-knappen
    	//TODO Detta ska vara i "Spara"-knappen
    	int timeInMillis = convert.intToMillis(mHour, mMinute);
    	long realTime = SystemClock.elapsedRealtime();
    	SharedPreferences.Editor editor = sleepData.edit();
    	editor.putInt("sleepTime", timeInMillis);
    	editor.putInt("timeMillis", (int) realTime);
    	editor.commit();
    	
    }

    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
    
 // Callback användaren får när denna sätter en tid i dialogen
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
        new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mHour = hourOfDay;
                mMinute = minute;
                updateDisplay1();
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