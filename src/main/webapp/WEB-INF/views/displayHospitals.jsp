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

	<h1>Hospital Details :</h1>
	<table border="1">
		<tr>
			<th>Hospital ID</th>
			<th>Hospital Name</th>
			<th>Hospital Type</th>
			<th>Hospital Address</th>
			<th>Hospital State</th>
			<th>Hospital City</th>
			<th>Hospital E-Mail</th>
			<th>Hospital Contact Number</th>
			<th>Plasma Details</th>
		</tr>
		<c:forEach items="${HospitalsList}" var="hospital">
			<tr>
				<td>${hospital.hospitalID}</td>
				<td>${hospital.hName }</td>
				<td>${hospital.hType }</td>
				<td>${hospital.hAddress }</td>
				<td>${hospital.hLocation }</td>
				<td>${hospital.hCity }</td>
				<td>${hospital.hEmail }</td>
				<td>${hospital.hContactno }</td>
				<c:if test="${empty hospital.hPlasmaList}">
					<td>Not Available</td>
				</c:if>
				<c:if test="${not empty hospital.hPlasmaList}">
					<td><a href="./viewPlasmaDetails?Id=${hospital.hospitalID}">Click
							Here</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<a href="./">Go to Main Page</a>
</body>
</html>





