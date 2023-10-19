<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Core Tag Example</title>
</head>
<body>
	<c:url value="/11-redirectAction.jsp" var="completeURL">
		<c:param name="param1" value="value1" />
		<c:param name="param2" value="value2" />
	</c:url>
	${completeURL}
</body>
</html>
