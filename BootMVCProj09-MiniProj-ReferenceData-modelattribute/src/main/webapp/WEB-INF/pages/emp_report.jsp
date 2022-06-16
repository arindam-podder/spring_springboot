<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

<style>
	img {
		width: 50px;
		height: 50px;
	}
</style>

<div class="container">
	<h1>Employees Data</h1>
	
	<!-- empsData.getContent() will give list of emp for that page -->
	<c:choose>
		<c:when test="${!empty empsData.getContent()}">
			<table border="1" class="table table-hover">
				<tr class="thead-dark">
					<th>ENO</th>
					<th>NAME</th>
					<th>ROLE</th>
					<th>DOB</th>
					<th>SALARY</th>
					<th>Country</th>
					<th>State</th>
					<th>OPERATION</th>				
				</tr>
				<c:forEach items="${empsData.getContent()}" var="emp">
					<tr>
						<td>${emp.id }</td>
						<td>${emp.name }</td>
						<td>${emp.role }</td>
						<td>${emp.dateOfBirth }</td>
						<td>${emp.salary }</td>
						<td>${emp.location }</td>
						<td>${emp.state }</td>
						<td>
							<a href="edit?id=${emp.id}"><img src="images/edit.png"/></a>
							<a href="delete?id=${emp.id}" onclick="return deleteEmp()"><img src="images/delete.png"/></a>
						</td>
					</tr>
				</c:forEach>
			</table>
			
			<p align="right">
				<c:if test="${empsData.hasPrevious()}">
					<a class="btn btn-primary" href="report?page=${empsData.getPageable().getPageNumber()-1}">Previous</a>
				</c:if> &nbsp;
				<c:if test="${!empsData.isFirst()}">
					<a class="btn btn-primary" href="report?page=0">First</a>
				</c:if>	&nbsp;	
				<c:forEach var="i" begin="1" step="1" end="${empsData.getTotalPages()}">
					<a class="btn btn-dark" href="report?page=${i-1}">${i}</a>
				</c:forEach> &nbsp;
				<c:if test="${!empsData.isLast()}">
					<a class="btn btn-primary" href="report?page=${empsData.getTotalPages()-1}">Last</a>
				</c:if>
				<c:if test="${empsData.hasNext()}">
					<a class="btn btn-primary" href="report?page=${empsData.getPageable().getPageNumber()+1}">Next</a>
				</c:if>
			</p>
			
		</c:when>
		
		<c:otherwise>
			<h1 style="color: red; text-align: center;">No Employee record found.</h1>
		</c:otherwise>
	
	</c:choose>
	
	<c:if test="${!empty resultMsg }">
		<h3 style="color: green;text-align: center;">${resultMsg}</h3>
	</c:if>
	<br><br>
	<h2 style="text-align: center;"> <a href="add"> <img src="images/add.png"/> Add Employee</a> </h2>
</div>


<script type="text/javascript">

function deleteEmp() {
	return confirm('Do u want to delete?');
}

</script>






