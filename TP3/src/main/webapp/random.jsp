<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="draw">
		<table>
			<tr>
				<td>Number Choice</td>
				<td><input type="Number" name="choice" min="1" max="10" required/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Valider" /></td>
			</tr>
			<tr>
			<c:if test="${RANDOM != null}">
				<c:choose>
					<c:when test="${RANDOM != SELECTED}">
						<p>You have selected :${SELECTED}</p> <br>
						<p>The corrected answer was ${RANDOM}</p><br>
						<p>You have lost !!</p>
					</c:when>
					<c:otherwise>
						<p>You have selected :${SELECTED}</p> <br>
                        <p>The corrected answer was ${RANDOM}</p><br>
                        <p>You have won !!</p>
						</c:otherwise>
				</c:choose>
</c:if>
			</tr>
		</table>
	</form>


</body>
</html>