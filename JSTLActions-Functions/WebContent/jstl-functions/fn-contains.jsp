<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>fn:contains Demo</title>
	</head>
	<body>
		<h1>fn:contains Demo</h1>
		
		<c:set var="stringToSearch" value="JEE, Servlet and JSP Course" />		
		<c:out value="${stringToSearch}" />
		
		<c:if test="${fn:contains(stringToSearch, 'Servlet1')}">
			<p>The above sentence contains Servlet</p>
		</c:if>		
	</body>
</html>