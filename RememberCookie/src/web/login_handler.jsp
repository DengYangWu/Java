<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/16/2019
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String name = request.getParameter("name");
    String pwd = request.getParameter("pwd");
    String flag = request.getParameter("isLogin");

    if (!"admin".equals(name) && !"123".equals(pwd)) {
        response.sendRedirect("error.jsp");
    } else {
        if ("y".equals(flag)) {
            //创建两个Cookie对象
            Cookie nameCookie = new Cookie("username", name);
            //设置Cookie的有效期为3天
            nameCookie.setMaxAge(60 * 60 * 24 * 3);
            Cookie pwdCookie = new Cookie("password", pwd);
            pwdCookie.setMaxAge(60 * 60 * 24 * 3);
            response.addCookie(nameCookie);
            response.addCookie(pwdCookie);
        }
        response.sendRedirect("success.jsp");
    }
%>
