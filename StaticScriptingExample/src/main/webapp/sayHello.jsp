<%@page import="java.util.Date"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/helloJS.js">
	
</script>
<meta charset="UTF-8">
<title>Say Hello</title>
</head>
<body>
	<input type="button" onclick="sayHello()" value="Say Hello">
	<br>

	<!-- Servlet Class  -->

	<%!public String sayHello() {
		return " Hello From Function ";
	}%>

	<!-- Service Method  -->
	<%=sayHello()%>
	<br>
	<%
	out.println(sayHello());
	
	// Implicit Object ==> no need to define the object the container will definde it automaticlly.
	response.getWriter().println(sayHello());
	%>
	
	<!-- The code above is not consider good practice.Insted Replcae Scripting Element by using JSP Action -->
</body>
</html>