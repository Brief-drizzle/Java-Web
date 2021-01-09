<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示详细注册信息</title>
</head>
<body><center>
<H1><font color="REd">登陆成功，您的详细注册信息如下</font></H1>
<jsp:useBean id="readUserBean" type="pojo.UserBean" scope="session" />
<p>您的用户名是：
<jsp:getProperty name="readUserBean" property="username" />
<p>您的密码是：
<jsp:getProperty name="readUserBean" property="password" />
<p>您的邮箱是：
<jsp:getProperty name="readUserBean" property="email" />
<p>您的电话是：
<jsp:getProperty name="readUserBean" property="telephone" />
<br/>
<br/>
<hr>
    <h2><a href="login.jsp">退出</a></h2>
</center></body>
</html>