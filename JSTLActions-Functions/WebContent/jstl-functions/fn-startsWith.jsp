<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fn:startsWith Demo</title>
</head>
<body>
	<h1>fn:startsWith Demo</h1>
	<c:set var="stringToSearch"
		value="www.CodeJava.net" />
	<c:out value="${stringToSearch}"/>
	<c:if test="${fn:startsWith(stringToSearch, 'www')}">
		<p>www.CodeJava.net starts with www</p>
	</c:if>	
	<a href="../index.jsp">Back</a>
</body>
</html>