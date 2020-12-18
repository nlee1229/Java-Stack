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

<h1>Create a dojo!</h1>
	<form:form action="/home/editDojo/${dojo.id}" method="post" modelAttribute = "Dojo">
	
	<p>Location</p>
	<form:label path="location"></form:label>
	<form:errors path="location"></form:errors>
	<form:input path="location"></form:input>
	
	<p>Review</p>
	<form:label path="review"></form:label>
	<form:errors path="review"></form:errors>
	<form:input path="review"></form:input>
	
	<p>Date</p>
	<form:label path="date"></form:label>
	<form:errors path="date"></form:errors>
	<form:input path="date" type="date"></form:input>
	
	<p>Rating</p>
	<form:label path="rating"></form:label>
	<form:errors path="rating"></form:errors>
	<form:input path="rating"></form:input>
	
	
	<input type="submit" value="Edit dojo!"/>
	
	</form:form>
</body>
</html>