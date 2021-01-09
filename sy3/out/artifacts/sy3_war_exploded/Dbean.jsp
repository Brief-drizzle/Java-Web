<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/10/29
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dbean.jsp</title>
</head>
<h2>Dbean.jsp</h2>
<body>
<jsp:useBean id="Abean" class="JavaBean.Abean" scope="session"/>
    <p>
    用户名：<br>
    <jsp:getProperty name="Abean" property="name"/>
<%Abean.getName();%>
</p>
<p>
    密码：<br>
    <jsp:getProperty name="Abean" property="password"/>
</p>
<p>
    年龄：<br>
    <jsp:getProperty name="Abean" property="age"/>
</p>
<p>
    性别：<br>
    <jsp:getProperty name="Abean" property="sex"/>
</p>
<p>
    邮件：<br>
    <jsp:getProperty name="Abean" property="email"/>
</p>
</body>
</html>
