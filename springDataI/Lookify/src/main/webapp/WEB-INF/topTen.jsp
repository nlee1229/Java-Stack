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

	<a href="/dashboard">Dashboard</a>
	
	<h2>Top Ten Songs:</h2>
	
	<div>
		<table>
			<tbody>
				<c:forEach items="${topSongs}" var="song">
				
				<tr>
					<td>${song.rating} - <a href="/songs/${song.id}">${song.title}</a> - ${song.artist} </td>
				</tr>
			
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>