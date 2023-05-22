<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exercice 3</title>
</head>
<body>

	<table>
		<tr>
			<td>
				<h1>Order</h1>
			</td>
			<td><h1>Designation</h1></td>
		</tr>
		<c:forEach items="${LISTE}" var="number" varStatus="position">
			<tr>
				<td>${position.index +1}</td>
				<td>${number}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>