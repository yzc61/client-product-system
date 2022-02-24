<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Page</title>
</head>
<body>

<form action="add-product" method="POST" >
 
  <input type="hidden" id="clientid" name="clientid" value="${clientid}">
  <input type="hidden" id="clientpassword" name="clientpassword" value="${clientpassword}">
  	
  <label for="productname">Product name:</label><br/>
  <input  type="text" id="productname" name="productname" ><br/>
 
  <input  type="hidden" id="productowner" name="productowner" value="${clientname}"><br/>
  
  <label for="productversion">Product version:</label><br/>
  <input  type="number" id="productversion" name="productversion" ><br/>
 
  <input type="submit" value="Add">
</form><br/>
		<form action="client-products" method="POST">
		<input type="hidden" id="clientid" name="clientid" value="${clientid}">
		<input type="hidden" id="clientpassword" name="clientpassword" value="${clientpassword}">
		<input type="submit" value="Geri">
	</form>
</body>
</html>