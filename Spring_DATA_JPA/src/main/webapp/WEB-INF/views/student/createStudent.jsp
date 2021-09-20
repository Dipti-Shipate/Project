<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Student Page</title>
</head>
<body>
This is Create Student Page
<br>
Student registration page
<br>
<form:form method="post" modelAttribute="student">
Enter Student Name : <form:input path="name"/>
<br>
Enter Student Age : <form:input path="age"/><br>
<input type="submit" value="Register Student"/>
</form:form>
<br>
${requestScope.message}
</body>
</html>