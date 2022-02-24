<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client Menu</title>
</head>
<body>
	<p>${clientid}</p>
	<p>${clientpassword}</p>
	<br />
	<br />
	    
<form action="all-products" method="POST" >
  <label >Shows all products:</label><br>
  <input type="hidden" id="clientid" name="clientid" value="${clientid}">
  <input type="hidden" id="clientpassword" name="clientpassword" value="${clientpassword}">
  <input type="submit" value="A-P">
</form><br/>

<form action="client-products" method="POST" >
  <label >Shows client products:</label><br>
  <input type="hidden" id="clientid" name="clientid" value="${clientid}">
  <input type="hidden" id="clientpassword" name="clientpassword" value="${clientpassword}">
  <input type="submit" value="C-P">
</form>


</body>
</html>