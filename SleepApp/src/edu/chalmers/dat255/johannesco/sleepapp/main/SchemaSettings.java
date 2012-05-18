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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SchemaSettings extends Activity implements OnClickListener {
	private Button backButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.schemasettings);
	    
	    backButton = (Button)findViewById(R.id.back_button); 
        backButton.setOnClickListener(this);
	
	    // TODO Auto-generated method stub
	}
	
public void onClick(View button) {
    	
    	switch (button.getId()) {
    			
    		case R.id.back_button:
    			Intent intent3 = new Intent(this, SettingsActivity.class);
    			startActivity(intent3);
    		break;
    	}
    }

}