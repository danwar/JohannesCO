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

