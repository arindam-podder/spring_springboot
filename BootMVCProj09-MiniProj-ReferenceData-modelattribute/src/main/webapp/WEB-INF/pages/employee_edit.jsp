
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@page isELIgnored="false" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

<script type="text/javascript" src="js/validations.js">
</script>

<div class="container">
	
	<h1>Update Employee Data</h1>
	
	<form:form modelAttribute="emp" onsubmit="return validation(this)" name="frm" action="edit" method="post">
	<%-- <p align="center" style="color: red; font-weight: bold;">
			<form:errors path="*" />	<!-- form:errors applicable inside form:from only -->
		 </p> --%>
	
		<table border="1" class="table table-dark table-hover">
			<tr>
				<td>Employee Id : </td>
				<td>
					<form:input path="id" readonly="true" /> <!-- id indicating emp 's property(or)field  -->
				</td>	
				
			</tr>
			<tr>
				<td>Employee Name : </td>
				<td>
					<form:input path="name"  /> <br> <!--name indicating emp 's property(or)field  -->
					<form:errors cssStyle=" color: red" path="name" />
					<span id = "nameErr"></span>
				</td>
			</tr>
			<tr>
				<td>Employee Role : </td>
				<td>
					<form:input path="role"/> <br>	<!--role indicating emp 's property(or)field  -->
					<form:errors cssStyle=" color: red" path="role" />
					<span id = "roleErr"></span>
				</td>
			</tr>
			<tr>
				<td>Employee DOB : </td>
				<td>
					<form:input  path="dateOfBirth"/> <br><!--name indicating emp 's property(or)field  -->
					<form:errors cssStyle=" color: red" path="dateOfBirth" />
					<span id = "dobErr"></span>
				</td>	
			</tr>
			<tr>
				<td>Employee Salary : </td>
				<td>
					<form:input path="salary"/> <br><!--salary indicating emp 's property(or)field  -->
					<form:errors cssStyle=" color: red" path="salary" />
					<span id = "salaryErr"></span>
				</td>	
			</tr>
			<tr>
				<td>Employee Country : </td>
				<td> <form:select path="location" onchange="sendReqForState()"> <!--location indicating emp 's property(or)field  -->
						<form:options items="${ countriesList }"/>
					</form:select> 	
				</td>	
			</tr>
			<tr>
				<td>Employee State : </td>
				<td>
					<form:select path="state">
						<form:options items="${ statesList }"/>
					</form:select>
				</td>
			</tr>
			<!-- hidden field -->
			<form:hidden path="vflag"/>
			
			<tr>
				<td colspan="2" align="center"> <input type="submit" value="Update Employee"> </td>
			</tr>	
		</table>
	</form:form>
	<script lang="javaScript">
		function sendReqForState(){
			frm.action="statesupdate";
			frm.submit();
		}
	</script>
</div>