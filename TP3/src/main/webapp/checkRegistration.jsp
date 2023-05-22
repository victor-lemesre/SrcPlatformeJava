<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Error</title>
</head>
<body>
	<h1>Error: Incorrect Input Data</h1>

	<p>Please check the following fields:</p>
	<ul>
		<%
		if (request.getAttribute("firstName") == null || ((String) request.getAttribute("firstName")).isEmpty()) {
		%>
		<li>First Name is required</li>
		<%
		} else {
		%>
		<li>First Name: <%=(String) request.getAttribute("firstName")%></li>
		<%
		}
		%>

		<%
		if (request.getAttribute("lastName") == null || ((String) request.getAttribute("lastName")).isEmpty()) {
		%>
		<li>Last Name is required</li>
		<%
		} else {
		%>
		<li>Last Name: <%=(String) request.getAttribute("lastName")%></li>
		<%
		}
		%>

		<%
		if (request.getAttribute("email") == null || ((String) request.getAttribute("email")).isEmpty()) {
		%>
		<li>Email is required</li>
		<%
		} else {
		%>
		<li>Email: <%=(String) request.getAttribute("email")%></li>
		<%
		}
		%>

		<%
		if (request.getAttribute("password") == null || ((String) request.getAttribute("password")).isEmpty()) {
		%>
		<li>Password is required</li>
		<%
		} else {
		%>
		<li>Password: <%= ((String) request.getAttribute("password")).substring(0, 3) + "..." %></li>
		<%
		}
		%>

	</ul>

	<p>
		<a href="viewRegistration.jsp">Go back to registration</a>
	</p>
</body>
</html>

