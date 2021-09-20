<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Student Details</title>
</head>
<body>
Get Student Details Page
<br>
<form method="post">
Enter Student id : <input type="number" name="studentid">
<input type="submit" value="Get Student Details">
</form>

<br>
${requestScope.studentDetailsById}
</body>
</html>