

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
public class DivisionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DivisionDelete() {
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
        String choice=request.getParameter("Division");

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
          
          
            String select1 = "SELECT DISTINCT " + checkBox1 + checkBox2 + checkBox3 ;
            
            query = "DELETE FROM Division D WHERE D.DIV_ID = "+ choice;

            ResultSet r = s.executeQuery(query);
            
        	
      	   response.setContentType("text/html");
            PrintWriter out1 = response.getWriter();
            
            out1.println("<BR><BR><BR>");
            out1.println( "<form action=\"DivisionServlet\" method = \"POST\">" );
              out1.println(" <input type=\"checkbox\" name=\"division1\" style= \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"division2\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"division3\" style = \"visibility:hidden\" checked> ");
                  out1.println("<input type=\"submit\" value=\"View Updated Division Table\" checked>");
                  out1.println("</form>");
           
             r.close();
            
             s.close();
             conn.close();


    }
    catch (Exception e) {
            out.println("<center><BR>Can't Delete This Division Because of Integrity Constraint!<BR><BR>");
            out.println("<BR><BR><BR>");
            out.println( "<form action=\"DivisionServlet\" method = \"POST\">" );
              out.println(" <input type=\"checkbox\" name=\"division1\" style= \"visibility:hidden\" checked> ");
                  out.println(" <input type=\"checkbox\" name=\"division2\" style = \"visibility:hidden\" checked> ");
                  out.println(" <input type=\"checkbox\" name=\"division3\" style = \"visibility:hidden\" checked> ");
                  out.println("<input type=\"submit\" value=\"Go Back\" checked>");
                  out.println("</form></center>");
    }

	}

}
