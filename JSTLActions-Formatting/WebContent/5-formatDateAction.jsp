<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<title>fmt:formatDate</title>
	</head>
	<body>
		<h2>Different Formats of the Date</h2>
		<c:set var="Date" value="<%=new java.util.Date()%>" />
		<p>
			Formatted Time :
			<fmt:formatDate type="time" value="${Date}" />
		</p>
		<p>
			Formatted Date :
			<fmt:formatDate type="date" value="${Date}" />
		</p>
		<p>
			Formatted Date and Time :
			<fmt:formatDate type="both" value="${Date}" />
		</p>
		<p>
			Formatted Date and Time in short style :
			<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
				value="${Date}" />
		</p>
		<p>
			Formatted Date and Time in medium style :
			<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"
				value="${Date}" />
		</p>
		<p>
			Formatted Date and Time in long style :
			<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
				value="${Date}" />
		</p>	
	</body>
</html>
