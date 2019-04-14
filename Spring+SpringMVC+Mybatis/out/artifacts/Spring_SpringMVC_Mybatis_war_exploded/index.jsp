<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>查询用户</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/queryById.do" method="get">
		输入要查询的id:	<input type="text" name="id" value="1"/>
		<button type="submit">提交</button>
	</form>
</body>
</html>