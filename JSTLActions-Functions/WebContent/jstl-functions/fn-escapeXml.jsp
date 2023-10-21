<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fn:escapeXml Demo</title>
</head>
<body>
	<h1>fn:escapeXml Demo</h1>

	<c:set var="html" value="<b><i>This is html text.</i></b>" />
	<p>just html: ${html}</p>
	<p>html with escapeXml: ${fn:escapeXml(html)}</p>
	
	<a href="../index.jsp">Back</a>
</body>
</html>