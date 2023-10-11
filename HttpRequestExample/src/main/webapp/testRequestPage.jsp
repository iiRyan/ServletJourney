<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request TEST</title>
</head>
<body>
	<!-- In Order To send any requst to any web component you have 2 main method -->
	<!-- 1- HTML Form 
			 2- HTML <a href=""> Tag -->

	<form action="testRequest" method="POST">
		<input type="text" name="userName" id="userName" />
		<!-- name ==>Parameter id==> select HTML control using JS-->
		
		
		<select name="country">
		<option>KSA</option>
		<option>THAI</option>
		<option>USA</option>
		</select>
		<br/>
		<input type="submit" name="submit" value="submit" />
	</form>
</body>
</html>