<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/style.css" type="text/css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<h2>Employees</h2>
		</div>
		<div id="content">
			<c:forEach items="${employees}" var="employee">
				<b><label for="name">Name:</label></b>
				<div>${employee.firstName}${employee.lastName}</div>
				<b><label for="address">Address:</label></b>
				<div>${employee.address}</div>
				<b><label for="offices">Offices:</label></b>
				<div>
					<c:forEach var="officePosition" items="${employee.officePositions}">
						<c:set var="id" value="${officePosition.office.id}" />
						<label for="comapany">Company:</label>
						<c:out value="${officePosition.office.company}" />
						|<c:out value="${officePosition.office.address}" />|
						<c:out value="${officePosition.position}" />
						| Number of Employees in office
						<c:out value="${EmployeesInOffice[id]}" />
						<br>
					</c:forEach>
				</div>
				<br>
			</c:forEach>
			<div>
				<c:if test="${page > 1}">
					<a href="employees?page=${page-1}">previous page</a> | 
				</c:if>
				<c:if test="${isNextPage}">
					<a href="employees?page=${page+1}">next page</a>
				</c:if>
			</div>
		</div>
	</div>

</body>
</html>