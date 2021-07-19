<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Please Enter the Following Details :</h1>
<spring:form action="./hospitalRegister">
	Enter Hospital Name : <spring:input path="hName"/><br><br>
	Enter Hospital Type (Private/Government) : <spring:input path="hType"/><br><br>
	Enter Hospital Address : <spring:input path="hAddress"/><br><br>
	Enter Hospital State : <spring:input path="hLocation"/><br><br>
	Enter Hospital City : <spring:input path="hCity"/><br><br>
	Enter Hospital E-Mail : <spring:input path="hEmail"/><br><br>
	Enter Hospital Contact Number : <spring:input path="hContactno"/><br><br>
	<input type="submit" value="Save">
</spring:form>
<br><br>
<a href="./">Go to Main Page</a>
</body>
</html>