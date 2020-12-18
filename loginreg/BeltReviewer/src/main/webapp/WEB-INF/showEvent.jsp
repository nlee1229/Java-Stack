<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
     

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event details page</title>
</head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<body>

	<h1>${event.name}</h1>
	<p>${unicorns}</p>
	
	<h5>Host: <c:out value="${event.user.username}"/></h5>
	<h5>Date: <c:out value="${event.date}"/></h5>
	<h5>Location: <c:out value="${event.location}, ${event.state}"/></h5>
	
	
	<h1>Message Wall:</h1>
	
	<table class="table table-striped table-hover">
	<c:forEach items="${message}" var="m">
		<tr>
			<td>${m.user.username}: ${m.comment}</td>
		</tr>
	</c:forEach>
	</table>
	
	<form:form action="/createComment/${event.id}" method="post" modelAttribute="Message">
	<form:hidden path="event" value="${event.id}"></form:hidden>
	<form:errors path="comment"></form:errors>
	<form:input path="comment"></form:input>
	<!-- <input type="submit" value="Add Comment!"/> -->
	<button class="btn btn-primary" type="submit">Add Comment!</button>
	</form:form>
	
	<a href="/logout">Logout</a>

</body>
</html>