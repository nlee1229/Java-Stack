<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      

<!DOCTYPE html>

<html>
	
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
	</head>
	
	<body>

		<h1>All Languages</h1>
		<table>
		    <thead>
		        <tr>
		            <th>Name</th>
		            <th>Creator</th>
		            <th>Version</th>
		            <th>action</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${languages}" var="language">
		        <tr>
		            <td><a href = "/languages/${language.id}">${language.name}</a></td>
		            <td><c:out value="${language.creator}"/></td>
		            <td><c:out value="${language.currentVersion}"/></td>
		            <td><a href="languages/${language.id}/edit">Edit</a>|
		     		<form:form action="/languages/${language.id}" method="post">
		     		<input type="hidden" name="_method" value="delete">
		  			<input type="submit" value="Delete">
		     		</form:form></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		
		<form:form action="/languages" method="post" modelAttribute="Language">
		
		    <input type="hidden" name="_method" value="post">
		    
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
