

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
public class AgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgentServlet() {
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
        
        String checkBox1 = "A.AGENT_SSN";
        String checkBox2 = " , A.NAME";
        String checkBox3 = " , A.ADDDRESS";
        String checkBox4 = " , A.CORPORATION";
                
        try {
            OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
            ods.setUser(dbUser);
            ods.setPassword(dbPassword);

            Connection conn = ods.getConnection();
            int count = 4;  
            String query = new String();
            Statement s = conn.createStatement();
            
            if (request.getParameter("agent1") == null)
            {
            	checkBox1="";checkBox2 = "A.NAME";
            	count--;
            }
            if (request.getParameter("agent2") == null )
            {
            	checkBox2="";if(count == 3)checkBox3 = "A.ADDDRESS";
            	count--;
            }
            if (request.getParameter("agent3") == null)
            {
            	checkBox3="";if(count == 2)checkBox4 = "A.CORPORATION";
            	count--;
            }
            if (request.getParameter("agent4") == null )
            {
            	checkBox4="";
            	count--;
            }

            String select1 = "SELECT DISTINCT " + checkBox1 + checkBox2 + checkBox3 + checkBox4;
            
            query = select1 + " FROM Agent A";

            if(count >0)
            {
            
             ResultSet r = s.executeQuery(query);
             
             out.println("<center>");
             out.println("<table border = \"2\">");
             out.println("<caption align=\"center\"><H1>Agents</H1></caption>");
             out.println("<tr>");
             if(!checkBox1.equals(""))out.println("<td>" + "<b>Agent S.S. No.</b>"  + "</td>");
             if(!checkBox2.equals(""))out.println("<td>" + "<b>Name</b>"  + "</td>");
             if(!checkBox3.equals(""))out.println("<td>" + "<b>Address</b>"  + "</td>");
             if(!checkBox4.equals(""))out.println("<td>" + "<b>Corporation</b>"  + "</td>");
             
             out.println("</tr>");
             
             int i=0;
             while(r.next()){
            	 out.println("<tr>");
            	 for(i=0;i<count;i++)
            	 {
            	 out.println("<td>" + r.getString(i+1) + "</td>"); 
            	            	 
            	 }
            	             	 
            	 out.println("</tr>");
             }
             out.println( "<form action= \"AgentServlet\" method = \"POST\"><div  align=\"center\">" );
             
             
             out.println("<tr>");
             
             
             if(!checkBox1.equals(""))out.println("<td> <input type=\"checkbox\" name=\"agent1\" checked> </td>");
             if(!checkBox2.equals(""))out.println("<td> <input type=\"checkbox\" name=\"agent2\" checked> </td>");
             if(!checkBox3.equals(""))out.println("<td> <input type=\"checkbox\" name=\"agent3\" checked> </td>");
             if(!checkBox4.equals(""))out.println("<td> <input type=\"checkbox\" name=\"agent4\" checked> </td>");             
             
             
             out.println("</tr>");
             out.println("</table>");
             out.println("<table>");
             
             out.println("<center><input type=\"submit\" value=\"Update View\" style=\"horizontal-align:middle;\"></center>");
             
             out.println("</div></form>");
             out.println("</table>");
             out.println("</center>"); 
             out.println("<br>");
             out.println("<br>");
             out.println("<form action=\"DBChangeServlet\" method=\"POST\">" +
            		 	"<FONT SIZE=\"3\" COLOR=\"#006600\" FACE=\"verdana\">Actions</FONT>" + 
            		 	"<br>" +
            		 	"<input type=submit name=\"DBChange\" value=\"agent update\">" + 
             			"<input type=submit name=\"DBChange\" value=\"agent create\">" + 
             			"<input type=submit name=\"DBChange\" value=\"agent delete\">" + 
             			"</form>");
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
    		out.close();
	}

}
