

import android.content.SharedPreferences;

public class AlarmLogic {
	// Array för lägg-tider
	public int sleep[] = new int[6];
	
	// Array för vakna-tider
	public int wake[] = new int[6];
	
	SharedPreferences sleepData;


	public void SleepSetup(int time) {
		sleep[0] = time;	
		for (int i=1; i<6; i++){
				sleep[i] = sleep[i-1] + 28*60*60*1000;
		}
	}
	
	public void WakeSetup(int time) {
		wake[0] = time;	
		for (int i=1; i<6; i++){
				wake[i] = wake[i-1] + 28*60*60*1000;
		}
	}
	
}


