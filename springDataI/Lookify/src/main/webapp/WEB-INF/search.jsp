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
	<div class="container">
	<h1>Your Results</h1>
	
	<a href="/dashboard">Dashboard</a>
	
	<h2>
		Songs by artists: <c:out value= "${songs.artist }" />
	</h2>
	
	<form action="/search" method="get">
			<input type="text"  name="search" id=""/>
			<button type="submit">Search Artists</button>
		</form>

	
	<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song">
					<tr>
						<td>
							<c:out value="${song.title}" />
							
						</td>
						<td>
							<c:out value="${song.rating}" />
						</td>
						<td>
							<a href="/songs/${song.id}/delete">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>