<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fn:split Demo</title>
</head>
<body>
	<h1>fn:split Demo</h1>

	<c:set var="numbers" value="One,Two,Three,Four,Five" />
	<c:set var="splitNumbers" value="${fn:split(numbers,',')}" />
	<c:set var="joinedNumbers" value="${fn:join(splitNumbers,' ')}" />
	<p>Numbers before split: ${numbers}</p>
	<p>Numbers after split and join: ${joinedNumbers}</p>

	<a href="../index.jsp">Back</a>
</body>
</html>