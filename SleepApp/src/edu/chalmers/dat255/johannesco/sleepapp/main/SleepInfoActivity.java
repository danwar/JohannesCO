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

import android.app.Activity;
//import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SleepInfoActivity extends Activity implements OnClickListener {
	
	private Button generalSleepInfoButton, sleepStylesButton, backButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.sleepinfo);
	
	    //Initializing the buttons
	    generalSleepInfoButton = (Button)findViewById(R.id.generalSleepInfo_Button); 
	    sleepStylesButton = (Button)findViewById(R.id.sleepStyles_Button); 
	    backButton = (Button)findViewById(R.id.back_button); 
	    
	    //Giving the buttons sleepInfo Button a listener. 
	    generalSleepInfoButton.setOnClickListener(this);
	    sleepStylesButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
	    
	}//onCreate    	
	    	public void onClick(View v) {
	    		
	    		switch (v.getId()){ 
	    		
	    		case R.id.generalSleepInfo_Button:
	    			showGeneralSleepInfo();
	    		break;
	    		
	    		case R.id.sleepStyles_Button:
	    			showSleepStyles();
	    		break;
	    		
    			
	    		case R.id.back_button:
	    			Intent intent3 = new Intent(this, MenuActivity.class);
	    			startActivity(intent3);
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
	    		
	    		//set up ubermanbutton
                Button ubermanButton = (Button) dialog.findViewById(R.id.uberman_button);
                ubermanButton.setOnClickListener(new OnClickListener() {
              
                public void onClick(View v) {
                	createUbermanDialog();
                }
                });
                
              //set up monophasicbutton
                Button monophasicButton = (Button) dialog.findViewById(R.id.monophasic_button);
                monophasicButton.setOnClickListener(new OnClickListener() {
              
                public void onClick(View v) {
                	createMonophasicDialog();
                }
                });
                
                //set up biphasicbutton
                Button biphasicButton = (Button) dialog.findViewById(R.id.biphasic_button);
                biphasicButton.setOnClickListener(new OnClickListener() {
              
                public void onClick(View v) {
                	createBiphasicDialog();
                }
                });
                
              //set up dymaxionbutton
                Button dymaxionButton = (Button) dialog.findViewById(R.id.dymaxion_button);
                dymaxionButton.setOnClickListener(new OnClickListener() {
              
                public void onClick(View v) {
                	createDymaxionDialog();
                }
                });
                
              //set up everymanbutton
                Button everymanButton = (Button) dialog.findViewById(R.id.everyman_button);
                everymanButton.setOnClickListener(new OnClickListener() {
              
                public void onClick(View v) {
                	createEverymanDialog();
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
        	
	    		//points to the uberman xml file 
	    		dialog.setContentView(R.layout.ubermandialog);
            
	    		dialog.setTitle("Uberman sleeptype");
            
	    		//Makes it possible to cancel the dialog using the back key. 
	    		dialog.setCancelable(true);
            
	    		//set up text that is to be shown in the dialog box 
	    		TextView text = (TextView) dialog.findViewById(R.id.ubermantext);
	    		text.setText(R.string.uberman_info_text);
	    		
	    		//set up image view
                ImageView img = (ImageView) 
                dialog.findViewById(R.id.uberman_picture);
                img.setImageResource(R.drawable.uberman);

	    		//to show the dialog    
	    		dialog.show();
	    	}//ubermanDialog 
	    	
	    	private void createMonophasicDialog(){
	    		//Creates the new dialog 
	    		Dialog dialog = new Dialog(SleepInfoActivity.this);
        	
	    		//points to the monophasic xml file 
	    		dialog.setContentView(R.layout.monophasicdialog);
            
	    		dialog.setTitle("Monophasic sleeptype");
            
	    		//Makes it possible to cancel the dialog using the back key. 
	    		dialog.setCancelable(true);
            
	    		//set up text that is to be shown in the dialog box 
	    		TextView text = (TextView) dialog.findViewById(R.id.monophasictext);
	    		text.setText(R.string.monophasic_info_text);
	    		
	    		//set up image view
                ImageView img = (ImageView) 
                dialog.findViewById(R.id.monophasic_picture);
                img.setImageResource(R.drawable.monophasic);

	    		//to show the dialog    
	    		dialog.show();
	    	}//monophasic
	    	
	    	private void createBiphasicDialog(){
	    		//Creates the new dialog 
	    		Dialog dialog = new Dialog(SleepInfoActivity.this);
        	
	    		//points to the biphasic xml file 
	    		dialog.setContentView(R.layout.biphasicdialog);
            
	    		dialog.setTitle("Biphasic sleeptype");
            
	    		//Makes it possible to cancel the dialog using the back key. 
	    		dialog.setCancelable(true);
            
	    		//set up text that is to be shown in the dialog box 
	    		TextView text = (TextView) dialog.findViewById(R.id.biphasictext);
	    		text.setText(R.string.biphasic_info_text);
	    		
	    		//set up image view
                ImageView img = (ImageView) 
                dialog.findViewById(R.id.biphasic_picture);
                img.setImageResource(R.drawable.biphasic);

	    		//to show the dialog    
	    		dialog.show();
	    	}//biphasic
	    	
	    	private void createDymaxionDialog(){
	    		//Creates the new dialog 
	    		Dialog dialog = new Dialog(SleepInfoActivity.this);
        	
	    		//points to the dymaxion xml file 
	    		dialog.setContentView(R.layout.dymaxiondialog);
            
	    		dialog.setTitle("Dymaxion sleeptype");
            
	    		//Makes it possible to cancel the dialog using the back key. 
	    		dialog.setCancelable(true);
            
	    		//set up text that is to be shown in the dialog box 
	    		TextView text = (TextView) dialog.findViewById(R.id.dymaxiontext);
	    		text.setText(R.string.dymaxion_info_text);
	    		
	    		//set up image view
                ImageView img = (ImageView) 
                dialog.findViewById(R.id.dymaxion_picture);
                img.setImageResource(R.drawable.dymaxion);

	    		//to show the dialog    
	    		dialog.show();
	    	}//Dymaxion
	    	
	    	private void createEverymanDialog(){
	    		//Creates the new dialog 
	    		Dialog dialog = new Dialog(SleepInfoActivity.this);
        	
	    		//points to the everyman xml file 
	    		dialog.setContentView(R.layout.everymandialog);
            
	    		dialog.setTitle("Everyman sleeptype");
            
	    		//Makes it possible to cancel the dialog using the back key. 
	    		dialog.setCancelable(true);
            
	    		//set up text that is to be shown in the dialog box 
	    		TextView text = (TextView) dialog.findViewById(R.id.everymantext);
	    		text.setText(R.string.everyman_info_text);
	    		
	    		//set up image view
                ImageView img = (ImageView) 
                dialog.findViewById(R.id.everyman_picture);
                img.setImageResource(R.drawable.everyman);

	    		//to show the dialog    
	    		dialog.show();
	    	}//Everyman


   }//Activity 

