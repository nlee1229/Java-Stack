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

	<a href="/addDojo">Add New Dojo!</a> | <a href="/addNinja">Add New Ninja!</a>
	
	<h3>Dojo Names:</h3>
	
	<c:forEach items="${dojo}" var="d">
		
	<h3><c:out value="${d.name}"></c:out></h3>	
	
	<a href="/editDojo/${d.id}">Edit</a>
	<a href="/deleteDojo/${d.id}">Delete</a>
	
	
		<c:forEach items="${d.ninjas}" var="n">
		<p><c:out value="${n.firstName} ${n.lastName}"></c:out></p>	
		<a href="/editNinja/${n.id}">Edit</a>

	</c:forEach>
	</c:forEach>
	

</body>
</html>