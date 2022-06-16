<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Seeker</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<style type="text/css">
	h1{
		text-align: center;
	}
</style>
</head>
<body>

	<div class="container">
		<h1>Jobseeker data</h1>
		<table class="table">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Resume</th>
				<th>Photo</th>
				<th>Action</th>
			</tr>
			<c:forEach var="js" items="${jsList}">
				<tr>
					<td>${js.id}</td>
					<td>${js.name}</td>
					<td>${js.address}</td>
					<td><a href="download?id=${js.id}&fileType=resume">download resume</a></td>
					<td><a href="download?id=${js.id}&fileType=photo">download photo</a></td>
					<td> 
						<a href="">update</a> &nbsp;
						<a href="">delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>