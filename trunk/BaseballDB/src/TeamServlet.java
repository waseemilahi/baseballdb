

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
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamServlet() {
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
        
        String checkBox1 = "T.TEAM_ID";
        String checkBox2 = " , T.NAME";
        String checkBox3 = " , T.STATE";
        String checkBox4 = " , T.DIV_ID";
        String checkBox5 = " , T.PARK_ID";
        String checkBox6 = " , T.STAFF_SSN";
  
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
            ods.setUser(dbUser);
            ods.setPassword(dbPassword);

            Connection conn = ods.getConnection();
            
            int count = 6;  
            
            String query = new String();
            Statement s = conn.createStatement();
            
            if (request.getParameter("team1") == null)
            {
            	checkBox1="";checkBox2 = "T.NAME";
            	count--;
            }
            if (request.getParameter("team2") == null )
            {
            	checkBox2="";if(count == 5)checkBox3 = "T.STATE";
            	count--;
            }
            if (request.getParameter("team3") == null)
            {
            	checkBox3="";if(count == 4)checkBox4 = "T.DIV_ID";
            	count--;
            }
            if (request.getParameter("team4") == null )
            {
            	checkBox4="";if(count == 3)checkBox5 = "T.PARK_ID";
            	count--;
            }
            if (request.getParameter("team5") == null)
            {
            	checkBox5="";if(count == 2)checkBox6 = "T.STAFF_SSN";
            	count--;
            }
            if (request.getParameter("team6") == null )
            {
            	checkBox6="";
            	count--;
            }

            String select1 = "SELECT DISTINCT " + checkBox1 + checkBox2 + checkBox3 + checkBox4 + checkBox5 + checkBox6;
            
            query = select1 + " FROM Team T";
            
            if(count >0)
            {
            
             ResultSet r = s.executeQuery(query);
             
             out.println("<center>");
             out.println("<table border = \"2\">");
             out.println("<caption align=\"center\"><H1>Teams</H1></caption>");
             out.println("<tr>");
             if(!checkBox1.equals(""))out.println("<td>" + "<b>Team ID</b>"  + "</td>");
             if(!checkBox2.equals(""))out.println("<td>" + "<b>Name</b>"  + "</td>");
             if(!checkBox3.equals(""))out.println("<td>" + "<b>State</b>"  + "</td>");
             if(!checkBox4.equals(""))out.println("<td>" + "<b>Division ID</b>"  + "</td>");
             if(!checkBox5.equals(""))out.println("<td>" + "<b>Park ID</b>"  + "</td>");
             if(!checkBox6.equals(""))out.println("<td>" + "<b>Manager S.S. No.</b>"  + "</td>");
             out.println("</tr>");
             int is_division_id = 0; 
             int is_park_id = 0;
             int is_staff_ssn = 0;
             if(!checkBox4.equals("")){count--;is_division_id++;}
             if(!checkBox5.equals("")){count--;is_park_id++;}
             if(!checkBox6.equals("")){count--;is_staff_ssn++;}
             int i=0;
             while(r.next()){
            	 out.println("<tr>");
            	 if(is_division_id == 1 && is_park_id == 1 && is_staff_ssn == 1){
            	 for(i=0;i<count;i++)
            	 {
            	 out.println("<td>" + r.getString(i+1) + "</td>"); 
            	            	 
            	 }
            	 out.println("<td>" + "<form action= \"DivisionServlet\" method = \"POST\"><input type=\"checkbox\" name=\"division1\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"division2\" style = \"visibility:hidden\" checked><br><input type=\"checkbox\" name=\"division3\" style = \"visibility:hidden\" checked></form>" + "</td>");
            	 out.println("<td>" + "<form action= \"BallparkServlet\" method = \"POST\"><input type=\"checkbox\" name=\"ballpark1\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"ballpark2\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"ballpark3\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"ballpark4\" style = \"visibility:hidden\" checked><br><input type=\"checkbox\" name=\"ballpark5\" style = \"visibility:hidden\" checked></form>" + "</td>");
            	 out.println("<td>" + "<form action= \"StaffServlet\" method = \"POST\"><input type=\"checkbox\" name=\"staff1\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff2\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff3\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"staff4\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff5\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff6\" style = \"visibility:hidden\" checked></form>" + "</td>");
            	 } 
            	 else if(is_division_id == 1 && is_park_id == 0 && is_staff_ssn == 1){
                	 for(i=0;i<count;i++)
                	 {
                	 out.println("<td>" + r.getString(i+1) + "</td>"); 
                	            	 
                	 }
                	 out.println("<td>" + "<form action= \"DivisionServlet\" method = \"POST\"><input type=\"checkbox\" name=\"division1\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"division2\" style = \"visibility:hidden\" checked><br><input type=\"checkbox\" name=\"division3\" style = \"visibility:hidden\" checked></form>" + "</td>");                	
                	 out.println("<td>" + "<form action= \"StaffServlet\" method = \"POST\"><input type=\"checkbox\" name=\"staff1\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff2\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff3\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"staff4\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff5\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff6\" style = \"visibility:hidden\" checked></form>" + "</td>");
                	 }
            	 else if(is_division_id == 0 && is_park_id == 1 && is_staff_ssn == 1){
                	 for(i=0;i<count;i++)
                	 {
                	 out.println("<td>" + r.getString(i+1) + "</td>"); 
                	            	 
                	 }
                	 out.println("<td>" + "<form action= \"BallparkServlet\" method = \"POST\"><input type=\"checkbox\" name=\"ballpark1\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"ballpark2\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"ballpark3\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"ballpark4\" style = \"visibility:hidden\" checked><br><input type=\"checkbox\" name=\"ballpark5\" style = \"visibility:hidden\" checked></form>" + "</td>");
                	 out.println("<td>" + "<form action= \"StaffServlet\" method = \"POST\"><input type=\"checkbox\" name=\"staff1\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff2\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff3\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"staff4\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff5\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff6\" style = \"visibility:hidden\" checked></form>" + "</td>");
                	 }
            	 else if(is_division_id == 1 && is_park_id == 1 && is_staff_ssn == 0){
                	 for(i=0;i<count;i++)
                	 {
                	 out.println("<td>" + r.getString(i+1) + "</td>"); 
                	            	 
                	 }
                	 out.println("<td>" + "<form action= \"DivisionServlet\" method = \"POST\"><input type=\"checkbox\" name=\"division1\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"division2\" style = \"visibility:hidden\" checked><br><input type=\"checkbox\" name=\"division3\" style = \"visibility:hidden\" checked></form>" + "</td>");
                	 out.println("<td>" + "<form action= \"BallparkServlet\" method = \"POST\"><input type=\"checkbox\" name=\"ballpark1\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"ballpark2\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"ballpark3\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"ballpark4\" style = \"visibility:hidden\" checked><br><input type=\"checkbox\" name=\"ballpark5\" style = \"visibility:hidden\" checked></form>" + "</td>");
                	 }
            	 else if(is_division_id == 1 && is_park_id == 0 && is_staff_ssn == 0){
                	 for(i=0;i<count;i++)
                	 {
                	 out.println("<td>" + r.getString(i+1) + "</td>"); 
                	            	 
                	 }
                	 out.println("<td>" + "<form action= \"DivisionServlet\" method = \"POST\"><input type=\"checkbox\" name=\"division1\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"division2\" checked><br><input type=\"checkbox\" name=\"division3\" checked></form>" + "</td>");
                	 }
            	 else if(is_division_id == 0 && is_park_id == 1 && is_staff_ssn == 0){
                	 for(i=0;i<count;i++)
                	 {
                	 out.println("<td>" + r.getString(i+1) + "</td>"); 
                	            	 
                	 }
                	 out.println("<td>" + "<form action= \"BallparkServlet\" method = \"POST\"><input type=\"checkbox\" name=\"ballpark1\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"ballpark2\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"ballpark3\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"ballpark4\" style = \"visibility:hidden\" checked><br><input type=\"checkbox\" name=\"ballpark5\" style = \"visibility:hidden\" checked></form>" + "</td>");
                	 }
            	 else if(is_division_id == 0 && is_park_id == 0 && is_staff_ssn == 1){
                	 for(i=0;i<count;i++)
                	 {
                	 out.println("<td>" + r.getString(i+1) + "</td>"); 
                	            	 
                	 }
                	 out.println("<td>" + "<form action= \"StaffServlet\" method = \"POST\"><input type=\"checkbox\" name=\"staff1\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff2\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff3\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"staff4\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff5\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"staff6\" style = \"visibility:hidden\" checked></form>" + "</td>");
                	 }
            	 else if(is_division_id == 0 && is_park_id == 0 && is_staff_ssn == 0)
            	 {
            		 for(i=0;i<count;i++)
                	 {
                	 out.println("<td>" + r.getString(i+1) + "</td>"); 
                	 
                	 }
            	 }
            	 out.println("</tr>");
             }
             out.println( "<form action= \"TeamServlet\" method = \"POST\"><div  align=\"center\">" );
             
             
             out.println("<tr>");
             
             
             if(!checkBox1.equals(""))out.println("<td> <input type=\"checkbox\" name=\"team1\" checked> </td>");
             if(!checkBox2.equals(""))out.println("<td> <input type=\"checkbox\" name=\"team2\" checked> </td>");
             if(!checkBox3.equals(""))out.println("<td> <input type=\"checkbox\" name=\"team3\" checked> </td>");
             if(!checkBox4.equals(""))out.println("<td> <input type=\"checkbox\" name=\"team4\" checked> </td>");
             if(!checkBox5.equals(""))out.println("<td> <input type=\"checkbox\" name=\"team5\" checked> </td>");
             if(!checkBox6.equals(""))out.println("<td> <input type=\"checkbox\" name=\"team6\" checked> </td>");
             
             
             
             out.println("</tr>");
             out.println("</table>");
             out.println("<table>");
             
             out.println("<center><input type=\"submit\" value=\"Team Table\" style=\"horizontal-align:middle;\"></center>");
             
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
