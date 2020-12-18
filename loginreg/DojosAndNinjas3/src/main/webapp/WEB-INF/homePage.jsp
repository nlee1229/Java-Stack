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
<body>
	<h1>Welcome, <c:out value="${ninja.firstName}" /></h1>
	<a href="/logout">Logout</a>
	
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>Location</th>
				<th>Review</th>
				<th>Date</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>	
		<tbody>
			<c:forEach items="${dojos}" var="d">
				<tr>
					<td><a href="/home/showDojos/${d.id}">${d.firstName}</a></td>
					<td>${d.location}</td>
					<td>${d.review}</td>
					<td>${d.date}</td>
					<td>${d.rating}</td>
					<td><a href= "/home/deleteDojo/${d.id}">Delete</a><%--  | <a href="/home/editEvent/${e.id}">Edit</a> --%></td> 
				 </tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h1>Create a dojo!</h1>
	<form:form action="/home/createDojo" method="post" modelAttribute = "Dojo">
	
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
	
	
	<input type="submit" value="Create dojo!"/>
	
	
	
	
	
	</form:form>
</body>
</html>