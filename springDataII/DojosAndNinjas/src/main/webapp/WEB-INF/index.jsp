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

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<body>

	<h1>New Dojo</h1>
	
	<a href="/createDojo">Create a new Dojo</a> | <a href="/createNinja">Create a new Ninja</a>
	
	<hr>
	
	<c:forEach items="${dojos}" var="dojo">
		<h3><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"></c:out></a></h3>
		<!-- ninjas is coming from dojo.java models from the relationship -->
		<c:forEach items="${dojo.ninjas}" var="nin">
			<p><c:out value="${nin.firstName}"></c:out></p>
		</c:forEach>
	</c:forEach>
</body>
</html>






