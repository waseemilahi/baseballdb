

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
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerServlet() {
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
        
        String checkBox1 = "P.PLAYER_SSN";
        String checkBox2 = " , P.POSITION";
        String checkBox3 = " , P.ADDRESS";
        String checkBox4 = " , P.NAME";
        String checkBox5 = " , P.SALARY";
        String checkBox6 = " , P.AGENT_ID";
        String checkBox7 = " , P.TEAM_ID";
  
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
            ods.setUser(dbUser);
            ods.setPassword(dbPassword);

            Connection conn = ods.getConnection();
            
            int count = 7;  
            
            String query = new String();
            Statement s = conn.createStatement();
            
            if (request.getParameter("player1") == null)
            {
            	checkBox1="";checkBox2 = "P.POSITION";
            	count--;
            }
            if (request.getParameter("player2") == null )
            {
            	checkBox2="";if(count == 6)checkBox3 = "P.ADDRESS";
            	count--;
            }
            if (request.getParameter("player3") == null)
            {
            	checkBox3="";if(count == 5)checkBox4 = "P.NAME";
            	count--;
            }
            if (request.getParameter("player4") == null )
            {
            	checkBox4="";if(count == 4)checkBox5 = "P.SALARY";
            	count--;
            }
            if (request.getParameter("player5") == null)
            {
            	checkBox5="";if(count == 3)checkBox6 = "P.AGENT_ID";
            	count--;
            }
            if (request.getParameter("player6") == null )
            {
            	checkBox6="";if(count == 2)checkBox7 = "P.TEAM_ID";
            	count--;
            }
            if (request.getParameter("player7") == null )
            {
            	checkBox7="";
            	count--;
            }

            String select1 = "SELECT DISTINCT " + checkBox1 + checkBox2 + checkBox3 + checkBox4 + checkBox5 + checkBox6 + checkBox7;
            
            query = select1 + " FROM Player P";
            
            if(count >0)
            {
            
             ResultSet r = s.executeQuery(query);
             
             out.println("<center>");
             out.println("<table border = \"2\">");
             out.println("<caption align=\"center\"><H1>Players</H1></caption>");
             out.println("<tr>");
             if(!checkBox1.equals(""))out.println("<td>" + "<b>Player S.S. No.</b>"  + "</td>");
             if(!checkBox2.equals(""))out.println("<td>" + "<b>Position</b>"  + "</td>");
             if(!checkBox3.equals(""))out.println("<td>" + "<b>Address</b>"  + "</td>");
             if(!checkBox4.equals(""))out.println("<td>" + "<b>Name</b>"  + "</td>");
             if(!checkBox5.equals(""))out.println("<td>" + "<b>Salary</b>"  + "</td>");
             if(!checkBox6.equals(""))out.println("<td>" + "<b>Agent ID</b>"  + "</td>");
             if(!checkBox7.equals(""))out.println("<td>" + "<b>Team ID</b>"  + "</td>");
             out.println("</tr>");
             int is_agent_id = 0; 
             int is_team_id = 0;
             if(!checkBox6.equals("")){count--;is_agent_id++;}
             if(!checkBox7.equals("")){count--;is_team_id++;}
             int i=0;
             while(r.next()){
            	 out.println("<tr>");
            	 if(is_agent_id == 1 && is_team_id == 1){
            	 for(i=0;i<count;i++)
            	 {
            	 out.println("<td>" + r.getString(i+1) + "</td>"); 
            	            	 
            	 }
            	 out.println("<td>" + "<form action= \"AgentServlet\" method = \"POST\"><input type=\"checkbox\" name=\"agent1\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"agent2\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"agent3\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"agent4\" style = \"visibility:hidden\" checked></form>" + "</td>");
            	 out.println("<td>" + "<form action= \"TeamServlet\" method = \"POST\"><input type=\"checkbox\" name=\"team1\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"team2\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"team3\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"team4\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"team5\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"team6\" style = \"visibility:hidden\" checked></form>" + "</td>");
            	 }
            	 else if(is_agent_id == 1 && is_team_id == 0){
                	 for(i=0;i<count;i++)
                	 {
                	 out.println("<td>" + r.getString(i+1) + "</td>"); 
                	            	 
                	 }
                	 out.println("<td>" + "<form action= \"AgentServlet\" method = \"POST\"><input type=\"checkbox\" name=\"agent1\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"agent2\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"agent3\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"agent4\" style = \"visibility:hidden\" checked></form>" + "</td>");
                	 
                 }
            	 else if(is_agent_id == 0 && is_team_id == 1){
                	 for(i=0;i<count;i++)
                	 {
                	 out.println("<td>" + r.getString(i+1) + "</td>"); 
                	            	 
                	 }
                	 out.println("<td>" + "<form action= \"TeamServlet\" method = \"POST\"><input type=\"checkbox\" name=\"team1\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"team2\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"team3\" style = \"visibility:hidden\" checked><input type = \"submit\" value = \""+r.getString(count+1)+ "\"><input type=\"checkbox\" name=\"team4\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"team5\" style = \"visibility:hidden\" checked><input type=\"checkbox\" name=\"team6\" style = \"visibility:hidden\" checked></form>" + "</td>");
                	 
                	 }
            	 else if(is_agent_id == 0 && is_team_id == 0)
            	 {
            		 for(i=0;i<count;i++)
                	 {
                	 out.println("<td>" + r.getString(i+1) + "</td>"); 
                	 
                	 }
            	 }
            	 out.println("</tr>");
             }
             out.println( "<form action= \"PlayerServlet\" method = \"POST\"><div  align=\"center\">" );
             
             
             out.println("<tr>");
             
             
             if(!checkBox1.equals(""))out.println("<td> <input type=\"checkbox\" name=\"player1\" checked> </td>");
             if(!checkBox2.equals(""))out.println("<td> <input type=\"checkbox\" name=\"player2\" checked> </td>");
             if(!checkBox3.equals(""))out.println("<td> <input type=\"checkbox\" name=\"player3\" checked> </td>");
             if(!checkBox4.equals(""))out.println("<td> <input type=\"checkbox\" name=\"player4\" checked> </td>");
             if(!checkBox5.equals(""))out.println("<td> <input type=\"checkbox\" name=\"player5\" checked> </td>");
             if(!checkBox6.equals(""))out.println("<td> <input type=\"checkbox\" name=\"player6\" checked> </td>");
             if(!checkBox7.equals(""))out.println("<td> <input type=\"checkbox\" name=\"player7\" checked> </td>");
             
             
             
             out.println("</tr>");
             out.println("</table>");
             out.println("<table>");
             
             out.println("<center><input type=\"submit\" value=\"Player Table\" style=\"horizontal-align:middle;\"></center>");
             
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
