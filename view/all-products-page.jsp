<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Products</title>
</head>
<body>

	<h2>List of all products</h2>
	<p>${clientid}</p>
	<p>${clientpassword}</p>
	
	<table border="1">
	<thead>
	<tr>
		<td>id</td>
		<td>name</td>
		<td>owner</td>
		<td>version</td>
	
		
	</tr>
	</thead>
	<c:forEach var="listofap" items="${listofap}">
	<tr>	
		<td>${listofap.productid}</td> 
		<td>${listofap.productname}</td>
		<td>${listofap.productowner}</td>
		<td>${listofap.productversion}</td>
	</tr>	
	</c:forEach>
	
</table><br/>
	<form action="client-main" method="POST">
		<input type="hidden" id="clientid" name="clientid" value="${clientid}">
		<input type="hidden" id="clientpassword" name="clientpassword" value="${clientpassword}">
		<input type="submit" value="Geri">
	</form>

</body>
</html>