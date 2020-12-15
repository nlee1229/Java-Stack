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

	
		<h1>Create a Dojo</h1>
		
		<form:form action="/createDojo" method="POST" modelAttribute="dojo">
		
				<p>Name:</p>
				<form:label path="name"></form:label>
				<form:input path="name"></form:input>
				<form:errors path="name"></form:errors>

			<p>
				<input type="submit" value="Create" />
			</p>
		
		
		</form:form>
	
	

</body>
</html>