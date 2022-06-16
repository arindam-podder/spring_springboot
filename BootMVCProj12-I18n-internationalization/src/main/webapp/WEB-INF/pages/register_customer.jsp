<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp" %>

<style>
	
	.container{
		margin : 40px;
		padding: 30px;
	}
	
</style>   
    
    
<div class="container">

	<h2> <sp:message code="customer.register.title"></sp:message> </h2>
	<form action="./">
		<div class="input">
			<sp:message code="customer.register.name" /> : <input name="name" type="text">
		</div>
		<div class="input">
			<sp:message code="customer.register.address" /> : <input name="address" type="text" >
		</div>
		<div class="input">
			<sp:message code="customer.register.billamount" /> : <input name="billAmount" type="number">
		</div>
		<input type="submit" value=' <sp:message code="customer.register.register"/> '>
	</form>
	
</div>