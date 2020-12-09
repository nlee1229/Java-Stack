<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
	
<html>
	
	<head>
		<meta charset="UTF-8">
		<title>Dojo Survey Index 1</title>
	</head>
	
	<body>
		<form action="/submit" method="POST">
			<label for="name">Your Name:</label>
			<!-- the "name" has to match the parameter name in method -->
			<input type="text" name="name" placeholder="Enter Name...">
			<br>
			<label for="">Dojo Location:</label>
			<select name="dojo">
				<option value="San Jose">San Jose</option>
				<option value="Irvine">Irvine</option>
				<option value="Burbank">Burbank</option>
				<option value="Seattle">Seattle</option>
			</select>
			<br>
			<label for="">Favorite Language:</label>
			<select name="lang">
				<option value="Python">Python</option>
				<option value="HTML">HTML</option>
				<option value="JavaScript">JavaScript</option>
				<option value="Java">Java</option>
				<option value="React">React</option>
			</select>
			<br>
			<label for="">Comment (optional):</label>
			<textarea name="comm" rows="6" cols="40"></textarea>
	
			<br>
			<button type ="submit">Button</button>
		</form>
		
			
	</body>
	
</html>