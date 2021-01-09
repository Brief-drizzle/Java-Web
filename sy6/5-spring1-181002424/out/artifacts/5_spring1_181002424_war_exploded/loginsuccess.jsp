<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/11/24
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginsuccess</title>
</head>
<body>
<p align="center">
<div style="text-align: center;">
    <H1><span style="color: red; ">登录成功</span></H1>
</div>
<%--补一个bean显示--%>
<H1><font color="REd">登陆成功，您的详细注册信息如下</font></H1>
<jsp:useBean id="infobean" class="userpojo.Usertable" scope="session"/>
<p>您的用户名是：
<jsp:getProperty name="infobean" property="username"/>
<p>您的邮箱是：
<jsp:getProperty name="infobean" property="email"/>
<p>您的电话是：
<jsp:getProperty name="infobean" property="phonenumber"/>
</body>
</html>
