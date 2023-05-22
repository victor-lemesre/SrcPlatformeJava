<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.math.BigInteger"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="square" method="get">
		<table>

			<tr>
				<td>Number Choice</td>
				<td><input type="Number" name="choice" required /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Valider" /></td>
			</tr>
			<tr>

				<%
				if (null != request.getParameter("choice")) {
				    String enteredNumber = request.getParameter("choice");
				    BigInteger number = new BigInteger(enteredNumber);
				    BigInteger numberSquared = number.pow(2);
				%>
					<p>The square of <%=number%> is <%=numberSquared%></p>

				<%
				}
				%>
			</tr>
		</table>
	</form>


</body>
</html>