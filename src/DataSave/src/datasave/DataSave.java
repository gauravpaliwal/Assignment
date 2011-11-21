package datasave;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import core.GPSData;
import java.sql.DriverManager;

public class DataSave {
	
	  private String url = "jdbc:mysql://localhost:3306/";
	  private String dbName = "TrackOn";
	  private String driver = "com.mysql.jdbc.Driver";
	  private String userName = "root"; 
	  private String password = "gaurav";
	
	public void saveData (GPSData data) 
	{
	Connection conn = null;
	  
	try {
		  Class.forName(driver).newInstance();
		  conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
		  PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("INSERT INTO TrackOn  ( `Lat`, `Long` , `currentTimeStamp`) VALUES (  ?, ?, ?)") ;
		  preparedStatement.setFloat(1,(float) data.getLatitude());
		  preparedStatement.setFloat(2, (float) data.getLongitude());
		  preparedStatement.setTimestamp(3, data.getTimestamp());
		  preparedStatement.executeUpdate();
		  conn.close();
		  
	  } 
	catch (Exception e) 
	  {
		   System.out.println("This entry is already existing, position of the person is static, there is no change in the person position.") ;
	  }
	}
	  
	
}
