<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 5/9/2019
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link rel="stylesheet" href="<%=basePath%>/lib/bootstrap.min.css">
    <title>Home</title>
  </head>
  <body>
    <h2>SSH</h2>
    <form action="<%=basePath%>/admin_adminLogin.do" method="post" class="form-inline text-center">
      <label>username:</label>
      <input type="text" class="form-control" name="adminname">
      <br/>
      <br/>
      <label>password:</label>
      <input type="password" class="form-control" name="password">
      <br/>
      <br/>
      <input type="submit" value="登录" class="btn btn-default">
    </form>
  </body>
</html>
