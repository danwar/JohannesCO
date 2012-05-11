package edu.chalmers.dat255.johannesco.sleepapp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

	    	
	    public class SettingsActivity extends Activity implements OnClickListener  {  	
	    	
	    	private Button generalSettingsButton, schemaSettingsButton, aboutButton, backButton;
	    	
	    /** Called when the activity is first created. */
	        @Override
	        public void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.settings);   
				    
				generalSettingsButton = (Button)findViewById(R.id.generalSettings_button); 
				schemaSettingsButton = (Button)findViewById(R.id.schemaSettings_button);    
				aboutButton = (Button)findViewById(R.id.about_button); 
				backButton = (Button)findViewById(R.id.back_button); 
   
				generalSettingsButton.setOnClickListener(this);
				schemaSettingsButton.setOnClickListener(this);
			   	aboutButton.setOnClickListener(this);
				backButton.setOnClickListener(this);
	            
	        }
	        
	        public void onClick(View button) {
	        	
	        	switch (button.getId()) {
	        	
	        		case R.id.generalSettings_button:
	        			Intent intent = new Intent(this, GeneralSettings.class);
	        			startActivity(intent);
	        		break;

	        		case R.id.schemaSettings_button:
	        			Intent intent1 = new Intent(this, SchemaSettings.class);
	        			startActivity(intent1);
	        		break;
	        		
	        		case R.id.about_button:
	        			Intent intent2 = new Intent(this, About.class);
	        			startActivity(intent2);
	        		break;
	        			
	        		case R.id.back_button:
	        			Intent intent3 = new Intent(this, MenuActivity.class);
	        			startActivity(intent3);
	        		break;
	        	}
	        }
	    }
	
	    // TODO Auto-generated method stub
