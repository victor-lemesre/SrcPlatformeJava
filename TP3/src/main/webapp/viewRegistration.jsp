<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>User Registration</title>
</head>
<body>
	<form action="registration" method="post">
		<label for="firstName">First Name:</label> <input type="text"
			id="firstName" name="firstName"><br> <label
			for="lastName">Last Name:</label> <input type="text" id="lastName"
			name="lastName"><br> <label for="email">Email:</label>
		<input type="email" id="email" name="email"><br> <label
			for="password">Password:</label> <input type="password" id="password"
			name="password"><br> <input type="submit"
			value="Register">
	</form>
</body>
</html>

