<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
</head>

<body>

<form action="client-main" method="POST" >
  <label for="clientid">Client id:</label><br/>
  <input type="number" id="clientid" name="clientid"><br/>
  <label for="clientpassword">Client password:</label><br/>
  <input type="text" id="clientpassword" name="clientpassword"><br/>
  <input type="submit" value="Giris">
</form>



</body>
</html>