<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
	.td td{
		width: 100px;
	}
	.table{
		text-align: center;
		margin: 0 auto;
	}
</style>
</head>
<body>

 
	<table class="table">
		<tr class="td">
			<td>ID</td>
			<td>用户名</td>
			<td>密码</td>
			<td style="width: 200px">公司</td>
			<td>年龄</td>
			<td>性别</td>
		</tr>
<c:forEach var="user" items="${var}" varStatus="status">
  <c:choose>
	<c:when test="${var!=null }">
		<tr class="td">
			<td>${user.id }</td>
			<td>${user.username }</td>
			<td>${user.password }</td>
			<td>${user.company }</td>
			<td>${user.age }</td>
			<td>${user.sex }</td>
		</tr>
	</c:when>
	<c:otherwise>
		<tr class="td">
			<td style="color: red;">暂无相关数据</td>
		</tr>
	</c:otherwise>
  </c:choose>
</c:forEach>
</table>

</body>
</html>