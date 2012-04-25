package johannes.co.sleepapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MenuActivity extends Activity implements OnClickListener {
    
	private Button schemaButton, alarmButton;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
       schemaButton = (Button)findViewById(R.id.schema_button);   
       
       schemaButton.setOnClickListener(this);
       
       alarmButton = (Button)findViewById(R.id.alarm_button);   
       
       alarmButton.setOnClickListener(this);
        
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
		}		
	}
}