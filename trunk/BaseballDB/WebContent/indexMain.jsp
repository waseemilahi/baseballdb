<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BaseBall DataBase</title>
</head>
<body>
<H1>DataBase Tables</H1>
<form action="StaffServlet" method="POST">
<input type="checkbox" name="staff1" value="S.S. Number" style = "visibility:hidden"  checked> 
<input type="checkbox" name="staff2" value="Name"  style = "visibility:hidden" checked> 
<input type="checkbox" name="staff3" value="Title"  style = "visibility:hidden" checked> 
<input type="checkbox" name="staff4" value="Salary"  style = "visibility:hidden" checked> 
<input type="checkbox" name="staff5" value="Address"  style = "visibility:hidden" checked> 
<input type="checkbox" name="staff6" value="Park ID"  style = "visibility:hidden" checked> 
<br>
<input type="submit" value="Staff Table" >
</form>
<BR>
<form action="TeamServlet" method="POST">
<input type="checkbox" name="team1" value="Team ID"  style = "visibility:hidden" checked> 
<input type="checkbox" name="team2" value="Name" style = "visibility:hidden" checked> 
<input type="checkbox" name="team3" value="State" style = "visibility:hidden" checked> 
<input type="checkbox" name="team4" value="Division ID" style = "visibility:hidden" checked> 
<input type="checkbox" name="team5" value="Park ID" style = "visibility:hidden" checked> 
<input type="checkbox" name="team6" value="Manager S.S. No." style = "visibility:hidden" checked>
<br>
<input type="submit" value="Team Table">
</form>
<BR>
<form action="AgentServlet" method="POST">
<input type="checkbox" name="agent1" value="Agent S.S. No."  style = "visibility:hidden" checked> 
<input type="checkbox" name="agent2" value="Name" style = "visibility:hidden" checked> 
<input type="checkbox" name="agent3" value="Address" style = "visibility:hidden" checked> 
<input type="checkbox" name="agent4" value="Corporation" style = "visibility:hidden" checked> 
<br>
<input type="submit" value="Agent Table">
</form>
<BR>
<form action="OwnerServlet" method="POST">
<input type="checkbox" name="owner1" value="Owner S.S. Number"  style = "visibility:hidden" checked> 
<input type="checkbox" name="owner2" value="Name" style = "visibility:hidden" checked> 
<input type="checkbox" name="owner3" value="Worth" style = "visibility:hidden" checked> 
<input type="checkbox" name="owner4" value="Team ID" style = "visibility:hidden" checked>
<br>
<input type="submit" value="Owner Table">
</form>
<BR>
<form action="PlayerServlet" method="POST">
<input type="checkbox" name="player1" value="Player S.S. No."  style = "visibility:hidden" checked> 
<input type="checkbox" name="player2" value="Position" style = "visibility:hidden" checked> 
<input type="checkbox" name="player3" value="Address" style = "visibility:hidden" checked> 
<input type="checkbox" name="player4" value="Name" style = "visibility:hidden" checked> 
<input type="checkbox" name="player5" value="Salary" style = "visibility:hidden" checked> 
<input type="checkbox" name="player6" value="Agent ID" style = "visibility:hidden" checked>
<input type="checkbox" name="player7" value="Team ID" style = "visibility:hidden" checked>
<br>
<input type="submit" value="Player Table">
</form>
<BR>
<form action="DivisionServlet" method="POST">
<input type="checkbox" name="division1" value="Division ID"  style = "visibility:hidden" checked> 
<input type="checkbox" name="division2" value="League" style = "visibility:hidden" checked> 
<input type="checkbox" name="division3" value="Location" style = "visibility:hidden" checked> 
<br>
<input type="submit" value="Division Table">
</form>
<BR>
<form action="BallparkServlet" method="POST">
<input type="checkbox" name="ballpark1" value="Park ID"  style = "visibility:hidden" checked> 
<input type="checkbox" name="ballpark2" value="Capacity" style = "visibility:hidden" checked> 
<input type="checkbox" name="ballpark3" value="Name" style = "visibility:hidden" checked> 
<input type="checkbox" name="ballpark4" value="Year Built" style = "visibility:hidden" checked> 
<input type="checkbox" name="ballpark5" value="Type" style = "visibility:hidden" checked> 
<br>
<input type="submit" value="BallPark Table">
</form>
<BR><BR>
<H1>Queries From Project 1.2</H1>
<form action="QueryOneServlet" method="POST">
<input type="submit" value="First Query">
</form>
<BR>
<form action="QueryTwoServlet" method="POST">
<input type="submit" value="Second Query">
</form>
<BR>
<form action="QueryThreeServlet" method="POST">
<input type="submit" value="Third Query">
</form>
</body>
</html>