<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/4/16
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">

        <li><a href="<%=request.getContextPath()%>/admin/showCourse">课程管理<span class="badge pull-right">1</span></a></li>
        <li><a href="<%=request.getContextPath()%>/admin/showStudent">学生管理<span class="badge pull-right"><c:out value="${studentNumber}"/></span></a></li>
        <li><a href="<%=request.getContextPath()%>/admin/showTeacher">教师管理<span class="badge pull-right"><c:out value="${teacherNumber}"/></span></a></li>
        <li><a href="<%=request.getContextPath()%>/admin/userPasswordRest">账号密码重置<sapn class="glyphicon glyphicon-repeat pull-right" /></a></li>
        <li><a href="<%=request.getContextPath()%>/admin/passwordRest">修改密码<sapn class="glyphicon glyphicon-pencil pull-right" /></a></li>
        <li><a href="<%=request.getContextPath()%>/logout">退出系统<sapn class="glyphicon glyphicon-log-out pull-right" /></a></li>
        <li class="disabled"><a href="##">Responsive</a></li>
    </ul>
</div>
</body>
</html>
