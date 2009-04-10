

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
public class OwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerServlet() {
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
        
        String checkBox1 = "O.OWNER_SSN";
        String checkBox2 = " , O.NAME";
        String checkBox3 = " , O.WORTH";
        String checkBox4 = " , O.TEAM_ID";
                
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
            ods.setUser(dbUser);
            ods.setPassword(dbPassword);

            Connection conn = ods.getConnection();
            int count = 4;  
            String query = new String();
            Statement s = conn.createStatement();
            
            if (request.getParameter("owner1") == null)
            {
            	checkBox1="";checkBox2 = "O.NAME";
            	count--;
            }
            if (request.getParameter("owner2") == null )
            {
            	checkBox2="";if(count == 3)checkBox3 = "O.WORTH";
            	count--;
            }
            if (request.getParameter("owner3") == null)
            {
            	checkBox3="";if(count == 2)checkBox4 = "O.TEAM_ID";
            	count--;
            }
            if (request.getParameter("owner4") == null )
            {
            	checkBox4="";
            	count--;
            }

            String select1 = "SELECT DISTINCT " + checkBox1 + checkBox2 + checkBox3 + checkBox4;
            
            query = select1 + " FROM Owner O";

            if(count >0)
            {
            
             ResultSet r = s.executeQuery(query);
             
             out.println("<center>");
             out.println("<table border = \"2\">");
             out.println("<caption align=\"center\"><H1>Owners</H1></caption>");
             out.println("<tr>");
             if(!checkBox1.equals(""))out.println("<td>" + "<b>Owner S.S. Number</b>"  + "</td>");
             if(!checkBox2.equals(""))out.println("<td>" + "<b>Name</b>"  + "</td>");
             if(!checkBox3.equals(""))out.println("<td>" + "<b>Worth</b>"  + "</td>");
             if(!checkBox4.equals(""))out.println("<td>" + "<b>Team ID</b>"  + "</td>");
             out.println("</tr>");
             int is_team_id = 0; 
             if(!checkBox4.equals("")){count--;is_team_id = 1;}
             
             int i=0;
             while(r.next()){
            	 out.println("<tr>");
            	 if(is_team_id == 1){
                	 for(i=0;i<count;i++)
                	 {
                	 out.println("<td>" + r.getString(i+1) + "</td>"); 
                	            	 
                	 }
                	 out.println("<td>" + "<form action= \"TeamServlet\" method = \"POST\"><input type=\"checkbox\" name=\"team1\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"team2\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"team3\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"team4\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"team5\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"team6\" style = \"visibility:hidden\" checked></form>" + "</td>");
                	 }
                	 else if(is_team_id == 0)
                	 {
                		 for(i=0;i<count;i++)
                    	 {
                    	 out.println("<td>" + r.getString(i+1) + "</td>"); 
                    	 
                    	 }
                	 }
            	             	 
            	 out.println("</tr>");
             }
             out.println( "<form action= \"OwnerServlet\" method = \"POST\"><div  align=\"center\">" );
             
             
             out.println("<tr>");
             
             
             if(!checkBox1.equals(""))out.println("<td> <input type=\"checkbox\" name=\"owner1\" checked> </td>");
             if(!checkBox2.equals(""))out.println("<td> <input type=\"checkbox\" name=\"owner2\" checked> </td>");
             if(!checkBox3.equals(""))out.println("<td> <input type=\"checkbox\" name=\"owner3\" checked> </td>");
             if(!checkBox4.equals(""))out.println("<td> <input type=\"checkbox\" name=\"owner4\" checked> </td>");             
             
             
             out.println("</tr>");
             out.println("</table>");
             out.println("<table>");
             
             out.println("<center><input type=\"submit\" value=\"Owner Table\" style=\"horizontal-align:middle;\"></center>");
             
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
