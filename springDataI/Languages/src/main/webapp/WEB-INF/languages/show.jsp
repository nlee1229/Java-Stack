<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<a href="/languages">Dashboard</a>
		
		
		<p><c:out value="${langie.name}"/></p>
		
		<p><c:out value="${langie.creator}"/></p>
		
		<p><c:out value="${langie.currentVersion}"/></p>
		
		<a href="/languages/${langie.id}/edit">Edit</a>
		
		<form action="/languages/${langie.id}" method="post">
		
		    <input type="hidden" name="_method" value="delete">
		    
		    <input type="submit" value="Delete">
		
		</form>
	
	</body>

</html>
