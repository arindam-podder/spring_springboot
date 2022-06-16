<!-- here i am using spring framework given 'form' tag library  -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@page isELIgnored="false" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">


<script type="text/javascript" src="js/validations.js">
	
</script>

<div class="container" style="margin-top: 20px">
	
	<noscript>
		<h1>plz enable java script.</h1>
	</noscript>

	<h1 align="center">Register Employee</h1>
	
	<form:form modelAttribute="emp" onsubmit="return validation(this)">
	
		<p align="center" style="color: red; font-weight: bold;">
			<form:errors path="*" /> 
		</p>
	
		<table border="1" class="table table-dark table-hover">
			<tr>
				<td>Employee Name : </td>
				<td><form:input path="name"/> <span id = "nameErr"></span></td>	<!--name indicating emp 's property(or)field  -->
			</tr>
			<tr>
				<td>Employee Role : </td>
				<td><form:input path="role"/> <span id = "roleErr"></span></td>	<!--role indicating emp 's property(or)field  -->
			</tr>
			<tr>
				<td>Employee DOB : </td>
				<td><form:input path="dateOfBirth"/> <span id = "dobErr"></span><br><span>[ example:1900/12/23 ]</span> </td>
			</tr>
			<tr>
				<td>Employee Salary : </td>
				<td><form:input path="salary"/> <span id = "salaryErr"></span></td>	<!--salary indicating emp 's property(or)field  -->
			</tr>
			<tr>
				<td>Employee Location : </td>
				<td><form:input path="location"/> </td>	<!--location indicating emp 's property(or)field  -->
			</tr>
			<!-- hidden field -->
			<form:hidden path="vflag"/>
			
			<tr>
				<td colspan="2" align="center"> <input type="submit" value="Register Employee"> </td>
			</tr>	
		</table>
	</form:form>
</div>	
	
	
	