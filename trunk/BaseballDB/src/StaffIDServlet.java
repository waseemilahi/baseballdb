

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
public class StaffIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffIDServlet() {
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
        String staffID = request.getParameter("StaffID");
        String checkBox1 = "S.STAFF_SSN";
        String checkBox2 = " , S.NAME";
        String checkBox3 = " , S.TITLE";
        String checkBox4 = " , S.SALARY";
        String checkBox5 = " , S.ADDRESS";
        String checkBox6 = " , S.PARK_ID";
  
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
            ods.setUser(dbUser);
            ods.setPassword(dbPassword);

            Connection conn = ods.getConnection();
            
            int count = 6;  
            
            String query = new String();
            Statement s = conn.createStatement();
            
            if (request.getParameter("staff1") == null)
            {
            	checkBox1="";checkBox2 = "S.NAME";
            	count--;
            }
            if (request.getParameter("staff2") == null )
            {
            	checkBox2="";if(count == 5)checkBox3 = "S.TITLE";
            	count--;
            }
            if (request.getParameter("staff3") == null)
            {
            	checkBox3="";if(count == 4)checkBox4 = "S.SALARY";
            	count--;
            }
            if (request.getParameter("staff4") == null )
            {
            	checkBox4="";if(count == 3)checkBox5 = "S.ADDRESS";
            	count--;
            }
            if (request.getParameter("staff5") == null)
            {
            	checkBox5="";if(count == 2)checkBox6 = "S.PARK_ID";
            	count--;
            }
            if (request.getParameter("staff6") == null )
            {
            	checkBox6="";
            	count--;
            }

            String select1 = "SELECT DISTINCT " + checkBox1 + checkBox2 + checkBox3 + checkBox4 + checkBox5 + checkBox6;
            
            query = select1 + " FROM Staff S WHERE S.STAFF_SSN = " + staffID;
            
            if(count >0)
            {
            
             ResultSet r = s.executeQuery(query);
             
             out.println("<center>");
             out.println("<table border = \"2\">");
             out.println("<caption align=\"center\"><H1>Requested Manager</H1></caption>");
             out.println("<tr>");
             if(!checkBox1.equals(""))out.println("<td>" + "<b>S.S. Number</b>"  + "</td>");
             if(!checkBox2.equals(""))out.println("<td>" + "<b>Name</b>"  + "</td>");
             if(!checkBox3.equals(""))out.println("<td>" + "<b>Title</b>"  + "</td>");
             if(!checkBox4.equals(""))out.println("<td>" + "<b>Salary</b>"  + "</td>");
             if(!checkBox5.equals(""))out.println("<td>" + "<b>Address</b>"  + "</td>");
             if(!checkBox6.equals(""))out.println("<td>" + "<b>Park ID</b>"  + "</td>");
             out.println("</tr>");
             int is_park_id = 0; 
             if(!checkBox6.equals("")){count--;is_park_id = 1;}
             int i=0;
             while(r.next()){
            	 out.println("<tr>");
            	 if(is_park_id == 1){
            	 for(i=0;i<count;i++)
            	 {
            	 out.println("<td>" + r.getString(i+1) + "</td>"); 
            	            	 
            	 }
            	 out.println("<td>" + "<form action= \"ParkIDServlet\" method = \"POST\"><input type=\"checkbox\" name=\"ballpark1\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"ballpark2\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"ballpark3\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"ballpark4\" style = \"visibility:hidden\" checked><br><input type=\"text\" name = \"ParkID\" value = \"'"+r.getString(count+1)+"'\" style = \"visibility:hidden\"><input type=\"checkbox\" name=\"ballpark5\" style = \"visibility:hidden\" checked></form>" + "</td>");
            	 }
            	 else if(is_park_id == 0)
            	 {
            		 for(i=0;i<count;i++)
                	 {
                	 out.println("<td>" + r.getString(i+1) + "</td>"); 
                	 
                	 }
            	 }
            	 out.println("</tr>");
             }
             out.println( "<form action= \"StaffIDServlet\" method = \"POST\"><div  align=\"center\">" );
             
             
             out.println("<tr>");
             
             
             if(!checkBox1.equals(""))out.println("<td> <input type=\"checkbox\" name=\"staff1\" checked> </td>");
             if(!checkBox2.equals(""))out.println("<td> <input type=\"checkbox\" name=\"staff2\" checked> </td>");
             if(!checkBox3.equals(""))out.println("<td> <input type=\"checkbox\" name=\"staff3\" checked> </td>");
             if(!checkBox4.equals(""))out.println("<td> <input type=\"checkbox\" name=\"staff4\" checked> </td>");
             if(!checkBox5.equals(""))out.println("<td> <input type=\"checkbox\" name=\"staff5\" checked> </td>");
             if(!checkBox6.equals(""))out.println("<td> <input type=\"checkbox\" name=\"staff6\" checked> </td>");
             
             
             
             out.println("</tr>");
             out.println("</table>");
             out.println("<input type=\"text\" name = \"StaffID\" value = \""+staffID+"\" style = \"visibility:hidden\">");
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
