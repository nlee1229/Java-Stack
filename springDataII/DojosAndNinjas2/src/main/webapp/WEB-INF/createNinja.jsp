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
	<h2>Add a ninja!</h2>
	<form:form action="/addNinja" method="post" modelAttribute = "Ninja">
	
		<p>First Name</p>
		<form:label path="firstName"></form:label>
		<form:errors path="firstName"></form:errors>
		<form:input path="firstName"/>
		
	<div>
		<p>Last Name</p>
		<form:label path="lastName"></form:label>
		<form:errors path="lastName"></form:errors>
		<form:input path="lastName"/>
	</div>
		
	<div>
		<p>Age</p>
		<form:label path="age"></form:label>
		<form:errors path="age"></form:errors>
		<form:input path="age"/>
	</div>
	
	
	<form:select path="dojo">
		<option value="" disabled selected>Select a dojo!</option>
<%-- 		${dojos} is coming in from the model attribute key --%>
		<c:forEach items="${dojos}" var="d">
			<form:option value="${d}">
				<c:out value="${d.name}"></c:out>
			</form:option>
		</c:forEach>
	</form:select>
	
	<input type="submit" value="Add!"/>	

	</form:form>
	
		
	


</body>
</html>