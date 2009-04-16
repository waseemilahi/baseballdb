

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
public class TeamUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamUpdate() {
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
        

        String dbUser = "wki2001"; // enter your username here
        String dbPassword = "coms4111"; // enter your password here
        
        String checkBox2 = "";
        String checkBox3 = "";
        String checkBox4 = "";
        String checkBox5 = "";
        String checkBox6 = "";
     
       
      
                
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
            ods.setUser(dbUser);
            ods.setPassword(dbPassword);

            Connection conn = ods.getConnection();
             
            String query = new String();
            Statement s = conn.createStatement();
            
            if(request.getParameter("NAME").length()!=0)checkBox2= "NAME = '" + request.getParameter("NAME")+"'";
            if(request.getParameter("STATE").length()!=0)checkBox3= " STATE = '" + request.getParameter("STATE")+"'";
            if(request.getParameter("DIVISION").length()!=0)checkBox4= " DIV_ID = '" + request.getParameter("DIVISION")+"'";
            if(request.getParameter("PARK").length()!=0)checkBox5= " PARK_ID = '" + request.getParameter("PARK")+"'";
            if(request.getParameter("STAFF").length()!=0)checkBox6= " STAFF_SSN = '" + request.getParameter("STAFF")+"'";
            
          
          if((checkBox2.length()!=0) && (checkBox3.length()!=0))checkBox3 = "," + checkBox3;
          if((checkBox2.length()!=0) && (checkBox4.length()!=0) || (checkBox3.length()!=0) && (checkBox4.length()!=0))checkBox4 = "," + checkBox4;
          if((checkBox2.length()!=0) && (checkBox5.length()!=0) || (checkBox3.length()!=0) && (checkBox5.length()!=0) || (checkBox4.length()!=0) && (checkBox5.length()!=0))checkBox5 = "," + checkBox5;
          
          if(checkBox2.length()!=0 || checkBox3.length()!=0 || checkBox4.length()!=0 || checkBox5.length()!=0)checkBox6 = ","+checkBox6;
        	
          out1.println("<BR><BR>");            
            query = "UPDATE TEAM  SET " + checkBox2 + checkBox3 + checkBox4 + checkBox5+ checkBox6 +  " WHERE TEAM_ID = '"+ request.getParameter("TEAM")+"'"  ;
  
            
            ResultSet r = s.executeQuery(query);
            
            out1.println("<BR><BR><BR>");
            out1.println( "<form action=\"TeamServlet\" method = \"POST\">" );
              out1.println(" <input type=\"checkbox\" name=\"team1\" style= \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"team2\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"team3\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"team4\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"team5\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"team6\" style = \"visibility:hidden\" checked> ");
                  out1.println("<input type=\"submit\" value=\"View Updated Team Table\" checked>");
                  out1.println("</form>");
           
           
             r.close();
            
             s.close();
             conn.close();
         


    }
    catch (SQLException e) {
    	if( e.getSQLState().equals("23000"))
        {
       	 out1.println("<center><BR> Must Have A Unique Manager For Each Team! Try Again.<BR><BR>");
       	 out1.println("<form action=\"DBChangeServlet\" name=\"DBDirector\" method=\"POST\">" +
       				"<input type=submit name=\"DBDirector\" value=\"team update\">" +
       				"<input type=submit name=\"DBDirector\" value=\"team create\">" +
       				"</FONT></form></center>");
        }
            
    }

	}

}
