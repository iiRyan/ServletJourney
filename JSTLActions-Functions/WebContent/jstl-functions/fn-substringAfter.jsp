<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fn:substringAfter Demo</title>
</head>
<body>
	<h1>fn:substringAfter Demo</h1>
	<c:set var="text" value="www.CodeJava.net is great source of information."/>
    <c:set var="website" value="${fn:substringAfter(text,'www.')}" />
	Full Text: <strong><c:out value="${text}"/></strong><br/><br/>
	Text After Substring www. <strong><c:out value="${website}"/></strong><br/><br/>
	<a href="../index.jsp">Back</a>
</body>
</html>