<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="exercice3.LoginBean,exercice3.business.LoginBusiness, exercice3.business.LoginBusinessImpl, exercice3.Dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EXERCICE 3</title>
</head>
<body>

    <%
    LoginBean user = new LoginBean(request.getParameter("nom"), request.getParameter("password"));

    LoginBusiness business = new LoginBusinessImpl();

    if (business.isUserValid(user)) {
    %>
    <h1>Welcome!</h1> 
    <%
    } else {
    %>
    <h1>Not authorized</h1>
    <%
    }
    %> 
</body>
</html>