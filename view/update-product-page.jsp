<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body>

<h2> Update Page --- ${clientid} ---- ${clientpassword} ----- ${product.productid}</h2>

<form action="update-product" method="POST" >
  <input type="hidden" id="clientid" name="clientid" value="${clientid}">
  <input type="hidden" id="clientpassword" name="clientpassword" value="${clientpassword}">
  
  <input type="hidden"  id="productid" name="productid" value="${product.productid}">
	
	<label for="productname">Product name:</label><br>
  <input  type="text" id="productname" name="productname" value="${product.productname}"><br/>
 
  <input  type="hidden" id="productowner" name="productowner" value="${product.productowner}"><br/>
  
  <label for="productversion">Product version:</label><br/>
  <input  type="number" id="productversion" name="productversion" value="${product.productversion}"><br/>
 
  <input type="submit" value="Update">
</form><br/>
<form action="client-products" method="POST">
		<input type="hidden" id="clientid" name="clientid" value="${clientid}">
		<input type="hidden" id="clientpassword" name="clientpassword" value="${clientpassword}">
		<input type="submit" value="Geri">
	</form>


</body>
</html>