<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BaseBall Database</title>
</head>
<body><br><a href="indexMain.jsp" target="main" > <b>HOME</b> </a>
<form action="RadioChoiceServlet" method="POST" target="main">
<div align="left"><br><br>
<input type="radio" name="Table" value="Staff"  checked> Staff
<input type="checkbox" name="staff1" value="Butter"  style = "visibility:hidden" checked> 
<input type="checkbox" name="staff2" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="staff3" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="staff4" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="staff5" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="staff6" value="Butter" style = "visibility:hidden" checked> 
<br>
<input type="radio" name="Table" value="Team"> Team
<input type="checkbox" name="team1" value="Butter"  style = "visibility:hidden" checked> 
<input type="checkbox" name="team2" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="team3" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="team4" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="team5" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="team6" value="Butter" style = "visibility:hidden" checked>
<br>
<input type="radio" name="Table" value="Agent"> Agent<BR>
<input type="checkbox" name="agent1" value="Butter"  style = "visibility:hidden" checked> 
<input type="checkbox" name="agent2" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="agent3" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="agent4" value="Butter" style = "visibility:hidden" checked> 
<br>
<input type="radio" name="Table" value="Owner"> Owner<br>
<input type="checkbox" name="owner1" value="Butter"  style = "visibility:hidden" checked> 
<input type="checkbox" name="owner2" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="owner3" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="owner4" value="Butter" style = "visibility:hidden" checked>
<br>
<input type="radio" name="Table" value="Player"> Player
<input type="checkbox" name="player1" value="Butter"  style = "visibility:hidden" checked> 
<input type="checkbox" name="player2" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="player3" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="player4" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="player5" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="player6" value="Butter" style = "visibility:hidden" checked>
<input type="checkbox" name="player7" value="Butter" style = "visibility:hidden" checked>
<br>
<input type="radio" name="Table" value="Division"> Division<br>
<input type="checkbox" name="division1" value="Butter"  style = "visibility:hidden" checked> 
<input type="checkbox" name="division2" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="division3" value="Butter" style = "visibility:hidden" checked> 
<br>
<input type="radio" name="Table" value="Ballpark"> BallPark
<input type="checkbox" name="ballpark1" value="Butter"  style = "visibility:hidden" checked> 
<input type="checkbox" name="ballpark2" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="ballpark3" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="ballpark4" value="Butter" style = "visibility:hidden" checked> 
<input type="checkbox" name="ballpark5" value="Butter" style = "visibility:hidden" checked> 
</div>
<br>
<input type="submit" value="Choose" >
</form>
</body>
</html>