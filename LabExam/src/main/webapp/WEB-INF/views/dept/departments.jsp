<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Departments</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
    <h3 style=" color:white ">Department List</h3>
</nav>
	<table style="background-color: #ffff66; margin: auto; width: 35%; border: solid 1px " class="table table-striped">
		<c:forEach var="dept" items="${requestScope.deptlist}">
		<tr>
		<th style="text-align: center;">Dept Name</th>
			<th>Dept Location</th>
			<th>Dept Strength</th>
		</tr>
			<tr>
				<td><a
					href="<spring:url value='/employee/addEmployee?deptid=${dept.id}'/>">${dept.deptname}</a></td>
				<td>${dept.location}</td>
				<td>${dept.strength}</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>

