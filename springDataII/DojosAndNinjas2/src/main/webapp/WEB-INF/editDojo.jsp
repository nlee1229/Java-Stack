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

<h2>Edit dojo!</h2>
	<form:form action="/editDojo/{id}" method="post" modelAttribute = "dojo">
		<form:errors path="name"></form:errors>
		<form:input path="name" value="${dojo.name}"/>
		<input type="submit" value="Submit!"/>
	
	</form:form>

	
</body>
</html>