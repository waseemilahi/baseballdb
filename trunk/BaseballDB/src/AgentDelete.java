

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
public class AgentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgentDelete() {
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
        String choice=request.getParameter("Agent");

        String dbUser = "wki2001"; // enter your username here
        String dbPassword = "coms4111"; // enter your password here
       
      
                
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
            ods.setUser(dbUser);
            ods.setPassword(dbPassword);

            Connection conn = ods.getConnection();
            int count = 3;  
            String query = new String();
            Statement s = conn.createStatement();
          
          
            
            query = "DELETE FROM AGENT A WHERE A.AGENT_SSN = '"+ choice + "'";

            ResultSet r = s.executeQuery(query);
            
        	
      	   
            out1.println("<BR><BR><BR>");
            out1.println( "<form action=\"AgentServlet\" method = \"POST\">" );
              out1.println(" <input type=\"checkbox\" name=\"agent1\" style= \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"agent2\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"agent3\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"agent4\" style = \"visibility:hidden\" checked> ");
                  out1.println("<input type=\"submit\" value=\"View Updated Agent Table\" checked>");
                  out1.println("</form>");
           
             r.close();
            
             s.close();
             conn.close();


    }
    catch (Exception e) {
    	out1.println("<center><BR>Can't Delete This Agent Because of Integrity Constraint!<BR><BR>");
    	out1.println("<BR><BR><BR>");
        out1.println( "<form action=\"AgentServlet\" method = \"POST\">" );
          out1.println(" <input type=\"checkbox\" name=\"agent1\" style= \"visibility:hidden\" checked> ");
              out1.println(" <input type=\"checkbox\" name=\"agent2\" style = \"visibility:hidden\" checked> ");
              out1.println(" <input type=\"checkbox\" name=\"agent3\" style = \"visibility:hidden\" checked> ");
              out1.println(" <input type=\"checkbox\" name=\"agent4\" style = \"visibility:hidden\" checked> ");
              out1.println("<input type=\"submit\" value=\"Go Back\" checked>");
              out1.println("</form></center>");
            
    }

	}

}
