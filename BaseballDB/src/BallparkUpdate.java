

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.*;

/**
 * Servlet implementation class BaseballServlet
 */
public class BallparkUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BallparkUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out1 = response.getWriter();
        String choice=request.getParameter("BallPark");

        String dbUser = "wki2001"; // enter your username here
        String dbPassword = "coms4111"; // enter your password here
        
        String checkBox2 = "";
        String checkBox3 = "";
        String checkBox4 = "";
        String checkBox5 = "";
       
      
                
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
            ods.setUser(dbUser);
            ods.setPassword(dbPassword);

            Connection conn = ods.getConnection();
              
            String query = new String();
            Statement s = conn.createStatement();
            
            if(request.getParameter("CAPACITY").length()!=0)checkBox2= "CAPACITY = '" + request.getParameter("CAPACITY")+ "'";
            if(request.getParameter("NAME").length()!=0)checkBox3= " NAME = '" + request.getParameter("NAME")+"'";
            if(request.getParameter("Year Built").length()!=0)checkBox4= " YEARBUILT = '" +request.getParameter("Year Built")+"'";
            if(request.getParameter("TYPE").length()!=0)checkBox5= " TYPE = '" + request.getParameter("TYPE")+"'";
            
          
          if((checkBox2.length()!=0) && (checkBox3.length()!=0))checkBox3 = "," + checkBox3;
          if((checkBox2.length()!=0) && (checkBox4.length()!=0) || (checkBox3.length()!=0) && (checkBox4.length()!=0))checkBox4 = "," + checkBox4;
          if((checkBox2.length()!=0) && (checkBox5.length()!=0) || (checkBox3.length()!=0) && (checkBox5.length()!=0) || (checkBox4.length()!=0) && (checkBox5.length()!=0))checkBox5 = "," + checkBox5;
          
                             
            query = "UPDATE BALLPARK  SET " + checkBox2 + checkBox3 + checkBox4 + checkBox5 +  " WHERE PARK_ID = '"+ request.getParameter("BallPark")+"'"  ;

            if((request.getParameter("Year Built").length()==0) || intYearCheck(response,"ballpark", request.getParameter("Year Built"))){
               if((request.getParameter("CAPACITY").length()==0) || intCapacityCheck(response,"ballpark",request.getParameter("CAPACITY")))
            {
            
            ResultSet r = s.executeQuery(query);
            
            out1.println("<BR><BR><BR>");
            out1.println( "<form action=\"BallparkServlet\" method = \"POST\">" );
              out1.println(" <input type=\"checkbox\" name=\"ballpark1\" style= \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"ballpark2\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"ballpark3\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"ballpark4\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"ballpark5\" style = \"visibility:hidden\" checked> ");
                  out1.println("<input type=\"submit\" value=\"View Updated Ballpark Table\" checked>");
                  out1.println("</form>");
           
             r.close();
            
             s.close();
             conn.close();
            }
            }

    }
    catch (Exception e) {
            out1.println("The database could not be accessed.<br>");
            out1.println(e.getMessage());
            
    }

	}
	public boolean intCapacityCheck( HttpServletResponse response,String table,String capacity)throws IOException
	{
		
		int tmpcap;
    	try{
    	tmpcap = Integer.parseInt(capacity);
    	
    	if(tmpcap<0 || tmpcap > 65000)
    	{
    		errorprint("<BR> Invalid Entry for Capacity Field! TRY AGAIN.<BR>",table,response);
    	}
    	else return true;
    	}
    	catch(NumberFormatException n)
    	{
    		errorprint("<BR>ENTER A Five DIGIT NUMBER FOR THE Capacity FIELD.<BR>",table,response);
    	}
    	return false;
	}
	public boolean intYearCheck(HttpServletResponse response, String table, String year) throws IOException{
		int tmpyear;
    	try{
    	tmpyear = Integer.parseInt(year);
    	
    	if(tmpyear<1000)
    	{
    		errorprint("<BR> Invalid Entry for Year Built Field! TRY AGAIN.<BR>",table,response);
    	}
    	else return true;
    	}
    	catch(NumberFormatException n)
    	{
    		errorprint("<BR>ENTER A FOUR DIGIT NUMBER FOR THE YEAR BUILT FIELD.<BR>",table,response);
    	}
    	return false;
	}
	public void errorprint(String message,String tableType,HttpServletResponse response )throws IOException {

		response.setContentType("text/html");
		PrintWriter out1 = response.getWriter();
		out1.println(message);
		out1.println("<form action=\"DBChangeServlet\" DBDirector method=\"POST\">" +
				"<br>" +
				"<br>" +
		"<FONT SIZE=\"3\" COLOR=\"#006600\" FACE=\"verdana\">" +
		
		"<br>" +
		"<input type=submit name=\"DBDirector\" value=\""+ tableType + " update\">" +
		"<input type=submit name=\"DBDirector\" value=\""+ tableType + " create\">" +
		"</FONT></form>");
		}

}
