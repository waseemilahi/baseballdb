

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
 * Servlet implementation class DivisionNew
 */
public class BallparkPartialUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BallparkPartialUpdate() {
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
	      
	             query = "SELECT PARK_ID FROM BALLPARK";

	              ResultSet r = s.executeQuery(query);
	              String teamComboData = ""; 
	        		while(r.next()){
	        			System.out.println("Table Elements: "+r.getString(1)+ " ");
	        			teamComboData +=  "<option value=\"" + r.getString(1) + "\">" + r.getString(1) + "</option>";
	        		}
	        		r.close();
	            	s.close();
	            	conn.close();
	           
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String pageText1 = "<HTML>" +
        		"<HEAD>" + 
        		"<TITLE>Update PARKS</TITLE>" +
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
        		"<FONT SIZE=\"5\" COLOR=\"#006600\" FACE=\"verdana\">Update a Ballpark</FONT>" + 
        		"</CENTER><BR><BR>" + 
        		"<FORM METHOD=POST ACTION=\"DBChangeServlet\">" + 
        		"<TABLE ALIGN=\"CENTER\">" + 
        		 
        		"<TR>"+
        	    "<TD>Capacity</TD>"+
        	    "<TD><INPUT TYPE=\"TEXT\" NAME=\"CAPACITY\" maxlength=\"5\" ></TD>"+
        	"</TR>" +
        	"<TR><TD>Name</TD><TD><INPUT TYPE=\"TEXT\" NAME=\"NAME\"maxlength=\"20\"></TD></TR>"+
        	"<TR><TD>Year Built</TD><TD><INPUT TYPE=\"TEXT\" NAME=\"Year Built\" maxlength=\"4\"></TD></TR>"+
        	"<TR><TD>Type</TD> <TD>" +
        			"<select name=\"TYPE\">        			<option value=\"Grass\">Grass</option>" +
        			"<option value=\"AstroTurf\">AstroTurf</option>"+
        			"<option value=\"FieldTurf\" selected=\"selected\">FieldTurf</option>"+
        			"<option value=\"NexTurf\">NexTurf</option>"+
        			"</select></TD>    	</TR>" +
        			
            	    "<TD>Park ID</TD>" + 
            	    "<TD>" + 
            			"<select name=\"BallPark\">";
        		
        
        		String pageText2 = teamComboData +   
        			"</select></TD>"  +
        		"</TR>" +
        		"<TR>" + 
        	    "<TD>" + 
        	    "<input type=\"SUBMIT\" name=\"DBChange\" value=\"ballpark update submit\" " +   
        	    "onClick=\"return validateForm()\"></TD>" + 
        	    "<TD><INPUT TYPE=\"RESET\" VALUE=\"Reset\"></TD>" + 
        	"</TR>" + 
        		"</TABLE>" + 
        		"</FORM>" + 
        		"</BODY>" + 
        		"</HTML>" 
;
        		out.println(pageText1 + pageText2);
        	
		 	}
		 	catch (Exception e) {
		 		System.out.println("The database could not be accessed.");
		 		System.out.println("More information is available as follows:");
		 		e.printStackTrace();
		 	}
	
	}
	

}
