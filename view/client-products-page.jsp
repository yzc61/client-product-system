<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client Products</title>
</head>
<body>

	<h2>List of Clients Products</h2>
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
		<c:forEach var="listofcp" items="${listofcp}">
			<tr>
				<td>${listofcp.productid}</td>
				<td>${listofcp.productname}</td>
				<td>${listofcp.productowner}</td>
				<td>${listofcp.productversion}</td>
				<td><form action="update-product-info" method="POST">
					<input type="hidden" id="clientid" name="clientid" value="${clientid}">
					<input type="hidden" id="clientpassword" name="clientpassword"value="${clientpassword}"> 
					<input type="hidden" id="productid" name="productid" value="${listofcp.productid}">	
						 <input type="submit" value="Update">
				</form></td>
				<td><form action="delete-product" method="POST">
					<input type="hidden" id="clientid" name="clientid" value="${clientid}">
					<input type="hidden" id="clientpassword" name="clientpassword"value="${clientpassword}"> 
					<input type="hidden" id="productid" name="productid" value="${listofcp.productid}">	
						 <input type="submit" value="Delete">
				</form></td>
			</tr>
		</c:forEach>

	</table><br/>
		<form action="add-product-page" method="POST">
		<input type="hidden" id="clientid" name="clientid" value="${clientid}">
		<input type="hidden" id="clientpassword" name="clientpassword"value="${clientpassword}"> 
		<input type="submit" value="Add">
	</form><br/>
	<form action="client-main" method="POST">
		<input type="hidden" id="clientid" name="clientid" value="${clientid}">
		<input type="hidden" id="clientpassword" name="clientpassword"value="${clientpassword}"> 
		<input type="submit" value="Geri">
	</form>

</body>
</html>