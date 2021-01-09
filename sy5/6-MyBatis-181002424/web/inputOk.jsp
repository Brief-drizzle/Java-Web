<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/11/9
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="pojo.Userpojo" %>
<html>
<head>
    <title>输出</title>
</head>
<body>
<div style="text-align: center;">
    <h1>
        <span style="color: Green; ">输入完整</span>
    </h1>
    <jsp:useBean id="liuyanbean" scope="request" type="pojo.Userpojo"/>
    <p>
        您的姓名是：
            <jsp:getProperty name="liuyanbean" property="username"/> <br>
        您的留言是：
            <jsp:getProperty name="liuyanbean" property="word"/>
</div>
</body>
</html>
