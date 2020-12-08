<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
	
<html>
	
	<head>
		<meta charset="UTF-8">
		<title>Display Date</title>
		<script src="/js/date.js"></script>
		<link rel="stylesheet" href="/css/date.css">
	</head>
	
	<body>
		
		
		<h1>Display Date: </h1>
		
		<h2><c:out value="${date}"/></h2>
		
		
	</body>
	
</html>