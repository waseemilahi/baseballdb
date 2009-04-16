

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
public class RadioChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RadioChoiceServlet() {
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
        String choice=request.getParameter("Table");

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

           if(choice.equals("Player")){
        	   
        	   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/PlayerServlet" );
        	   dispatcher.forward( request, response );

           }
           else if(choice.equals("Agent")){
        	   
        	   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/AgentServlet" );
        	   dispatcher.forward( request, response );

           }
           else if(choice.equals("Owner")){
        	   
        	   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/OwnerServlet" );
        	   dispatcher.forward( request, response );

           }
           else if(choice.equals("Staff")){
        	   
        	   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/StaffServlet" );
        	   dispatcher.forward( request, response );

           }
           else if(choice.equals("Team")){
        	   
        	   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/TeamServlet" );
        	   dispatcher.forward( request, response );

           }
           else if(choice.equals("Ballpark")){
        	   
        	   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/BallparkServlet" );
        	   dispatcher.forward( request, response );

           }
           else if(choice.equals("Division")){
        	   
        	   RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/DivisionServlet" );
        	   dispatcher.forward( request, response );

           }
             
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
