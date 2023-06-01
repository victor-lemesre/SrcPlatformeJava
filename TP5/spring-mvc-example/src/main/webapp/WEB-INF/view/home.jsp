<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h1>Hello world!</h1>
The time on the server is ${serverTime}
<br>
   <form method="post" action="user">
        <table>
            <tr>
                <td><input type="text" name="userName" required /></td>
            </tr>

            <tr>
                
                <td><input type="submit" value="Valider" /></td>
            </tr>
        </table>
    </form>
</body>
</html>