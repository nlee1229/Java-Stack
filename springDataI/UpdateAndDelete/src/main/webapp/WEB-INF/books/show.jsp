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
		
		<h1><c:out value="${bookie.title}"/></h1>
		
		<p>Description: <c:out value="${bookie.description}"/></p>
		
		<p>Language: <c:out value="${bookie.language}"/></p>
		
		<p>Number of pages: <c:out value="${bookie.numberOfPages}"/></p>
		
		<a href="/books/${bookie.id}/edit">Edit Book</a>
		
		<form action="/books/${bookie.id}" method="post">
		
		    <input type="hidden" name="_method" value="delete">
		    
		    <input type="submit" value="Delete">
		
		</form>
	
	</body>

</html>
