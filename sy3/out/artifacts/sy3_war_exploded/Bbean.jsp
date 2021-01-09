<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/10/29
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page import="JavaBean.Abean" %>
<html>
<head>
    <title>Bbean.jsp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
    <h2>Bbean.jsp</h2>
<body>
<jsp:useBean id="Abean" class="JavaBean.Abean" scope="session">

<jsp:setProperty name="Abean" property="name" param="name"/>
<jsp:setProperty name="Abean" property="password" param="password"/>
<jsp:setProperty name="Abean" property="age" param="age"/>
<jsp:setProperty name="Abean" property="sex" param="sex"/>
<jsp:setProperty name="Abean" property="email" param="email"/>
</jsp:useBean>
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
<%--<a href="Cbean.jsp">
    跳转到C页面<br>
</a>--%>
<jsp:forward page="Cbean.jsp" >
    <jsp:param name="name" value="name"/>
    <jsp:param name="password" value="password"/>
    <jsp:param name="age" value="age"/>
    <jsp:param name="sex" value="sex"/>
    <jsp:param name="email" value="email"/>
</jsp:forward>
</body>
</html>
