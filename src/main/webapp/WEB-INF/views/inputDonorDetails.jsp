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
<spring:form action="./donorRegister">
	Enter Your Name : <spring:input path="name"/><br><br>
	Enter Your Blood Group : <spring:input path="bloodgroup"/><br><br>
	Enter Your Age : <spring:input path="age"/><br><br>
	Enter Your Contact Number : <spring:input path="contactNo" type="number"/><br><br>
	Enter the Units of Plasma willing to Donate (1 Unit = 200 ML) : <spring:input path="units"/><br><br>
	Enter Your State : <spring:input path="state"/><br><br>
	Enter Your City : <spring:input path="city"/><br><br>
	<input type="submit" value="Save">
</spring:form>
<br><br>
<a href="./">Go to Main Page</a>
</body>
</html>