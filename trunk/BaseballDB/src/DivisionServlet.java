

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
public class DivisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DivisionServlet() {
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
           /* 
            if (request.getParameter("division1") == null)
            {
            	checkBox1="";checkBox2 = "D.LEAGUE";
            	count--;
            }*/
            if (request.getParameter("division2") == null )
            {
            	checkBox2="";
            	count--;
            }
            if (request.getParameter("division3") == null)
            {
            	checkBox3="";
            	count--;
            }
          
            String select1 = "SELECT DISTINCT " + checkBox1 + checkBox2 + checkBox3 ;
            
            query = select1 + " FROM Division D";

            ResultSet r = s.executeQuery(query);
             
             out.println("<center>");
             out.println("<table border = \"2\">");
             out.println("<caption align=\"center\"><H1>Divisions</H1></caption>");
             out.println("<tr>");
             if(!checkBox1.equals(""))out.println("<td>" + "<b>Division ID</b>"  + "</td>");
             if(!checkBox2.equals(""))out.println("<td>" + "<b>League</b>"  + "</td>");
             if(!checkBox3.equals(""))out.println("<td>" + "<b>Location</b>"  + "</td>");
             out.println("<td><b>Choose For Deletion</b></td>");
             
             out.println("</tr>");
             out.println("<form action=\"DBChangeServlet\" method=\"POST\" name = \"DBChange\">");
             int i=0;
             while(r.next()){
            	 out.println("<tr>");
            	 for(i=0;i<count;i++)
            	 {
            	 out.println("<td>" + r.getString(i+1) + "</td>"); 
            	            	 
            	 }
            	 out.println("<td><input type=\"radio\" name=\"Division\" value=\"" + r.getString(1) + "\" align=\"center\"></td>");
            	             	 
            	 out.println("</tr>");
             }
            // out.println( "<form action= \"DivisionServlet\" method = \"POST\"><div  align=\"center\"  name = \"DivisionForm\">" );
             
             
             out.println("<tr>");
             
             out.println("<td><b>Deselect Columns</b></td>");
             /*if(!checkBox1.equals(""))out.println("<td> <input type=\"checkbox\" name=\"division1\" style = \"visibility:hidden\" checked> </td>");*/
             if(!checkBox2.equals(""))out.println("<td> <input type=\"checkbox\" name=\"division2\" checked> </td>");
             if(!checkBox3.equals(""))out.println("<td> <input type=\"checkbox\" name=\"division3\" checked> </td>");
             
             out.println("</tr>");
             //out.println("</div></form>");
             out.println("</table>");
             
             out.println("<br>");
             out.println("<input type=\"submit\" name=\"DBChange\" value=\"Division Update View\" >");
             out.println("<br>"); out.println("<br>");
             out.println("<input type=submit name=\"DBChange\" value=\"division update\">" + 
             			"<input type=submit name=\"DBChange\" value=\"division create\">" + 
             			"<input type=submit name=\"DBChange\" value=\"division delete\">" + 
             			
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
