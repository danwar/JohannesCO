package johannes.co.sleepapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MenuActivity extends Activity implements OnClickListener {
    
	private Button schemaButton;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
       schemaButton = (Button)findViewById(R.id.schema_button);   
       
       schemaButton.setOnClickListener(this);
        
    }

	public void onClick(View arg0) {
		Intent intent = new Intent(this, SchemaActivity.class);
		startActivity(intent);
		
	}
}