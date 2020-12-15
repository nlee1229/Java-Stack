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

	<h1>Create a ninja</h1>
	
	<form:form action="/createNinja" method="POST" modelAttribute="ninja">
	
		<div class="mb-3">
			<p>Dojo:</p>
			<form:label class="form-label" path="dojo"></form:label>
			<form:select class="form-select form-select-lg mb-3" path="dojo">
				<option value="" disabled selected>Select a team!</option>
				<c:forEach items="${dojos}" var="d">
					<form:option value="${d}">
						<c:out value="${d.name}"></c:out>
					</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="dojo"></form:errors>
		</div>
	

			<p>First Name:</p>
			<form:label class="form-label" path="firstName"></form:label>
			<form:input class="form-select" path="firstName"></form:input>
			<form:errors path="firstName"></form:errors>

		
			<p>Last Name:</p>
			<form:label class="form-label" path="lastName"></form:label>
			<form:input class="form-select" path="lastName"></form:input>
			<form:errors path="lastName"></form:errors>
	
			<p>Age:</p>
			<form:label class="form-label" path="age"></form:label>
			<form:input class="form-select" path="age"></form:input>
			<form:errors path="age"></form:errors>

		
		
			
			<button class="bnt btn-dark" type="submit">Create</button>
		
	</form:form>
</body>
</html>