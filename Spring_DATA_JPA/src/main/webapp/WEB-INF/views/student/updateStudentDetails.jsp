<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student Details</title>
</head>
<body>
Update Student Details Page
<br>
<form method="post">
Enter  Student id : <input type="number" name="studentid">
<br>
Enter Updated Student Age : <input type="number" name="studentage">
<br>
<input type="submit" value="Update Student Details">
</form>
<br>
${requestScope.message}
</body>
</html>