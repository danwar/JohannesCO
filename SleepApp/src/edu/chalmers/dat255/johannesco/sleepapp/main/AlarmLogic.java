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

import android.content.SharedPreferences;

public class AlarmLogic {
	// Array för lägg-tider
	public int sleep[] = new int[6];
	
	// Array för vakna-tider
	public int wake[] = new int[6];
	
	SharedPreferences sleepData;

	// SetUp tiderna man ska lägga sig hela veckan
	public void sleepSetup(int time) {
		sleep[0] = time;	
		for (int i=1; i<6; i++){
				sleep[i] = sleep[i-1] + 28*60*60*1000;
		}
	}
	// SetUp tiderna man ska vakna hela veckan
	public void wakeSetup(int time) {
		wake[0] = time;	
		for (int i=1; i<6; i++){
				wake[i] = wake[i-1] + 28*60*60*1000;
		}
	}

//	public int getSleepTime() {
//		int sleepTime = sleep[0];
//		return sleepTime;
//	}

	public long getSleepTime() {
		long sleepTime = sleep[0];
		return sleepTime;
	}
	public long getWakeTime() {
		long wakeTime = wake[0];
		return wakeTime;
	}
	
}





