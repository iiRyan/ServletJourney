<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fn:indexOf Demo</title>
</head>
<body>
	<h1>fn:indexOf Demo</h1>

	<c:set var="text" value="The JSTL Functions Are Great." />
	<c:out value="${text}"/>
	<p>Index of 'JSTL' from above text is: ${fn:indexOf(text,'JSTL')}</p>
	
	<a href="../index.jsp">Back</a>
</body>
</html>