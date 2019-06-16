<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/16/2019
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <%
         String username = "";
             String password = "";
            //获取当前站点的所有Cookie
           Cookie[] cookies = request.getCookies();
          for (int i = 0; i < cookies.length; i++) {//对cookies中的数据进行遍历，找到用户名、密码的数据
                 if ("username".equals(cookies[i].getName())) {
                      username = cookies[i].getValue();
                     } else if ("password".equals(cookies[i].getName())) {
                         password = cookies[i].getValue();
                    }
             }
         %>

    </head>
<body>
    <form action="login_handler.jsp" method="post">
            username:<input type="text" name="name" value="<%=username%>" /><br/>
            password:<input type="password" name="pwd" value="<%=password%>" /><br/>
            <input type="checkbox" value="y" name="isLogin">自动登录<br/>
            <input type="submit" value="登录" />
         </form>
 </body>
</html>
