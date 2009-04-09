<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RadioChoiceServlet" method="POST" target="main">
<div align="left">
<input type="radio" name="Table" value="Staff"> Staff<br>
<input type="radio" name="Table" value="Team"> Team<br>
<input type="radio" name="Table" value="Agent"> Agent<BR>
<input type="radio" name="Table" value="Owner"> Owner<br>
<input type="radio" name="Table" value="Player" checked> Player<br>
<input type="radio" name="Table" value="Division"> Division<br>
<input type="radio" name="Table" value="Ballpark"> BallPark<br>
</div>
<input type="submit" value="Choose" >
</form>
</body>
</html>