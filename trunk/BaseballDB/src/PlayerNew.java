

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class PlayerNew
 */
public class PlayerNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerNew() {
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
		String userid="wki2001", password = "coms4111";
		 try {	
				OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
			    ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
			    ods.setUser(userid);
			    ods.setPassword(password);
	            Connection conn = ods.getConnection();

	             String query = new String();
	             Statement s = conn.createStatement();
	      
	             query = "SELECT TEAM_ID FROM TEAM";

	              ResultSet r = s.executeQuery(query);
	              String teamComboData = ""; 
	        		while(r.next()){
	        			System.out.println("Table Elements: "+r.getString(1)+ " ");
	        			teamComboData +=  "<option value=\"" + r.getString(1) + "\">" + r.getString(1) + "</option>";
	        		}
	        		query = "SELECT AGENT_SSN FROM AGENT";

		              r = s.executeQuery(query);
		              String agentComboData = ""; 
		        		while(r.next()){
		        			System.out.println("Table Elements: "+r.getString(1)+ " ");
		        			agentComboData +=  "<option value=\"" + r.getString(1) + "\">" + r.getString(1) + "</option>";
		        	}
	        		r.close();
	            	s.close();
	            	conn.close();
	           
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String pageText1 = "<HTML>" +
        		"<HEAD>" + 
        		"<TITLE>Create New Player</TITLE>" +
        		"<SCRIPT LANGUAGE=\"JavaScript\">" + 
        		"<!--" + 
        		"function validateForm()" + 
        		"{" + 
        		"var count=0;" +
        		"var msg=\"\"; " + 

        		    "for(i=0;i<=4;i++)" + 
        		    "{" + 
        		        "if(document.UD.elements[i].value==\"\")" + 
        		        "{" + 
        		        "count=1;" +  
        		        "msg=msg+\"\n\"+document.UD.elements[i].name;}" + 
        		        "else if((i>3) && (count==0)){return(true);}" + 
        		    "}" +  
        		    "for(i=0;i<=4;i++){" + 
        		        " if(document.UD.elements[i].value==\"\"){" + 
        		        "alert(\"PLEASE FILL IN THE FOLLOWING FIELD(S)\n \"+msg);" +
        		        "document.UD.elements[i].focus();" + 
        		        "return(false);}}  }" + 
        		"//-->" +
        		"</SCRIPT>" + 
        		"</HEAD>" + 
        		"<BODY>" + 
        		"<CENTER>" +
        		"<FONT SIZE=\"5\" COLOR=\"#006600\" FACE=\"verdana\">Create New Player</FONT>" + 
        		"</CENTER><BR><BR>" + 
        		"<FORM METHOD=POST ACTION=\"DBChangeServlet\">" + 
        		"<TABLE ALIGN=\"CENTER\">" + 
        		
    		    "<TR>" + 
    		    	"<TD>Name</TD>" +
    		    	"<TD><INPUT TYPE=\"TEXT\" NAME=\"NAME\" maxlength = \"20\"></TD>" + 
    		    "</TR>" +
    		    "<TR>" + 
		    		"<TD>Salary</TD>" + 
		    		"<TD><INPUT TYPE=\"TEXT\" NAME=\"SALARY\" maxlength = \"11\"></TD>" + 
		    	"</TR>" + 
        		"<TR>" + 
        		    "<TD>Address</TD>" +
        		    "<TD><INPUT TYPE=\"TEXT\" NAME=\"ADDRESS\" maxlength = \"50\"></TD>" + 
        		"</TR>" + 
        		"<TR>" + 
        	    "<TD>Player Position</TD>" + 
        	    "<TD>" + 
        			"<select name=\"POSITION\">" + 
        			"<option value=\"P\">P</option>" + 
        			"<option value=\"C\">C</option>" + 
        			"<option value=\"1B\" selected=\"selected\">1B</option>" + 
        			"<option value=\"2B\">2B</option>" +
        			"<option value=\"3B\">3B</option>" + 
        			"<option value=\"SS\">SS</option>" + 
        			"<option value=\"LF\">LF</option>" + 
        			"<option value=\"RF\">RF</option>" + 
        			"<option value=\"CF\">CF</option>" + 
        			"</select></TD>" + 
        		"</TR>" + 
        		    "<TR>" + 
            	    "<TD>TEAM ID</TD>" + 
            	    "<TD>" + 
            			"<select name=\"TEAM\">";
        		
        
        		String pageText2 = teamComboData +   
        			"</select></TD>"  +
        		"</TR>" +
        		"<TR>" + 
        	    "<TD>Agent ID</TD>" + 
        	    "<TD>" + 
        			"<select name=\"AGENT\">";
    		
    
    		String pageText3 = agentComboData +   
    			"</select></TD>"  +
    		"</TR>" +
        		"<TR>" + 
        	    "<TD>" + 
        	    "<input type=\"SUBMIT\" name=\"DBChange\" value=\"player create submit\" " +   
        	    "onClick=\"return validateForm()\"></TD>" + 
        	    "<TD><INPUT TYPE=\"RESET\" VALUE=\"Reset\"></TD>" + 
        	"</TR>" + 
        		"</TABLE>" + 
        		"</FORM>" + 
        		"</BODY>" + 
        		"</HTML>" 
;
    			//create page
        		out.println(pageText1 + pageText2 + pageText3);
        	
		 	}
		 	catch (Exception e) {
		 		System.out.println("The database could not be accessed.");
		 		System.out.println("More information is available as follows:");
		 		e.printStackTrace();
		 	}
	
	}
}
