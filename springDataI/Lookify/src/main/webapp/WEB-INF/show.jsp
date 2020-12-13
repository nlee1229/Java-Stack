<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="/dashboard">Dashboard</a>

	<div class="container">
		<h1>Show Page for Song</h1>
		<h3>
			Title: <c:out value="${song.title }" />
		</h3>
		<h3>
			Artist: <c:out value="${song.artist }" />
		</h3>
		<h3>
			Rating: <c:out value="${song.rating }" />
		</h3>
		
		<a href="/songs/${song.id}/delete">Delete</a>	
	</div>



</body>
</html>