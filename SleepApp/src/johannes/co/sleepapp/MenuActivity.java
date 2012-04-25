package johannes.co.sleepapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MenuActivity extends Activity implements OnClickListener {
    
<<<<<<< HEAD
	private Button schemaButton, alarmButton, sleepInfoButton, settingsButton;
=======
	private Button schemaButton, alarmButton;
>>>>>>> 02e5f8b66d715b8097683a6d1fc761481efe3587
	
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
<<<<<<< HEAD
       alarmButton.setOnClickListener(this);
       sleepInfoButton.setOnClickListener(this);
       settingsButton.setOnClickListener(this);
=======
       
       alarmButton = (Button)findViewById(R.id.alarm_button);   
       
       alarmButton.setOnClickListener(this);
>>>>>>> 02e5f8b66d715b8097683a6d1fc761481efe3587
        
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
    			Intent intent3= new Intent(this, SettingsActivity.class);
    			startActivity(intent3);
    			break;
    	}
    }

<<<<<<< HEAD
=======
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
		}		
	}
>>>>>>> 02e5f8b66d715b8097683a6d1fc761481efe3587
}