

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
public class StaffUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffUpdate() {
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
     
       
      
                
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
            ods.setUser(dbUser);
            ods.setPassword(dbPassword);

            Connection conn = ods.getConnection();
             
            String query = new String();
            Statement s = conn.createStatement();
            
            if(request.getParameter("NAME").length()!=0)checkBox2= "NAME = '" + request.getParameter("NAME")+"'";
            if(request.getParameter("TITLE").length()!=0)checkBox3= " TITLE = '" + request.getParameter("TITLE")+"'";
            if(request.getParameter("SALARY").length()!=0)checkBox4= " SALARY = '" + request.getParameter("SALARY")+"'";
            if(request.getParameter("ADDRESS").length()!=0)checkBox5= " ADDRESS = '" + request.getParameter("ADDRESS")+"'";
            if(request.getParameter("PARK").length()!=0)checkBox6= " PARK_ID = '" + request.getParameter("PARK")+"'";
            
          
          if((checkBox2.length()!=0) && (checkBox3.length()!=0))checkBox3 = "," + checkBox3;
          if((checkBox2.length()!=0) && (checkBox4.length()!=0) || (checkBox3.length()!=0) && (checkBox4.length()!=0))checkBox4 = "," + checkBox4;
          if((checkBox2.length()!=0) && (checkBox5.length()!=0) || (checkBox3.length()!=0) && (checkBox5.length()!=0) || (checkBox4.length()!=0) && (checkBox5.length()!=0))checkBox5 = "," + checkBox5;
          
          if(checkBox2.length()!=0 || checkBox3.length()!=0 || checkBox4.length()!=0 || checkBox5.length()!=0)checkBox6 = ","+checkBox6;
        	
          out1.println("<BR><BR>");            
            query = "UPDATE STAFF  SET " + checkBox2 + checkBox3 + checkBox4 + checkBox5+ checkBox6 +  " WHERE STAFF_SSN = '"+ request.getParameter("STAFF")+"'"  ;
  
            
            ResultSet r = s.executeQuery(query);
            
            out1.println("<BR><BR><BR>");
            out1.println( "<form action=\"StaffServlet\" method = \"POST\">" );
              out1.println(" <input type=\"checkbox\" name=\"staff1\" style= \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"staff2\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"staff3\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"staff4\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"staff5\" style = \"visibility:hidden\" checked> ");
                  out1.println(" <input type=\"checkbox\" name=\"staff6\" style = \"visibility:hidden\" checked> ");
                  out1.println("<input type=\"submit\" value=\"View Updated Staff Table\" checked>");
                  out1.println("</form>");
           
             r.close();
            
             s.close();
             conn.close();
         


    }
    catch (Exception e) {
            out1.println("The database could not be accessed.<br>");
            out1.println(e.getMessage());
            
    }

	}

}
