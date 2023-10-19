<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fn:toUpperCase Demo</title>
</head>
<body>
	<h1>fn:toUpperCase Demo</h1>

	<c:set var="text" value=" codejava.net is great source of information"/>
	Text before conversion:  <c:out value="${text}"/><br/><br/>
	<c:set var="text" value="${fn:toUpperCase(text)}"/>
	Text after conversion:  <c:out value="${text}"/><br/><br/>


	<a href="../index.jsp">Back</a>
</body>
</html>