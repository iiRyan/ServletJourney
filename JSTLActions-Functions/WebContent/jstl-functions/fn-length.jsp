<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fn:length Demo</title>
</head>
<body>
	<h1>fn:length Demo</h1>

	<c:set var="text" value="Code JEE Course" />
	<c:out value="${text}" />
	<p>Length: ${fn:length(text)}</p>
	<a href="../index.jsp">Back</a>
</body>
</html>