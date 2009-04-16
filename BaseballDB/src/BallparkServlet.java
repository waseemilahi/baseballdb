

import java.io.IOException;
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
public class BallparkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BallparkServlet() {
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
        PrintWriter out = response.getWriter();

        String dbUser = "wki2001"; // enter your username here
        String dbPassword = "coms4111"; // enter your password here
        
        String checkBox1 = "B.PARK_ID";
        String checkBox2 = " , B.CAPACITY";
        String checkBox3 = " , B.NAME";
        String checkBox4 = " , B.YEARBUILT";
        String checkBox5 = " , B.TYPE";
        
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
            ods.setUser(dbUser);
            ods.setPassword(dbPassword);

            Connection conn = ods.getConnection();
            
            int count = 5;  
            
            String query = new String();
            Statement s = conn.createStatement();
            
           
            if (request.getParameter("ballpark2") == null )
            {
            	checkBox2="";
            	count--;
            }
            if (request.getParameter("ballpark3") == null)
            {
            	checkBox3="";
            	count--;
            }
            if (request.getParameter("ballpark4") == null )
            {
            	checkBox4="";
            	count--;
            }
            if (request.getParameter("ballpark5") == null)
            {
            	checkBox5="";
            	count--;
            }
            String select1 = "SELECT DISTINCT " + checkBox1 + checkBox2 + checkBox3 + checkBox4 + checkBox5 ;
            
            query = select1 + " FROM Ballpark B";
            
           
             ResultSet r = s.executeQuery(query);
             
             out.println("<center>");
             out.println("<table border = \"2\">");
             out.println("<caption align=\"center\"><H1>BallParks</H1></caption>");
             out.println("<tr>");
             if(!checkBox1.equals(""))out.println("<td>" + "<b>Park ID</b>"  + "</td>");
             if(!checkBox2.equals(""))out.println("<td>" + "<b>Capacity</b>"  + "</td>");
             if(!checkBox3.equals(""))out.println("<td>" + "<b>Name</b>"  + "</td>");
             if(!checkBox4.equals(""))out.println("<td>" + "<b>Year Built</b>"  + "</td>");
             if(!checkBox5.equals(""))out.println("<td>" + "<b>Type</b>"  + "</td>");
             out.println("<td><b>Choose For Deletion</b></td>");
             
             out.println("</tr>");
             out.println("<form action=\"DBChangeServlet\" method=\"POST\" name = \"DBDirector\">");
             int i=0;
             while(r.next()){
            	 out.println("<tr>");
            	 for(i=0;i<count;i++)
            	 {
            	 out.println("<td>" + r.getString(i+1) + "</td>"); 
            	            	 
            	 }
            	 out.println("<td><input type=\"radio\" name=\"BallparkButton\" value=\"" + r.getString(1) + "\" align=\"center\"></td>");
            	 
            	 out.println("</tr>");
             }
             //out.println( "<form action= \"BallparkServlet\" method = \"POST\"><div  align=\"center\">" );
             
             
             out.println("<tr>");
             
             out.println("<td><b>Deselect Columns</b></td>");
             //if(!checkBox1.equals(""))out.println("<td> <input type=\"checkbox\" name=\"ballpark1\" checked> </td>");
             if(!checkBox2.equals(""))out.println("<td> <input type=\"checkbox\" name=\"ballpark2\" checked> </td>");
             if(!checkBox3.equals(""))out.println("<td> <input type=\"checkbox\" name=\"ballpark3\" checked> </td>");
             if(!checkBox4.equals(""))out.println("<td> <input type=\"checkbox\" name=\"ballpark4\" checked> </td>");
             if(!checkBox5.equals(""))out.println("<td> <input type=\"checkbox\" name=\"ballpark5\" checked> </td>");
             
             
             
             
             out.println("</tr>");
             out.println("</table>");
             
             
             out.println("<br>");
             out.println("<input type=\"submit\" name=\"DBDirector\" value=\"Ballpark Update View\" >");
             out.println("<br>"); out.println("<br>");
             out.println("<input type=submit name=\"DBDirector\" value=\"ballpark update\">" + 
             			"<input type=submit name=\"DBDirector\" value=\"ballpark create\">" + 
             			"<input type=submit name=\"DBDirector\" value=\"ballpark delete\">" + 
             			"</form>");
             out.println("</center>");
             r.close();
            
             s.close();
             conn.close();


    }
    catch (Exception e) {
            out.println("The database could not be accessed.<br>");
            out.println("More information is available as follows:<br>");
            e.printStackTrace(out);
    }

	}

}
