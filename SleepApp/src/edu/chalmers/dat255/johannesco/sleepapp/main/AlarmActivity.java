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
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class AlarmActivity extends Activity implements OnClickListener{
    private PendingIntent mAlarmSender;
    private Button backButton;
    
    // Datafil
    SharedPreferences sleepData;
    
    // Converter
    Converter convert;

    /** Körs när activityn skapas. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Skapa koppling till datafil
        sleepData = getSharedPreferences(Constants.filename, 0);
        
        // Instansiera converter
        convert = new Converter();

        // Skapa en IntentSender som ska starta en service som schemaläggs
        // med alarm manager.
        mAlarmSender = PendingIntent.getService(AlarmActivity.this,
                0, new Intent(AlarmActivity.this, AlarmActivity_Service.class), 0);

        setContentView(R.layout.alarm);

        // Buttons och klicklyssnare.
        Button button = (Button)findViewById(R.id.start_alarm);
        button.setOnClickListener(mStartAlarmListener);
        button = (Button)findViewById(R.id.stop_alarm);
        button.setOnClickListener(mStopAlarmListener);
        button = (Button)findViewById(R.id.test);
        button.setOnClickListener(mStop);
        backButton = (Button)findViewById(R.id.back_button); 
        backButton.setOnClickListener(this);
    }

    private OnClickListener mStartAlarmListener = new OnClickListener() {
        public void onClick(View v) {
            // Få nuvarande timme och minut, konvertera till ms
        	final Calendar c = Calendar.getInstance();
        	int hour = c.get(Calendar.HOUR_OF_DAY);
        	int min = c.get(Calendar.MINUTE);
//        	int millis = c.get(Calendar.MILLISECOND);
        	int millis = convert.intToMillis(hour, min);
//        	int Millis = (hour * 60 + min) * 60 * 1000;
        	
        	sleepData = getSharedPreferences(Constants.filename, 0);
        	int returnedMillis = sleepData.getInt("sleepTime", 0);
        	int diff = returnedMillis - millis;
            long firstTime = SystemClock.elapsedRealtime() + diff;

            // Schemalägg alarmet
            AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
//            am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                            firstTime, 5*1000, mAlarmSender);
            am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, firstTime, mAlarmSender);

            // Användaren får veta vad som händer
            Toast.makeText(AlarmActivity.this, R.string.repeating_scheduled,
                    Toast.LENGTH_LONG).show();
        }
    };

    private OnClickListener mStopAlarmListener = new OnClickListener() {
        public void onClick(View v) {
            // Avbryt alarmet
            AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
            am.cancel(mAlarmSender);

            // Användaren får veta vad som händer
            Toast.makeText(AlarmActivity.this, R.string.repeating_unscheduled,
                    Toast.LENGTH_LONG).show();

        }
    };
    // TODO Lägg till funktion för att stänga av alarmet
    private OnClickListener mStop = new OnClickListener() {
        public void onClick(View v) {        	
            // Avbryt alarmet
            AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
            am.cancel(mAlarmSender);
            
        	final Calendar c = Calendar.getInstance();
//        	int hour = c.get(Calendar.HOUR_OF_DAY);
//        	int min = c.get(Calendar.MINUTE);
        	int millis = c.get(Calendar.MILLISECOND);
        	
            sleepData = getSharedPreferences(Constants.filename, 0);
        	int returnedMillis = sleepData.getInt("sleepTime", 0);
        	String test = "" + returnedMillis +"";
//        	String test1 = "" +SystemClock.elapsedRealtime();
        	String test1 = "" +millis;

            // Användaren får veta vad som händer
            Toast.makeText(AlarmActivity.this, test +"\t/\t" + test1,
                    Toast.LENGTH_LONG).show();

        }
    };

    public void onClick(View button) {
    	
    	switch (button.getId()) {
    			
    		case R.id.back_button:
    			Intent intent3 = new Intent(this, MenuActivity.class);
    			startActivity(intent3);
    		break;
    	}
    }
    

}