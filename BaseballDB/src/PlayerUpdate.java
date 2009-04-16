

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigInteger;

import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.*;

/**
 * Servlet implementation class BaseballServlet
 */
public class PlayerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerUpdate() {
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
        String checkBox7 = "";
     
       
      
                
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
            ods.setUser(dbUser);
            ods.setPassword(dbPassword);

            Connection conn = ods.getConnection();
             
            String query = new String();
            Statement s = conn.createStatement();
            
            if(request.getParameter("NAME").length()!=0)checkBox2= "NAME = '" + request.getParameter("NAME")+"'";
            if(request.getParameter("SALARY").length()!=0)checkBox3= " SALARY = '" + request.getParameter("SALARY")+"'";
            if(request.getParameter("ADDRESS").length()!=0)checkBox4= " ADDRESS = '" + request.getParameter("ADDRESS")+"'";
            if(request.getParameter("POSITION").length()!=0)checkBox5= " POSITION = '" + request.getParameter("POSITION")+"'";
            if(request.getParameter("TEAM").length()!=0)checkBox6= " TEAM_ID = '" + request.getParameter("TEAM")+"'";
            if(request.getParameter("AGENT").length()!=0)checkBox7= " AGENT_ID = '" + request.getParameter("AGENT")+"'";
            
          
          if((checkBox2.length()!=0) && (checkBox3.length()!=0))checkBox3 = "," + checkBox3;
          if((checkBox2.length()!=0) && (checkBox4.length()!=0) || (checkBox3.length()!=0) && (checkBox4.length()!=0))checkBox4 = "," + checkBox4;
          if((checkBox2.length()!=0) && (checkBox5.length()!=0) || (checkBox3.length()!=0) && (checkBox5.length()!=0) || (checkBox4.length()!=0) && (checkBox5.length()!=0))checkBox5 = "," + checkBox5;
          if((checkBox2.length()!=0) && (checkBox6.length()!=0) || (checkBox3.length()!=0) && (checkBox6.length()!=0) || (checkBox4.length()!=0) && (checkBox6.length()!=0) || (checkBox5.length()!=0) && (checkBox6.length()!=0))checkBox6 = "," + checkBox6;
          
          if(checkBox2.length()!=0 || checkBox3.length()!=0 || checkBox4.length()!=0 || checkBox5.length()!=0 || checkBox6.length()!=0)checkBox7 = ","+checkBox7;
        	
          out1.println("<BR><BR>");            
            query = "UPDATE PLAYER  SET " + checkBox2 + checkBox3 + checkBox4 + checkBox5+ checkBox6 + checkBox7 +  " WHERE PLAYER_SSN = '"+ request.getParameter("PLAYER")+"'"  ;
  
            if((request.getParameter("SALARY").length()==0) || intSalaryCheck(request.getParameter("SALARY"), response, "player", 0, new BigInteger("99999999")))
            {
            ResultSet r = s.executeQuery(query);
            
            out1.println("<BR><BR><BR>");
            out1.println( "<form action=\"PlayerServlet\" method = \"POST\">" );
              out1.println(" <input type=\"checkbox\" name=\"player1\" style= \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"player2\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"player3\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"player4\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"player5\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"player6\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"player7\" style = \"visibility:hidden\" checked> ");
                  out1.println("<input type=\"submit\" value=\"View Updated Player Table\" checked>");
                  out1.println("</form>");
           
           
             r.close();
        }
             s.close();
             conn.close();
         


    }
    catch (Exception e) {
            out1.println("The database could not be accessed.<br>");
            out1.println(e.getMessage());
            
    }

	}
	public boolean intSalaryCheck(String salary, HttpServletResponse response, String table, int lowVal, BigInteger highVal) throws IOException{
		BigInteger tmpSalary;
    	try{
    	tmpSalary = new BigInteger(salary);
    	if((1 == tmpSalary.compareTo(highVal)) || (-1 == tmpSalary.compareTo(new BigInteger(Integer.toString(lowVal)))))
    	{
    		errorprint("<BR>ENTER A VALID Salary - Salary must be between: 0 & 99999999<BR>",table,response);
    	}
    	else return true;
    		
    	}
    	catch(NumberFormatException n)
    	{
    		errorprint("<BR>ENTER A VALID Salary - Salary must be a number between: 0 & 99999999<BR>",table,response);
    	}
    	return false;
    }
	
	public void errorprint(String message,String tableType,HttpServletResponse response )throws IOException {

		response.setContentType("text/html");
		PrintWriter out1 = response.getWriter();
		out1.println(message);
		
		out1.println("<form action=\"DBChangeServlet\" name=\"DBDirector\" method=\"POST\">" +
		"<input type=submit name=\"DBDirector\" value=\""+ tableType + " update\">" +
		"<input type=submit name=\"DBDirector\" value=\""+ tableType + " create\">" +
		"</FONT></form>");
		}

}
