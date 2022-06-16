<!--  here i am using spring framework given from jstl tag -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="sp_frm"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register job seeker</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<style type="text/css">
	.container{
		margin-top : 100px;
		margin-left : 450px;
		width: 500px;
	}
</style>
</head>
<body>

	<div class="container">
		<h2>Enter the details below</h2>
		<sp_frm:form modelAttribute="js" enctype="multipart/form-data">
			<table class="table table-dark">
				<tr>
					<td>Name : </td>
					<td> <sp_frm:input path="name"/> </td>
				</tr>
				<tr>
					<td>Address : </td>
					<td> <sp_frm:input path="address"/> </td>
				</tr>
				<tr>
					<td>Resume : </td>
					<td> <sp_frm:input type="file" path="resume"/> </td>
				</tr>
				<tr>
					<td>Photo : </td>
					<td> <sp_frm:input type="file" path="photo"/> </td>
				</tr>
			</table>
			<input type="submit" value="register" class="btn btn-outline-success"/> 
		</sp_frm:form>
	</div>

</body>
</html>