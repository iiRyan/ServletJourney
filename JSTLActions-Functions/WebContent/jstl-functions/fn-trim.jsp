<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fn:trim Demo</title>
</head>
<body>
	<h1>fn:trim Demo</h1>
		
	<c:set var="text" value="    Sample text    " />
	<p>Original text before trim: <strong><c:out value="${text}"/></strong>	
	<p>Length of text before trim: ${fn:length(text)}</p>

	<c:set var="trimmedText" value="${fn:trim(text)}" />
	<p>Original text after trim: <strong><c:out value="${trimmedText}"/></strong>
	<p>Length of text after trim: ${fn:length(trimmedText)}</p>
	

	<a href="../index.jsp">Back</a>
</body>
</html>