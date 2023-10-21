<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Core Tag Example</title>
</head>
<body>
	<c:set var="url" value="0" scope="request" />
	<c:if test="${url<1}">
		<c:redirect url="http://www.google.com" />
	</c:if>
	<c:if test="${url>1}">
		<c:redirect url="http://www.youtube.com" />
	</c:if>
</body>
</html>
