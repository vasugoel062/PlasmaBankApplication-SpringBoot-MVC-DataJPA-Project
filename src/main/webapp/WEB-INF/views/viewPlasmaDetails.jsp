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
<h1>Plasma Details :</h1>
	<table border="1">
		<tr>
			<th>Blood Group</th>
			<th>Plasma Units</th>
		</tr>
		<c:forEach items="${viewHospitalPlasma}" var="plasma">
			<tr>
				<td>${plasma.bloodGroup}</td>
				<td>${plasma.units }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<a href="./">Go to Main Page</a>
</body>
</html>