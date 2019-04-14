<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<body>
<h2>Hello World!</h2>
	<h1>欢迎进首页</h1>
	<br>
	<form action="<%=request.getContextPath() %>/user/list" method="get">
		

		<br>
		<br>
		<input type="submit">
	</form>
</body>
</html>
