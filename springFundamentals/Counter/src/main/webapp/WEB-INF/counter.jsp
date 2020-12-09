<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
	
<html>
	
	<head>
		<meta charset="UTF-8">
		<title>Counter</title>
	</head>
	
	<body>
		<!-- Takes user back to homepage -->
		<h1>You have visited<a href = "/your_server/">homepage</a><c:out value="${count}"/></h1>
		<h1>Test another visit?<a href = "/your_server/">welcome</a></h1>
	</body>
	
</html>