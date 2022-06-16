
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@page isELIgnored="false" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">


<div class="container">
	<h1>Update Employee Data</h1>
	<form:form modelAttribute="emp">
		<table border="1" class="table table-dark table-hover">
			<tr>
				<td>Employee Id : </td>
				<td><form:input path="id" readonly="true" /> </td>	<!-- id indicating emp 's property(or)field  -->
			</tr>
			<tr>
				<td>Employee Name : </td>
				<td><form:input path="name"  /> </td>	<!--name indicating emp 's property(or)field  -->
			</tr>
			<tr>
				<td>Employee Role : </td>
				<td><form:input path="role"/> </td>	<!--role indicating emp 's property(or)field  -->
			</tr>
			<tr>
				<td>Employee DOB : </td>
				<td><form:input  path="dateOfBirth"/> </td>	<!--name indicating emp 's property(or)field  -->
			</tr>
			<tr>
				<td>Employee Salary : </td>
				<td><form:input path="salary"/> </td>	<!--salary indicating emp 's property(or)field  -->
			</tr>
			<tr>
				<td>Employee Location : </td>
				<td><form:input path="location"/> </td>	<!--location indicating emp 's property(or)field  -->
			</tr>
			<tr>
				<td colspan="2" align="center"> <input type="submit" value="Update Employee"> </td>
			</tr>	
		</table>
	</form:form>
</div>