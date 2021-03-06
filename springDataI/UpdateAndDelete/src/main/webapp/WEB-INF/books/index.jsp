<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>

<html>
	
	<head>
		<meta charset="UTF-8">
		<title>Dashboard</title>
	</head>
	
	<body>

		<h1>All Books</h1>
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
		            <td><c:out value="${language.name}"/></td>
		            <td><c:out value="${language.creator}"/></td>
		            <td><c:out value="${language.currentVersion}"/></td>
		            <td><a href="languages/${language.id}/edit">Edit</a>|<a href="languages/${language.id}/delete"></a>Delete</td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		
		<form:form action="/languages/${language.id}/edit" method="post" modelAttribute="language">
		
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
