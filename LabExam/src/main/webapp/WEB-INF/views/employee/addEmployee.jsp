<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-dark bg-dark">
    <h3 style=" color:white ">Hire Employee Form</h3>
</nav>
<div class="alert alert-success">
  <strong>${message}</strong> 
</div>
	<form:form method="post" modelAttribute="employee" style="padding-top: 10px"> 
		<table style="background-color: #ffcc66; margin: auto; height:300px;width:400px;border-radius: 15px ">
			<tr>
				<td style="padding-left: 10px">Enter Employee Name</td>
				<td><form:input path="name" /></td>
				
				
				
			</tr>
			<tr>
				<td style="padding-left: 10px">Enter Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
					<td style="padding-left: 10px">Enter salary </td>
				<td><form:input type="number" path="salary" /></td>
			</tr>
			<tr>
				<td style="padding-left: 10px">Enter DOB </td>
				<td><form:input type="date" path="dob" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="btn btn-info btn-sm" value="Hire Employee"/></td>
			</tr>
		</table>
	</form:form>

</body>
</html>