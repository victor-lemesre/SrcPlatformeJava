<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Confirm Registration</title>
</head>
<body>
	<h1>Confirm Registration</h1>

	<p>Please review your registration details:</p>
	<ul>
		<li>First Name: <%=request.getAttribute("firstName")%></li>
		<li>Last Name: <%=request.getAttribute("lastName")%></li>
		<li>Email: <%=request.getAttribute("email")%></li>
		<li>Password: <%=((String) request.getAttribute("password"))%></li>
	</ul>
</body>
</html>

