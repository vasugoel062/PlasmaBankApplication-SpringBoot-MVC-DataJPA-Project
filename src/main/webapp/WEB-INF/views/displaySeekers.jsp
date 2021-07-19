<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Seeker Details :</h1>
	<table border="1">
		<tr>
			<th>Seeker ID</th>
			<th>Seeker Name</th>
			<th>Blood Group for which Plasma Required</th>
			<th>Required Plasma Units</th>
			<th>Seeker seeking Date(yyyy/MM/dd)</th>
			<th>Seeker State</th>
			<th>Seeker City</th>
			<th>Seeker Contact Number</th>
		</tr>
		<c:forEach items="${seekersList}" var="seeker">
			<tr>
				<td>${seeker.seekerId}</td>
				<td>${seeker.seekerName }</td>
				<td>${seeker.bloodGroup }</td>
				<td>${seeker.quantity }</td>
				<td>${seeker.seekingDate }</td>
				<td>${seeker.state }</td>
				<td>${seeker.city }</td>
				<td>${seeker.contactNo }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<a href="./">Go to Main Page</a>
</body>
</html>