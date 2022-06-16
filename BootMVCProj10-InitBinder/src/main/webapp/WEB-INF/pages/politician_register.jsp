<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div align="center">
	
	<form:form modelAttribute="politician">
		<table align="center" bgcolor="grey">
			<tr>
				<td>Politician Name : </td>
				<td> <form:input path="name" /> </td>
			</tr>
			<tr>
				<td>Politician Party : </td>
				<td> <form:input path="party"/> </td>
			</tr>
			<tr>
				<td>Politician Date of Birthday : </td>
				<td> <form:input path="dob"/> </td>
			</tr>
			<tr>
				<td>Politician Date of Join : </td>
				<td> <form:input path="doj" type="date"/> </td>
			</tr>
			<tr>
				<td>Has constitutional post? : </td>
				<td> 
					<form:radiobutton path="hasConstitutionalPost" value="true"/>Yes &nbsp; 
					<form:radiobutton path="hasConstitutionalPost" value="false"/>No &nbsp; 					
				</td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="register"> </td>	
			</tr>		
		</table>
	</form:form>

</div>










