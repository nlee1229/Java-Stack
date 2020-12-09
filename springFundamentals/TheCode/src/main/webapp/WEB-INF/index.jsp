<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
	
<html>
	
	<head>
		<meta charset="UTF-8">
		<title>The Bushido Code</title>
	</head>
	
	<body>
		<p><c:out value="${error}"/></p>
		
		<h3>What is the code?</h3>
		<form method="POST" action="/checkPass">
		    <input type="password" name="password" placeholder="Enter password...">
		    <button>Try Code</button>
		</form>
		
		
			
	</body>
	
</html>