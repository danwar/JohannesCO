package edu.chalmers.dat255.johannesco.sleepapp.main;

import johannes.co.sleepapp.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MenuActivity extends Activity implements OnClickListener {
    
	public synchronized SleepDatabase getWritableDatabase() {
		return null;
	}
	
	private Button schemaButton, alarmButton, sleepInfoButton, settingsButton;

/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
       schemaButton = (Button)findViewById(R.id.schema_button); 
       alarmButton = (Button)findViewById(R.id.alarm_button); 
       sleepInfoButton = (Button)findViewById(R.id.sleep_info_button); 
       settingsButton = (Button)findViewById(R.id.settings_button); 
       
       schemaButton.setOnClickListener(this);
       alarmButton.setOnClickListener(this);
       sleepInfoButton.setOnClickListener(this);
       settingsButton.setOnClickListener(this);
        
    }
    
    public void onClick(View button) {
    	
    	switch (button.getId()) {
    	
    		case R.id.schema_button:
    			Intent intent = new Intent(this, SchemaActivity.class);
    			startActivity(intent);
    		break;

    		case R.id.alarm_button:
    			Intent intent1 = new Intent(this, AlarmActivity.class);
    			startActivity(intent1);
    		break;
    		
    		case R.id.sleep_info_button:
    			Intent intent2 = new Intent(this, SleepInfoActivity.class);
    			startActivity(intent2);
    		break;
    			
    		case R.id.settings_button:
    			Intent intent3 = new Intent(this, SettingsActivity.class);
    			startActivity(intent3);
    		break;
    	}
    }
}