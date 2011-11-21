/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author gaurav
 */
public class DataJSON extends HttpServlet {

	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/** 
	 * Handles the HTTP <code>GET</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
		response.setContentType("text/javascript");   
		PrintWriter out = response.getWriter();
		try {
			
			String url = "jdbc:mysql://localhost:3306/";
		        String dbName = "TrackOn";
		        String driver = "com.mysql.jdbc.Driver";
		        String userName = "root"; 
		        String password = "gaurav";
		        Class.forName(driver).newInstance();
		        Connection conn = null;
		        conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
			Statement statement = (Statement) conn.createStatement() ;
			ResultSet resultSet = statement.executeQuery("Select * from TrackOn") ;
			JSONArray jsonArray = new JSONArray() ;
			int index = 1 ;
			while (resultSet.next())
			{

				JSONObject json = new JSONObject() ;
				json.put("log", Double.toString(resultSet.getDouble("Long")) ) ;
				json.put("lat", Double.toString(resultSet.getDouble("Lat"))) ;
				json.put("timestamp", resultSet.getTimestamp("currentTimeStamp").toString()) ;
				jsonArray.add(json);
				index++ ;
				
			}
			
			
			/*JSONObject lat = new JSONObject() ;
			JSONObject log = new JSONObject() ;	
			JSONObject timeStamp = new JSONObject() ;			
			lat.put("log", "1234569") ;
			log.put("lat", "1234569") ;
			timeStamp.put("timestamp", "fdg") ;
			json.add(lat) ;
			json.add(log) ;
			json.add(timeStamp) ;*/
			out.write(jsonArray.toString());
			out.flush();

			
			/* TODO output your page here

			out.println("<head>");
			out.println("<title>Servlet DataJSON</title>");  
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet DataJSON at " + request.getContextPath () + "</h1>");
			out.println("</body>");
			out.println("</html>");
			 */
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {			
			out.close();
		}
		
	}

	/** 
	 * Handles the HTTP <code>POST</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/** 
	 * Returns a short description of the servlet.
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
