package service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataGenerator {
	//lat -90 to +90
	//longitude -180 to +180
	static float latitude = (float) 37.772323 ;
	static float longitude = (float) -122.214897 ;
	
	public String generateData() 
	{
		float addLatitude = (float) Math.random()/10 ;
		float addLongitude = (float) Math.random()/10 ;
		latitude = latitude +  addLatitude ;
		longitude = longitude + addLongitude ;
		if (latitude >85 || longitude>175 )
		{
			longitude = -170;
			latitude = -75 ;
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String timestamp = dateFormat.format(date) ;
		String GPSData = "{ 'lat' '" + latitude + "' , 'long' '" + longitude + "' , 'time' '"  +  timestamp +  "' }"  ;
		return GPSData ;
	}
}
