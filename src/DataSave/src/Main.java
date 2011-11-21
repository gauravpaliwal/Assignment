
import core.GPSData;
import datasave.DataRead;
import datasave.DataSave;


public class Main {
	
	public static void main (String args[]) throws InterruptedException
	{	
		while(true)
			{
				DataSave dataSave = new DataSave();GPSData gPSData = new DataRead().getData() ;
				System.out.println(gPSData.getLatitude() +  ""  + gPSData.getLongitude() + "" + gPSData.getTimestamp() ) ;
				dataSave.saveData(gPSData); 
				Thread.sleep(8000) ;
			}
		
		
	}
	
}
