<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fn:containsIgnoreCase Demo</title>
</head>
<body>
	<h1>fn:containsIgnoreCase Demo</h1>
	<c:set var="stringToSearch"
		value="CodeJava.net is a great source of information." />
	<c:out value="${stringToSearch}"/>
	<c:if test="${fn:containsIgnoreCase(stringToSearch, 'codejava')}">
		<p>The above sentence contains codejava</p>
	</c:if>	
	<a href="../index.jsp">Back</a>
</body>
</html>