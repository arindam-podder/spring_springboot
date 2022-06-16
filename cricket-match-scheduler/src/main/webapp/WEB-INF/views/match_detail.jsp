<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	font-family: serif;
	
}
h1 {
	margin: 30px 20px 30px 20px;
	color: white;
}
div{
	margin-top : 15%;
	border: 1px solid grey;
	border-radius: 20px;
	background: grey;

}
</style>

</head>
<body>

	<div class="container">
	<h1>${teamACaptain}'s Team vs ${teamBCaptain}'s Team match scheduled on
		${date} </h1>
	</div>
</body>
</html>



