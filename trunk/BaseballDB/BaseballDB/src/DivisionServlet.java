

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
        
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
            ods.setUser(dbUser);
            ods.setPassword(dbPassword);

            Connection conn = ods.getConnection();

            String query = new String();
            Statement s = conn.createStatement();

            query = "SELECT * FROM Division";

             ResultSet r = s.executeQuery(query);
             
             
             out.println("<table border = \"2\">");
             out.println("<caption align=\"center\"><H1>Divisions</H1></caption>");
             out.println("<tr>");
             out.println("<td>" + "<b>Division ID</b>"  + "</td>");
             out.println("<td>" + "<b>League</b>"  + "</td>");
             out.println("<td>" + "<b>Location</b>"  + "</td>");
             
             out.println("</tr>");
             
             
             while(r.next()){
            	 out.println("<tr>");
            	 out.println("<td>" + r.getString(1) + "</td>"); 
            	 out.println("<td>" + r.getString(2) + "</td>");
            	 out.println("<td>" + r.getString(3) + "</td>");
            	 
            	 out.println("</tr>");
             }
             
             out.println("</table>"); 
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
