<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
	<head>
		<title>fmt:parseNumber tag</title>
	</head>
	<body>
		<h3>The fmt:parseNumber tag Example is:</h3>
	
		<c:set var="amount" value="786.970" />			
		<fmt:parseNumber var="j" integerOnly="true" type="number" value="${amount}" />
		
		<p>
			<i>Amount is:</i>
			<c:out value="${j}" />
		</p>
	</body>
</html>
