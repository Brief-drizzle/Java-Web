<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/11/11
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改注册信息</title>
</head>
<body><div style="text-align: center;">
<jsp:useBean id="readdetailedinfobean" class="pojo.Detailedinfotable" scope="session" />
<p align="center">
<H1><span style="color: REd; ">您的注册信息如下</span></H1>
<form action="GetModify" method="post">
    <p align="center">
    用户名：
    <input type="text" name="username" value='<jsp:getProperty name="readdetailedinfobean" property="username" />'/><br>
    <p align="center">
    年龄：
    <input type="text" name="age" value='<jsp:getProperty name="readdetailedinfobean" property="age" />'/><br>
    <p align="center">
    性别：
    <input type="radio" name="sexy" value=male checked> 男
    <input type="radio" name="sexy" value=female> 女</p>
    <p align="center">
    照片存储在服务器上的位置:
    <input type="file" name="pictureLocation" value='<jsp:getProperty name="readdetailedinfobean" property="picturelocation" />'><br>
    <input type="submit" value="修改">
</form>
</div>
</body>
</html>
