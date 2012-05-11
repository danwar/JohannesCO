package edu.chalmers.dat255.johannesco.sleepapp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

	    	
	    public class SettingsActivity extends Activity implements OnClickListener  {  	

	    /** Called when the activity is first created. */
	        @Override
	        public void onCreate(Bundle savedInstanceState) {
	            super.onCreate(savedInstanceState);
	            setContentView(R.layout.settings);
	            private Button generalSettings, schemaSettings, about, back;
	            
	           generalSettings = (Button)findViewById(R.id.generalSettings_Button); 
	           schemaSettings = (Button)findViewById(R.id.schemaSettings_Button); 
	           about = (Button)findViewById(R.id.about_Button); 
	           back = (Button)findViewById(R.id.back_Button); 
	           
	           generalSettings.setOnClickListener(this);
	           schemaSettings.setOnClickListener(this);
	           about.setOnClickListener(this);
	           back.setOnClickListener(this);
	            
	        }
	        
	        public void onClick(View button) {
	        	
	        	switch (button.getId()) {
	        	
	        		case R.id.generalSettings_Button:
	        			Intent intent = new Intent(this, generalSettings.class);
	        			startActivity(intent);
	        		break;

	        		case R.id.schemaSettings:
	        			Intent intent1 = new Intent(this, schemaSettings.class);
	        			startActivity(intent1);
	        		break;
	        		
	        		case R.id.about:
	        			Intent intent2 = new Intent(this, about.class);
	        			startActivity(intent2);
	        		break;
	        			
	        		case R.id.back:
	        			Intent intent3 = new Intent(this, back.class);
	        			startActivity(intent3);
	        		break;
	        	}
	        }
	    }
	
	    // TODO Auto-generated method stub
	}

}
