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
<h1>Please Enter the Following Details for Available Plasma Storage :</h1>
<spring:form action="./inputHospital_PlasmaStorageDetails" modelAttribute="hospital_Plasma">
	Enter the Blood Group : <spring:input path="bloodGroup"/><br><br>
	Enter the Units : <spring:input path="units"/><br><br>
	<input type="submit" value="Add More" name="operation">
	<input type="submit" value="Save" name="operation">
</spring:form>
<br><br>
<a href="./">Go to Main Page</a>
</body>
</html>
