

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
public class DBChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBChangeServlet() {
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
		String formReq = request.getParameter("DBChange");
        //Print out the appropriate form
        if(formReq.equals("agent create")){
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/AgentNew.jsp" );
     	   	dispatcher.forward( request, response );
        }//submission of create tuple-Agent
        else if(formReq.equals("agent create submit")){
        	String[] args = new String[3];
        	//Name
        	args[0] = request.getParameter("FIRST NAME") + " " + request.getParameter("LAST NAME");
        	//Address
        	args[1] = request.getParameter("ADDRESS");
        	//Corporation
        	args[2] = request.getParameter("CORPORATION");
        	createNewTuple("AGENT",args, response);
        }
        else if(formReq.equals("agent update")){
        	
        }else if(formReq.equals("agent delete")){
        	
        }
        else if(formReq.equals("ballpark create")){
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/BallparkNew.jsp" );
     	   	dispatcher.forward( request, response );
        }//submission of create tuple-Agent
        else if(formReq.equals("ballpark create submit")){
        	String[] args = new String[4];
        	args[0] = request.getParameter("CAPACITY");
        	args[1] = request.getParameter("NAME");
        	args[2] = request.getParameter("YEARBUILT");
        	args[3] = request.getParameter("TYPE");
        	/*
        	int tmpyear;
        	try{
        	tmpyear = Integer.parseInt(args[2]);
        	if(tmpyear<1000)
        	{
        		errorprint("<BR> Invalid Entry for Year Built Field! TRY AGAIN.<BR>","ballpark",response);
        	}
        	else createNewTuple("BALLPARK",args,response);
        	}
        	catch(NumberFormatException n)
        	{
        		errorprint("<BR>ENTER A FOUR DIGIT NUMBER FOR THE YEAR BUILT FIELD.<BR>","ballpark",response);
        	}
        	*/
        	if(verifyErrors("ballpark",args,response)){
        		createNewTuple("BALLPARK",args,response);
        	}
        }
        else if(formReq.equals("ballpark update")){
        	
        }else if(formReq.equals("ballpark delete")){
        	
        }
        else if(formReq.equals("division create")){
     	   	RequestDispatcher dispatcher=request.getRequestDispatcher( "/DivisionNew.jsp" );
     	   	dispatcher.forward( request, response );
        }//submission of create tuple-Agent
        else if(formReq.equals("division create submit")){
        	String[] args = new String[2];
        	args[0] = request.getParameter("LEAGUE");
        	args[1] = request.getParameter("LOCATION");
        	//createNewTuple("DIVISION",args, response);
        	if(verifyErrors("division",args,response)){
        		createNewTuple("DIVISION",args,response);
        	}
        }
        else if(formReq.equals("division update")){
        	
        }else if(formReq.equals("division delete")){
        	
        }
        else if(formReq.equals("owner create")){
     	   	RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/OwnerNew" );
     	   	dispatcher.forward( request, response );
        }//submission of create tuple-Agent
        else if(formReq.equals("owner create submit")){
        	String[] args = new String[3];
           	//Name
        	args[0] = request.getParameter("FIRST NAME") + " " + request.getParameter("LAST NAME");
        	//Address
        	args[1] = request.getParameter("WORTH");
        	//Corporation
        	args[2] = request.getParameter("TEAM");
        	//createNewTuple("OWNER",args, response);
        	if(verifyErrors("owner",args,response)){
        		createNewTuple("OWNER",args,response);
        	}
        }
        else if(formReq.equals("owner update")){
        	
        }else if(formReq.equals("owner delete")){
        	
        }
        else if(formReq.equals("staff create")){
     	   	RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/StaffNew" );
     	   	dispatcher.forward( request, response );
        }//submission of create tuple-Agent
        else if(formReq.equals("staff create submit")){
        	String[] args = new String[5];
        	args[0] = request.getParameter("FIRST NAME") + " " + request.getParameter("LAST NAME");
        	args[1] = request.getParameter("TITLE");
        	args[2] = request.getParameter("SALARY");
        	args[3] = request.getParameter("ADDRESS");
        	args[4] = request.getParameter("PARK");
        	//createNewTuple("STAFF",args, response);
        	if(verifyErrors("staff",args,response)){
        		createNewTuple("STAFF",args,response);
        	}
        }
        else if(formReq.equals("staff update")){
        	
        }else if(formReq.equals("staff delete")){
        	
        }   else if(formReq.equals("team create")){
     	   	RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/TeamNew" );
     	   	dispatcher.forward( request, response );
        }//submission of create tuple-Agent
        else if(formReq.equals("team create submit")){
        	String[] args = new String[5];
        	args[0] = request.getParameter("NAME");
        	args[1] = request.getParameter("STATE");
        	args[2] = request.getParameter("DIVISION");
        	args[3] = request.getParameter("PARK");
        	args[4] = request.getParameter("STAFF");
        	//createNewTuple("TEAM",args, response);
        	if(verifyErrors("team",args,response)){
        		createNewTuple("TEAM",args,response);
        	}
        }
        else if(formReq.equals("team update")){
        	
        }else if(formReq.equals("team delete")){
        	
        }   else if(formReq.equals("player create")){
     	   	RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/PlayerNew" );
     	   	dispatcher.forward( request, response );
        }//submission of create tuple-Agent
        else if(formReq.equals("player create submit")){
        	String[] args = new String[6];
        	args[0] = request.getParameter("POSITION");
        	args[1] = request.getParameter("ADDRESS");
        	args[2] = request.getParameter("FIRST NAME") + " " + request.getParameter("LAST NAME");
        	args[3] = request.getParameter("SALARY");
        	args[4] = request.getParameter("AGENT");
        	args[5] = request.getParameter("TEAM");
        	//createNewTuple("PLAYER",args, response);
        	if(verifyErrors("player",args,response)){
        		createNewTuple("PLAYER",args,response);
        	}
        }
        else if(formReq.equals("player update")){
        	
        }else if(formReq.equals("player delete")){
        	
        }
	}
	public boolean verifyErrors(String table, String[] args, HttpServletResponse response) throws IOException{
		boolean verified = false;
		if(table.equals("ballpark")){
			verified = intYearCheck(response, table, args, args[2]);
		}else if(table.equals("agent")){
			verified = true; // No checks needed
		}else if(table.equals("division")){
			verified = true; // No checks needed
		}else if(table.equals("owner")){
			verified = intSalaryCheck(args[1], response, table, args, 0, new BigInteger("50000000000"));
		}else if(table.equals("player")){
			verified = intSalaryCheck(args[3], response, table, args, 0, new BigInteger("100000000"));
		}else if(table.equals("staff")){
			verified = intSalaryCheck(args[2], response, table, args, 0, new BigInteger("100000000"));
		}
		return verified;
	}
	public boolean intYearCheck(HttpServletResponse response, String table, String[] args, String year) throws IOException{
		int tmpyear;
    	try{
    	tmpyear = Integer.parseInt(year);
    	if(tmpyear<1000)
    	{
    		errorprint("<BR> Invalid Entry for Year Built Field! TRY AGAIN.<BR>",table,response);
    	}
    	else return true;
    	}
    	catch(NumberFormatException n)
    	{
    		errorprint("<BR>ENTER A FOUR DIGIT NUMBER FOR THE YEAR BUILT FIELD.<BR>",table,response);
    	}
    	return false;
	}
	public boolean intSalaryCheck(String salary, HttpServletResponse response, String table, String[] args, int lowVal, BigInteger highVal) throws IOException{
		BigInteger tmpSalary;
    	try{
    	tmpSalary = new BigInteger(salary);
    	if((1 == tmpSalary.compareTo(highVal)) || (-1 == tmpSalary.compareTo(new BigInteger(Integer.toString(lowVal)))))
    	{
    		errorprint("<BR>ENTER A VALID WORTH - Worth must be between: " + lowVal + " & " + highVal + "<BR>",table,response);
    	}
    	else{
    		System.out.println("Salary Comparison: " + (tmpSalary.compareTo(highVal)) + "   &&&   " + (tmpSalary.compareTo(new BigInteger(Integer.toString(lowVal)))));
    		return true;
    		}
    	}
    	catch(NumberFormatException n)
    	{
    		errorprint("<BR>ENTER A VALID WORTH - Worth must be between: " + lowVal + " & " + highVal + "<BR>",table,response);
    	}
    	return false;
    }
	public void createNewTuple(String table, String[] args, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		String userid="wki2001", password = "coms4111";
		int primaryKey = 0;
		 try {	
				OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
			    ods.setURL("jdbc:oracle:thin:@//w4111b.cs.columbia.edu:1521/ADB");
			    ods.setUser(userid);
			    ods.setPassword(password);
	            Connection conn = ods.getConnection();

	             String query = new String();
	             Statement s = conn.createStatement();
	             //Generate unique SSN
	             if(table.equals("AGENT")){
	             query = "SELECT AGENT_SSN FROM AGENT";
	             }
	             else if(table.equals("BALLPARK")){
		             query = "SELECT PARK_ID FROM BALLPARK";
		             }
	             else if(table.equals("DIVISION")){
		             query = "SELECT DIV_ID FROM DIVISION";
		             }
	             else if(table.equals("OWNER")){
		             query = "SELECT OWNER_SSN FROM OWNER";
		             }
	             else if(table.equals("STAFF")){
		             query = "SELECT STAFF_SSN FROM STAFF";
		             }
	             else if(table.equals("TEAM")){
		             query = "SELECT TEAM_ID FROM TEAM";
		             }
	             else if(table.equals("PLAYER")){
		             query = "SELECT PLAYER_SSN FROM PLAYER";
		             }
	             ResultSet r = s.executeQuery(query);
	             LinkedList<Integer> ssnCollection = new LinkedList<Integer>(); 
	             while(r.next()){
	            	 String stKey = r.getString(1);
	            	 System.out.println("Table Elements: "+stKey+" ");
	            	 if(table.equals("AGENT") || table.equals("OWNER") || table.equals("STAFF")
	            			 || table.equals("PLAYER")){//do this for any with -'s in it 
	            		stKey = intFormatSSN(stKey);
		             }
	            	 ssnCollection.add(Integer.parseInt(stKey));
		          }
		          
	             primaryKey = ssnCollection.getFirst() + 1;
	             while(ssnCollection.contains(primaryKey)){
	            	 primaryKey += 1 ;
	            	 
	             }
	             if(table.equals("AGENT") || table.equals("OWNER") || table.equals("STAFF")
	            		 || table.equals("PLAYER")){//do this for any with -'s in it 
	            	 query = "INSERT INTO  \"" + table + "\" VALUES (" + "'" + stringFormatSSN(Integer.toString(primaryKey)) + "'" ; 
						for(int i = 0; i < args.length; i++){
							query = query + "," + "'" + args[i] + "'";
						}
						query += ")";
		             }else{
		            	 	query = "INSERT INTO  \"" + table + "\" VALUES (" + "'" + Integer.toString(primaryKey) + "'" ; 
	             					for(int i = 0; i < args.length; i++){
	             							query = query + "," + "'" + args[i] + "'";
	             						}
	             					query += ")";
	             						
		             }
	             System.out.println("Query: " + query);
	             
	             r = s.executeQuery(query);
	             r.close();
	             s.close();
	             conn.close();
	     }
	     catch (Exception e) {
	             System.out.println("The database could not be accessed." );
	             System.out.println("More information is available as follows:");
	             out.println();
	             e.printStackTrace();
	     }
	}
	public void errorprint(String message,String tableType,HttpServletResponse response )throws IOException {

		response.setContentType("text/html");
		PrintWriter out1 = response.getWriter();
		out1.println(message);
		out1.println("<form action=\"DBChangeServlet\" method=\"POST\">" +
				"<br>" +
				"<br>" +
		"<FONT SIZE=\"3\" COLOR=\"#006600\" FACE=\"verdana\">" +
		
		"<br>" +
		"<input type=submit name=\"DBChange\" value=\""+ tableType + " update\">" +
		"<input type=submit name=\"DBChange\" value=\""+ tableType + " create\">" +
		"<input type=submit name=\"DBChange\" value=\""+ tableType + " delete\">" +
		"</FONT></form>");
		}
	//format ssn 
	public String intFormatSSN(String ssn){
		return ssn.substring(0,3) + ssn.substring(4,6) + ssn.substring(7);
	}
	public String stringFormatSSN(String ssn){
		System.out.println("incoming ssn:" + ssn);
		StringBuffer st = new StringBuffer(ssn); 
		st = st.insert(3, '-');
		st = st.insert(6, '-');
		System.out.println("outgoing ssn:" + st.toString());
		return st.toString(); 
	}

}
