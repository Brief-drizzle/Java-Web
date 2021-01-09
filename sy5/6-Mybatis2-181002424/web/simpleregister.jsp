<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/11/11
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
<head>
    <title>注册</title>
</head>
<p>
<p align="center">
<div style="text-align: center;">
<H1><span style="color: black; ">请注册</span></H1></p>

<form method="post" action="GetSimpleRegister">
    <p align="center">
        用户名：
        <input type="text" name="username"></p>

    <p align="center">
        密码：
        <input type="password" name="pwd"></p>

    <p align="center">
        <input type="submit" name="register" value="注册"></p>
    </form>
</div>
</html>
