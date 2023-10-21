<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fn:replace Demo</title>
</head>
<body>
	<h1>fn:replace Demo</h1>

	<c:set var="text" value="There are sixteen JSTL functions." />
	Before replace:  <c:out value="${text}"/>
	<c:set var="text" value="${fn:replace(text,'sixteen', '16')}" /><br/>
	After replace:  <c:out value="${text}"/><br/>
	
	<a href="../index.jsp">Back</a>
</body>
</html>