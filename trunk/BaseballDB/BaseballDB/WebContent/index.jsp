<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Baseball DataBase</title>
</head>
<body>
<H1>DataBase Tables</H1>
<form action="StaffServlet" method="POST">
<input type="submit" value="Staff Table">
</form>
<BR>
<form action="TeamServlet" method="POST">
<input type="submit" value="Team Table">
</form>
<BR>
<form action="AgentServlet" method="POST">
<input type="submit" value="Agent Table">
</form>
<BR>
<form action="OwnerServlet" method="POST">
<input type="submit" value="Owner Table">
</form>
<BR>
<form action="PlayerServlet" method="POST">
<input type="submit" value="Player Table">
</form>
<BR>
<form action="DivisionServlet" method="POST">
<input type="submit" value="Division Table">
</form>
<BR>
<form action="BallparkServlet" method="POST">
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
<BR><BR>
<H1>Choose A Table</H1>
<form action="RadioChoiceServlet" method="POST">
<div align="left">
<input type="radio" name="Table" value="Staff"> Staff<br>
<input type="radio" name="Table" value="Team"> Team<br>
<input type="radio" name="Table" value="Agent"> Agent<BR>
<input type="radio" name="Table" value="Owner"> Owner<br>
<input type="radio" name="Table" value="Player" checked> Player<br>
<input type="radio" name="Table" value="Division"> Division<br>
<input type="radio" name="Table" value="Ballpark"> BallPark<br>
</div>
<input type="submit" value="Choose">
</form>
</body>
</html>