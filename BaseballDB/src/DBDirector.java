

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class DBChangeServlet
 */
public class DBDirector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBDirector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        if(request.getParameter("DBDirector").equals("Update Staff View")){
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/StaffServlet" );
     	   	dispatcher.forward( request, response );
        }
        if(request.getParameter("DBDirector").equals("staff update")){
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/DBChangeServlet");
     	   	dispatcher.forward( request, response );
        }
        if(request.getParameter("DBDirector").equals("staff create")){
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/DBChangeServlet" );
     	   	dispatcher.forward( request, response );
        }
        if(request.getParameter("DBDirector").equals("staff delete")){
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/DBChangeServlet" );
     	   	dispatcher.forward( request, response );
        }
        if(request.getParameter("DBDirector").substring(0,1).equals("P")){
        	RequestDispatcher dispatcher=request.getRequestDispatcher( "/ParkIDServlet" );
     	   	dispatcher.forward( request, response );
        	
        }
        else if(request.getParameter("DBDirector").equals("Update Team View")){
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/TeamServlet" );
     	   	dispatcher.forward( request, response );
        }
        if(request.getParameter("DBDirector").equals("team update")){
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/DBChangeServlet");
     	   	dispatcher.forward( request, response );
        }
        if(request.getParameter("DBDirector").equals("team create")){
        	
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/DBChangeServlet" );
     	   	dispatcher.forward( request, response );
        }
        if(request.getParameter("DBDirector").equals("team delete")){
        	
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/DBChangeServlet" );
     	    dispatcher.forward( request, response );
        }
        if(request.getParameter("DBDirector").substring(0,1).equals("S")){
        	RequestDispatcher dispatcher=request.getRequestDispatcher( "/StaffIDServlet" );
     	   	dispatcher.forward( request, response );
        	
        }
        else if(request.getParameter("DBDirector").substring(0,1).equals("D")){
        	RequestDispatcher dispatcher=request.getRequestDispatcher( "/DivisionIDServlet" );
     	   	dispatcher.forward( request, response );
        	
        }
        else if(request.getParameter("DBDirector").substring(0,1).equals("T")){
        	RequestDispatcher dispatcher=request.getRequestDispatcher( "/TeamIDServlet" );
     	   	dispatcher.forward( request, response );
        	
        }
        else if(request.getParameter("DBDirector").substring(0,1).equals("A")){
        	RequestDispatcher dispatcher=request.getRequestDispatcher( "/AgentIDServlet" );
     	   	dispatcher.forward( request, response );
        	
        }
        else if(request.getParameter("DBDirector").equals("Update Owner View")){
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/OwnerServlet" );
     	   	dispatcher.forward( request, response );
        }
        if(request.getParameter("DBDirector").equals("owner update")){
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/DBChangeServlet");
     	   	dispatcher.forward( request, response );
        }
        if(request.getParameter("DBDirector").equals("owner create")){
        	
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/DBChangeServlet" );
     	   	dispatcher.forward( request, response );
        }
        if(request.getParameter("DBDirector").equals("owner delete")){
        	
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/DBChangeServlet" );
     	    dispatcher.forward( request, response );
        }
        else if(request.getParameter("DBDirector").equals("Update Player View")){
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/PlayerServlet" );
     	   	dispatcher.forward( request, response );
        }
        if(request.getParameter("DBDirector").equals("player update")){
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/DBChangeServlet");
     	   	dispatcher.forward( request, response );
        }
        if(request.getParameter("DBDirector").equals("player create")){
        	
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/DBChangeServlet" );
     	   	dispatcher.forward( request, response );
        }
        if(request.getParameter("DBDirector").equals("player delete")){
        	
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/DBChangeServlet" );
     	    dispatcher.forward( request, response );
        }
        
	}
	
}
