import core.GPSData;
import java.io.BufferedWriter;
import java.io.FileWriter;
import service.DataGenerator;

public class Main {
	
	public static void main ( String args[]) throws InterruptedException
	{
		System.out.println("Gaurav Paliwal") ;
		GPSData gPSData  = new GPSData () ;
		DataGenerator dataGenerator = new DataGenerator() ;
		while( true )
		{
			System.out.println(dataGenerator.generateData()) ;
			Thread.sleep(2000) ;
			try	{
					  FileWriter fileWriter = new FileWriter("/home/gaurav/Desktop/GPSData.txt");
					  BufferedWriter bufferedReader = new BufferedWriter(fileWriter);
					  bufferedReader.write(dataGenerator.generateData());
					  bufferedReader.close();
				}			  
			catch (Exception e)
				{
					System.err.println("Error: " + e.getMessage());
				}
						
		}
		
		
		
	}
	
}
