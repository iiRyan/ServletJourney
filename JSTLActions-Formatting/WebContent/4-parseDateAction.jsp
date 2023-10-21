<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
	<head>
		<title>fmt:parseDate Tag</title>
	</head>
	<body>
		<h3>Parsed Date:</h3>
		
		<c:set var="date" value="03-05-2022" />	
		<fmt:parseDate value="${date}" var="parsedDate" pattern="dd-MM-yyyy" />
		
		<p>
			<c:out value="${parsedDate}" />
		</p>
	</body>
</html>
