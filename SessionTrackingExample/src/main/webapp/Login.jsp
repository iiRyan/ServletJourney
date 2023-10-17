<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<form action="loginServlet" method="POST">
			<label>User Name:</label>
			<input type="text" name="userName" >
			<label>Password</label>
			<input type="password" name="password" >
			<br/>
			<input type="submit" name="Login" value="Login">
		</form>
	</body>
</html>