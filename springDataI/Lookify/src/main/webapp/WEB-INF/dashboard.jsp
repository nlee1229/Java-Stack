<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Dashboard</h1>
		<a href="/songs/new">Add Song</a>
		
		<a href="/search/topTen">Top Songs</a>
	
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
				<c:forEach items="${allSongs}" var="song">
					<tr>
						<td><a href = "/songs/${song.id}">${song.title}</a></td>
						<td>${song.rating}</td>
						<td><a href="/songs/${song.id}/delete">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>