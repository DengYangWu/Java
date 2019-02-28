<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta charset="utf-8">
<title>查询用户</title>
</head>
<body>
	<form action="../queryById.do" method="post">
		输入要查询的id:	<input type="text" name="id" value="1"/>
		<button type="submit">提交</button>
	</form>
</body>
</html>