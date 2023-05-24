<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="exercice5.ArithmeticBean"%>

<jsp:useBean id="calculator" class="exercice5.ArithmeticBean"
	scope="page" />

<c:set target="${calculator}" property="operand1"
	value="${param.operand1}" />
<c:set target="${calculator}" property="operand2"
	value="${param.operand2}" />

<c:set var="operation" value="${param.operation}" />


<c:choose>
	<c:when test="${operation eq 'addition'}">
		<c:set var="result" value="${calculator.getAdditionResult()}" />
	</c:when>
	<c:when test="${operation eq 'subtraction'}">
		<c:set var="result" value="${calculator.getSubtractionResult()}" />
	</c:when>
	<c:when test="${operation eq 'multiplication'}">
		<c:set var="result" value="${calculator.getMultiplicationResult()}" />
	</c:when>
	<c:when test="${operation eq 'division'}">
		<c:set var="result" value="${calculator.getDivisionResult()}" />
	</c:when>
	<c:otherwise>
		<c:set var="result" value="Invalid operation" />
	</c:otherwise>
</c:choose>

<!DOCTYPE html>
<html>
<head>
<title>Result</title>
</head>
<body>
	<h1>Result</h1>
	<p>Operation: ${operation}</p>
	<p>Result: ${result}</p>
</body>
</html>
