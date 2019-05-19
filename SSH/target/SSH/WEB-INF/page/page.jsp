<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 5/14/2019
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/lib/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
<!-- 导航栏 -->
<div class="sidebar text-left">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand">SSH整合</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/customer_toSavePage.do"><strong>添加信息功能</strong></a></li>
                    <li><a href="<%=request.getContextPath()%>/customer_findByPage.do"><strong>分页查询功能</strong></a></li>
                    <li><a>Create by TyCoding</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
</body>
</html>
