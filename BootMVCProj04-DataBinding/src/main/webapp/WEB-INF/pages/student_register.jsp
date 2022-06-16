<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Student register page</h1>
	<!-- <form action="register" method="post"> -->
	<form  method="post">	
		<tr>
			<td>student id : </td>
			<td><input type="number" name="id" /> </td>
		</tr>	
		<tr>
			<td>student name : </td>
			<td><input type="text" name="name" /> </td>
		</tr>
		<tr>
			<td>student location : </td>
			<td><input type="text" name="location" /> </td>
		</tr>
		<tr>
			<td>student average : </td>
			<td><input type="number" name="average" /> </td>
		</tr>
		<input type="submit" value="register" />
	</form>

</body>
</html>