<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<!-- allow us to render this view on a PUT request -->
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>

<html>
	
	<head>
		<meta charset="UTF-8">
		<title>Edit</title>
	</head>
	
	<body>

		<h1>Edit Language</h1>
			<a href="/languages">Dashboard</a>
		
		<form action="/languages/${language.id}" method="post">
		     		<input type="hidden" name="_method" value="delete">
		  			<input type="submit" value="Delete">
		</form>
		     		
		<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
		
		<!--     <input type="hidden" name="_method" value="post"> -->
		    
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator"/>
		        <form:textarea path="creator"/>
		    </p>
		    <p>
		        <form:label path="currentVersion">Version</form:label>
		        <form:errors path="currentVersion"/>
		        <form:input path="currentVersion"/>
		    </p>
		   
		    <input type="submit" value="Submit"/>
		</form:form>
	</body>
	
</html>
