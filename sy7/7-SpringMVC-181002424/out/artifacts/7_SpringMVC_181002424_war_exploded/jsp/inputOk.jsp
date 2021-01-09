<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/11/9
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="users.pojo.Userpojo" %>
<html>
<head>
    <title>输出</title>
</head>
<body>
<div style="text-align: center;">
    <h1>
        <span style="color: Green; ">输入完整</span>
    </h1>
    <p>
        您的姓名是：
            <span>
            ${liuyanbean.username}
            </span> <br>
        您的留言是：
        <span>
            ${liuyanbean.word}
        </span>
</div>
</body>
</html>
