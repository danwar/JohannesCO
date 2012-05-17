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

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SleepInfoActivity extends Activity implements OnClickListener {
	
	private Button generalSleepInfoButton, sleepStylesButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.sleepinfo);
	
	    //Initializing the buttons
	    generalSleepInfoButton = (Button)findViewById(R.id.generalSleepInfo_Button); 
	    sleepStylesButton = (Button)findViewById(R.id.sleepStyles_Button); 
	    
	    //Giving the buttons sleepInfo Button a listener. 
	    generalSleepInfoButton.setOnClickListener(this);
	    sleepStylesButton.setOnClickListener(this);
	    
	}//onCreate    	
	    	public void onClick(View v) {
	    		
	    		switch (v.getId()){ 
	    		
	    		case R.id.generalSleepInfo_Button:
	    			showGeneralSleepInfo();
	    		break;
	    		
	    		case R.id.sleepStyles_Button:
	    			showSleepStyles();
	    		break;
	    		
	    		
	    		}
	    		
	    	}//onClick
	    	
	    	private void showGeneralSleepInfo(){
	    		//Creates the new dialog 
	    		Dialog dialog = new Dialog(SleepInfoActivity.this);
        	
	    		//points to the generalSleepinfo xml file 
	    		dialog.setContentView(R.layout.generalsleepinfo);
            
	    		dialog.setTitle("General Sleep Info");
            
	    		//Makes it possible to cancel the dialog using the back key. 
	    		dialog.setCancelable(true);
            
	    		//set up text that is to be shown in the dialog box 
	    		TextView text = (TextView) dialog.findViewById(R.id.generalSleepInfoText);
	    		text.setText(R.string.general_sleep_info);
	    		
	    		//set up image view
                ImageView img = (ImageView) 
                dialog.findViewById(R.id.zzz_image_generalsleepinfo);
                img.setImageResource(R.drawable.ic_launcher);

	    		//to show the dialog    
	    		dialog.show();
	    	}//showGeneralSleepInfo 
	    	
	  
	    	private void showSleepStyles(){

	    		//Creates the new dialog 
	    		Dialog dialog = new Dialog(this);
        	
	    		//points to Sleepstyles xml file 
	    		dialog.setContentView(R.layout.sleepstyledialog);
            
	    		dialog.setTitle("Different Sleep Styles");
	    		
	    		//set up button
                Button ubermanButton = (Button) dialog.findViewById(R.id.uberman_button);
                ubermanButton.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                        createUbermanDialog();
                    }
                });
            
	    		//Makes it possible to cancel the dialog using the back button. 
	    		dialog.setCancelable(true);

	    		//to show the dialog    
	    		dialog.show();
	    
	    	}//showSleepStyles
	    	
	    	private void createUbermanDialog(){
	    		//Creates the new dialog 
	    		Dialog dialog = new Dialog(SleepInfoActivity.this);
        	
	    		//points to the generalSleepinfo xml file 
	    		dialog.setContentView(R.layout.generalsleepinfo);
            
	    		dialog.setTitle("General Sleep Info");
            
	    		//Makes it possible to cancel the dialog using the back key. 
	    		dialog.setCancelable(true);
            
	    		//set up text that is to be shown in the dialog box 
	    		TextView text = (TextView) dialog.findViewById(R.id.generalSleepInfoText);
	    		text.setText(R.string.general_sleep_info);
	    		
	    		//set up image view
                ImageView img = (ImageView) 
                dialog.findViewById(R.id.zzz_image_generalsleepinfo);
                img.setImageResource(R.drawable.ic_launcher);

	    		//to show the dialog    
	    		dialog.show();
	    	}//showGeneralSettings 

   }//Activity 

