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

public class Converter {
    public int intToMillis(int hour, int min){
   	 int timeMillis = (hour * 60 + min) * 60 * 1000;
   	 return timeMillis;
   }
   
   public int millisToHour(int Millis){
   	int temp = Millis / (1000 * 60);
   	int hour = (int) Math.floor(temp / 60);
   	return hour;
   }
   
   public int millisToMin(int Millis){
   	int temp = Millis / (1000 * 60);
   	int hour = (int) Math.floor(temp / 60);
   	int min = temp - hour*60;
   	return min;
   }	
}

