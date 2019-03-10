<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>How do you do!</h1>
	<c:forEach var="user" items="${var}" varStatus="status">
		<div>${user.id }</div>
		<div>${user.username }</div>
		<div>${user.password }</div>
		<div></div>
		<div></div>
	</c:forEach>
</body>
</html>