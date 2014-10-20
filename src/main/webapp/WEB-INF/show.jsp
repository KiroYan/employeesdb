<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/style.css" type="text/css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>XML</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<h2>
				<a href="shop.do?action=categories">Shop</a>
			</h2>
		</div>
		<div id="content">
			<h2>Add product</h2>
			<c:forEach items="${employees}" var="employee">
				<div>${employee.toString()}</div>
			</c:forEach>
		</div>
	</div>

</body>
</html>