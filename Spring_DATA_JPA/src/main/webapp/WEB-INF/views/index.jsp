<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
This is Index Page
<br>
<a href='<spring:url value="/student/createStudent"></spring:url>'>Create Student</a>
<br>
<a href='<spring:url value="/student/deleteStudent"></spring:url>'>Delete Student</a>
<br>
<a href='<spring:url value="/student/getStudentDetails"></spring:url>'>Get Student Details</a>
<br>
<a href='<spring:url value="/student/updateStudentDetails"></spring:url>'>Update Student Details</a>
</body>
</html>