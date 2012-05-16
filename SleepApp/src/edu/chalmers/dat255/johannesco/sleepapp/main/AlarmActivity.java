package edu.chalmers.dat255.johannesco.sleepapp.main;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class AlarmActivity extends Activity implements OnClickListener{
    private PendingIntent mAlarmSender;
    private Button backButton;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create an IntentSender that will launch our service, to be scheduled
        // with the alarm manager.
        mAlarmSender = PendingIntent.getService(AlarmActivity.this,
                0, new Intent(AlarmActivity.this, AlarmActivity_Service.class), 0);

        setContentView(R.layout.alarm);

        // Watch for button clicks.
        Button button = (Button)findViewById(R.id.start_alarm);
        button.setOnClickListener(mStartAlarmListener);
        button = (Button)findViewById(R.id.stop_alarm);
        button.setOnClickListener(mStopAlarmListener);
        backButton = (Button)findViewById(R.id.back_button); 
        backButton.setOnClickListener(this);
    }

    private OnClickListener mStartAlarmListener = new OnClickListener() {
        public void onClick(View v) {
            // We want the alarm to go off 30 seconds from now.
            long firstTime = SystemClock.elapsedRealtime();

            // Schedule the alarm!
            AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
            am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                            firstTime, 30*1000, mAlarmSender);

            // Tell the user about what we did.
            Toast.makeText(AlarmActivity.this, R.string.repeating_scheduled,
                    Toast.LENGTH_LONG).show();
        }
    };

    private OnClickListener mStopAlarmListener = new OnClickListener() {
        public void onClick(View v) {
            // And cancel the alarm.
            AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
            am.cancel(mAlarmSender);

            // Tell the user about what we did.
            Toast.makeText(AlarmActivity.this, R.string.repeating_unscheduled,
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