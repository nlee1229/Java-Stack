<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Info Page</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>

<body>

	<div class="container">
	
		<h1><c:out value="${person.firstName}" /> <c:out value="${person.lastName}" /></h1>
		
		<h5>License Number</h5>
		
		<h5>State: <c:out value="${person.license.state}" /> </h5>
		
		<h5>Expiration Date: <c:out value="${person.license.expirationDate}" />  </h5>

	</div>
	
</body>
</html>