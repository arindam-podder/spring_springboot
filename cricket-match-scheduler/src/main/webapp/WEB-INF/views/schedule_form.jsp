<%@page import="java.util.ArrayList"%>
<%@page import="com.sevya.cricketmatchscheduler.entities.Team"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cricket-match-scheduler</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fredoka:wght@500&display=swap" rel="stylesheet">
<style type="text/css">
body {
	background-image: 
		url("https://images.unsplash.com/photo-1631194758628-71ec7c35137e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8Y3JpY2tldHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60");
	background-repeat: no-repeat;
	background-size: cover;
	font-family: 'Fredoka', sans-serif;
	font-weight: bold;
}

.container {
	margin-top: 30px;
	font-weight: bolder;
}
</style>
</head>
<body>

	<div class="container">
		<h1>Schedule a Match</h1>
		<form action="match" method="post">
			<div class="form-group">
				<label for="exampleFormControlInput1">Date</label> <input
					type="date" name="date" class="form-control"
					id="exampleFormControlInput1" placeholder="00/00/0000">
			</div>
			<div class="form-group">
				<label for="exampleFormControlSelect1">Team A</label> <select
					class="form-control" id="exampleFormControlSelect1" name="teamAId">
					<option value="">select one team</option>
					<c:forEach var="team" items="${teams}">
						<c:if test="${team.getTeamId() %2==0 }">
							<option value="${team.getTeamId()}">${team.getName()}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="exampleFormControlSelect1">Team B</label> <select
					class="form-control" id="exampleFormControlSelect1" name="teamBId">
					<option value="">select one team</option>
					<c:forEach var="team" items="${teams}">
						<c:if test="${team.getTeamId() %2 != 0}">
							<option value="${team.getTeamId()}">${team.getName()}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>


</body>
</html>