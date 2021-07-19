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
<spring:form action="./seekerRegister">
	Enter Your Name : <spring:input path="seekerName"/><br><br>
	Enter Your Blood Group : <spring:input path="bloodGroup"/><br><br>
	Enter the Units of Plasma Required (1 Unit = 200 ML) : <spring:input path="quantity"/><br><br>
	Enter The Required Date (yyyy/MM/dd) : <spring:input path="seekingDate"/><br><br>
	Enter Your State : <spring:input path="state"/><br><br>
	Enter Your City : <spring:input path="city"/><br><br>
	Enter Your Contact Number : <spring:input path="contactNo" type="contactNo"/><br><br>
	<input type="submit" value="Save">
</spring:form>
<br><br>
<a href="./">Go to Main Page</a>
</body>
</html>
