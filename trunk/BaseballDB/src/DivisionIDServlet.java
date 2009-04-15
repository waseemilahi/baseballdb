

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
public class DivisionIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DivisionIDServlet() {
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
        String divisionID = request.getParameter("DivisionID");
        String checkBox1 = "D.DIV_ID";
        String checkBox2 = " , D.LEAGUE";
        String checkBox3 = " , D.LOCATION";
        
                
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
            ods.setUser(dbUser);
            ods.setPassword(dbPassword);

            Connection conn = ods.getConnection();
            int count = 3;  
            String query = new String();
            Statement s = conn.createStatement();
            
            if (request.getParameter("division1") == null)
            {
            	checkBox1="";checkBox2 = "D.LEAGUE";
            	count--;
            }
            if (request.getParameter("division2") == null )
            {
            	checkBox2="";if(count == 2)checkBox3 = "D.LOCATION";
            	count--;
            }
            if (request.getParameter("division3") == null)
            {
            	checkBox3="";
            	count--;
            }
          
            String select1 = "SELECT DISTINCT " + checkBox1 + checkBox2 + checkBox3 ;
            
            query = select1 + " FROM Division D WHERE D.DIV_ID = " + divisionID;

            if(count >0)
            {
            
             ResultSet r = s.executeQuery(query);
             
             out.println("<center>");
             out.println("<table border = \"2\">");
             out.println("<caption align=\"center\"><H1>Requested Division</H1></caption>");
             out.println("<tr>");
             if(!checkBox1.equals(""))out.println("<td>" + "<b>Division ID</b>"  + "</td>");
             if(!checkBox2.equals(""))out.println("<td>" + "<b>League</b>"  + "</td>");
             if(!checkBox3.equals(""))out.println("<td>" + "<b>Location</b>"  + "</td>");
             
             out.println("</tr>");
             
             int i=0;
             while(r.next()){
            	 out.println("<tr>");
            	 for(i=0;i<count;i++)
            	 {
            	 out.println("<td>" + r.getString(i+1) + "</td>"); 
            	            	 
            	 }
            	             	 
            	 out.println("</tr>");
             }
             out.println( "<form action= \"DivisionIDServlet\" method = \"POST\"><div  align=\"center\">" );
             
             
             out.println("<tr>");
             
             
             if(!checkBox1.equals(""))out.println("<td> <input type=\"checkbox\" name=\"division1\" checked> </td>");
             if(!checkBox2.equals(""))out.println("<td> <input type=\"checkbox\" name=\"division2\" checked> </td>");
             if(!checkBox3.equals(""))out.println("<td> <input type=\"checkbox\" name=\"division3\" checked> </td>");
             
             out.println("</tr>");
             out.println("</table>");
             out.println("<input type=\"text\" name = \"DivisionID\" value = \""+divisionID+"\" style = \"visibility:hidden\">");
             out.println("<table>");
             
             out.println("<center><input type=\"submit\" value=\"Update View\" style=\"horizontal-align:middle;\"></center>");
             
             out.println("</div></form>");
             out.println("</table>");
             out.println("</center>"); 
             
             r.close();
            }
            else out.println("You Deselected All the boxes.  TRY AGAIN!");
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
