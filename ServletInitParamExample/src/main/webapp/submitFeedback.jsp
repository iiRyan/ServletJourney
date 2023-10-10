<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>FeedBack Page</title>
</head>

<body>
<form action="feedbackServlet" method="post">
<h1>Submit Your feedback</h1>
<textarea rows="5" name="feedbackParam"></textarea>
<input type="submit" name="submit" value="Submit Feedback">
</form>
</body>

</html>