<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<title>Basket</title>
</head>
<body>
	<h1>Basket</h1>

	<table>
		<tr>
			<th>Product</th>
			<th>Quantity</th>
		</tr>
		<%@ page language="java"%>
		<%
		Map<String, Integer> selectedProducts = (Map<String, Integer>) session.getAttribute("selectedProducts");
		if (selectedProducts != null && !selectedProducts.isEmpty()) {
			for (Map.Entry<String, Integer> entry : selectedProducts.entrySet()) {
				String product = entry.getKey();
				int quantity = entry.getValue();
		%>
		<tr>
			<td><%=product%></td>
			<td><%=quantity%></td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="2">No products selected</td>
		</tr>
		<%
		}
		%>
	</table>

	<a href="productSelection.jsp">Go back to product selection</a>
</body>
</html>



