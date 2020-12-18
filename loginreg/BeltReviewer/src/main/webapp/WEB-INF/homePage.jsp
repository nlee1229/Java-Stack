<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
     

    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
</head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

<body>
	<h1>Welcome, <c:out value="${user.username}" /></h1>
	<a href="/logout">Logout</a>
	
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
		</thead>	
		<tbody>
			<c:forEach items="${events}" var="e">
				<tr>
					<td><a href="/home/showEvent/${e.id}">${e.name}</a></td>
					<td>${e.date}</td>
					<td>${e.location}</td>
					<td>${e.user.username}</td>
					<td><a href= "/home/deleteEvent/${e.id}">Delete</a> | <a href="/home/editEvent/${e.id}">Edit</a></td>
				 </tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h1>Create an event!</h1>
	<form:form action="/home/createEvent" method="post" modelAttribute = "Event">
	
	<p>Name</p>
	<form:label path="name"></form:label>
	<form:errors path="name"></form:errors>
	<form:input path="name"></form:input>
	
	<p>Date</p>
	<form:label path="date"></form:label>
	<form:errors path="date"></form:errors>
	<form:input path="date" type="date"></form:input>
	
	<p>Location</p>
	<form:label path="location"></form:label>
	<form:errors path="location"></form:errors>
	<form:input path="location"></form:input>
	
	
    <form:select path = "state">
        <form:option value ="AL">Alabama</form:option>
        <form:option value ="AK">Alaska</form:option>
        <form:option value ="AZ">Arizona</form:option>
        <form:option value ="AR">Arkansas</form:option>
        <form:option value ="CA">California</form:option>
        <form:option value ="CO">Colorado</form:option>
        <form:option value ="CT">Connecticut</form:option>
        <form:option value ="DE">Delaware</form:option>
        <form:option value ="FL">Florida</form:option>
        <form:option value ="GA">Georgia</form:option>
        <form:option value ="HI">Hawaii</form:option>
        <form:option value ="ID">Idaho</form:option>
        <form:option value ="IL">Illinois</form:option>
        <form:option value ="IN">Indiana</form:option>
        <form:option value ="IA">Iowa</form:option>
        <form:option value ="KS">Kansas</form:option>
        <form:option value ="KY">Kentucky</form:option>
		<form:option value ="LA">Louisana</form:option>
        <form:option value ="ME">Maine</form:option>
        <form:option value ="MD">Maryland</form:option>
        <form:option value ="MA">Massachusetts</form:option>
        <form:option value ="MI">Michigan</form:option>
        <form:option value ="MN">Minnesota</form:option>
        <form:option value ="MS">Mississippi</form:option>
        <form:option value ="MO">Missouri</form:option>
        <form:option value ="MT">Montana</form:option>
        <form:option value ="NE">Nebraska</form:option>
        <form:option value ="NV">Nevada</form:option>
        <form:option value ="NH">New Hampshire</form:option>
        <form:option value ="NJ">New Jersey</form:option>
        <form:option value ="NM">New Mexico</form:option>
        <form:option value ="NY">New York</form:option>
        <form:option value ="NC">North Carolina</form:option>
        <form:option value ="ND">North Dakota</form:option>
        <form:option value ="OH">Ohio</form:option>
        <form:option value ="OK">Oklahoma</form:option>
        <form:option value ="OR">Oregon</form:option>
		<form:option value ="PA">Pennsylvania</form:option>
        <form:option value ="RI">Rhode Island</form:option>
        <form:option value ="SC">South Carolina</form:option>
        <form:option value ="SD">South Dakota</form:option>
        <form:option value ="TN">Tennessee</form:option>
        <form:option value ="TX">Texas</form:option>
        <form:option value ="UT">Utah</form:option>
        <form:option value ="VT">Vermont</form:option>
        <form:option value ="VA">Virginia</form:option>
        <form:option value ="WA">Washington</form:option>
        <form:option value ="WV">West Virginia</form:option>
        <form:option value ="WI">Wisconsin</form:option>
        <form:option value ="WY">Wyoming</form:option>
    </form:select>

	
	<input type="submit" value="Create event!"/>
	
	
	
	
	
	</form:form>
	
</body>
</html>