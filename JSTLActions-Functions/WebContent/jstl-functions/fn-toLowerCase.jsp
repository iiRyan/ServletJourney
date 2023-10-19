<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>fn:toLowerCase Demo</title>
	</head>
	<body>
		
		<c:set var="text" value="Servlet and JSP Course"/>
		Text before conversion:  <c:out value="${text}"/><br/><br/>
		
		<c:set var="text" value="${fn:toLowerCase(text)}"/>
		Text after conversion:  <c:out value="${text}"/><br/><br/>
		
	</body>
</html>