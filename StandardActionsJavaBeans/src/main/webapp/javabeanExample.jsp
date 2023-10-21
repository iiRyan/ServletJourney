<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Students</title>
	</head>
	<body>
			<jsp:useBean id="student" class="com.javabeans.beans.Student">
				<jsp:setProperty name="student" property="firstName" value="Rayan"/>
				<jsp:setProperty name="student" property="lastName" value="Alharbi"/>
				<jsp:setProperty name="student" property="email" value="iRayan@gmail.com"/>
			</jsp:useBean>
			<p> Student First Name : 
				<jsp:getProperty property="firstName" name="student"/>
			</p>
			
			<p> Student Last Name : 
				<jsp:getProperty property="lastName" name="student"/>
			</p>
			
			<p> Student Email : 
				<jsp:getProperty property="email" name="student"/>
			</p>
	</body>
</html>