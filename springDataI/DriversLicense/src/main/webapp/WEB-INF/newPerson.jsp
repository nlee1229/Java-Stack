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
	<div class="container">
	<h1>New Person</h1>
	
 	<form:form action="/persons/new" method="post" modelAttribute="personObj"> 
	 	<p>
	 		First Name: 
	 		<form:input type="text" path="firstName" />
	 		<form:errors path="firstName" />
	 	</p>
 		<p>
	 		Last Name: 
	 		<form:input type="text" path="lastName" />
	 		<form:errors path="lastName" />
 		</p>
		
	
	
	
	
		<button type="submit">Create</button>
	
	</form:form>
	</div>

</body>
</html>