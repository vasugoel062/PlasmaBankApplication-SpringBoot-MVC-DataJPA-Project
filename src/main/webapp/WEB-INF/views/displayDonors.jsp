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
	<h1>Donor Details : </h1>
	<table border="1">
		<tr>
			<th>Donor ID</th>
			<th>Donor Name</th>
			<th>Donor Blood Group</th>
			<th>Donor Age</th>
			<th>Plasma units Donor willing to Donate</th>
			<th>Donor State</th>
			<th>Donor City</th>
			<th>Donor Contact Number</th>
		</tr>
		<c:forEach items="${DonorsList}" var="donor">
			<tr>
				<td>${donor.donorId }</td>
				<td>${donor.name }</td>
				<td>${donor.bloodgroup }</td>
				<td>${donor.age }</td>
				<td>${donor.units }</td>
				<td>${donor.state }</td>
				<td>${donor.city }</td>
				<td>${donor.contactNo }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<a href="./">Go to Main Page</a>
</body>
</html>