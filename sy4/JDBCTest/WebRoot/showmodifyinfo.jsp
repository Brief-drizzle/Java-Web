<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/11/11
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示修改后注册信息</title>
</head>
<body><div style="text-align: center;">
    <H1><span style="color: REd; ">修改成功，您的详细注册信息如下</span></H1>
    <jsp:useBean id="readmodifyinfobean" class="beans.ModifyInfoBean" scope="session" />
    <p>您的用户名是：
        <jsp:getProperty name="readmodifyinfobean" property="username" />
    <p>您的年龄是：
        <jsp:getProperty name="readmodifyinfobean" property="age" />
    <p>您的性别是：
        <jsp:getProperty name="readmodifyinfobean" property="sexy" />
    <p>您的照片存储在服务器上的位置是：
        <jsp:getProperty name="readmodifyinfobean" property="pictureLocation" />
</div>
</body>
</html>
