package datasave;

import core.GPSData;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DataRead {
	public GPSData getData()
	{
		try
		 {
			  FileInputStream fstream = new FileInputStream("/home/gaurav/Desktop/GPSData.txt");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;

			  while ((strLine=br.readLine()) != null)   
			  {
				  System.out.println (strLine);
				  String[] data = strLine.split(",") ;
				  String latitude = data[0].substring(9, data[0].trim().length()-1) ;
				  System.out.println(latitude) ;
				  String longitude = data[1].substring(9, data[1].trim().length()-1) ;
				  System.out.println(longitude) ;
				  String timestamp = data[2].substring(9, data[2].trim().length()-2) ;
				  System.out.println(timestamp) ;
				  
				  GPSData gPSData = new GPSData() ;
				  gPSData.setLatitude((Double.parseDouble(latitude)));
				  gPSData.setLongitude((Double.parseDouble(longitude)));
				  
				  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				  java.util.Date parsedDate = dateFormat.parse(timestamp);
				  Timestamp timeStamp = new java.sql.Timestamp(parsedDate.getTime()) ;
				  gPSData.setTimestamp(timeStamp);
				  
				  System.out.println() ;
				  
				  return gPSData ;
			  }
			  

			  in.close();
		  }

		catch (Exception e)
		  {
			System.err.println("Error: " + e.getMessage());
		  }
		return null ;
	}
}
