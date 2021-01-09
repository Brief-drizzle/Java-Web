<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>

  </head>
  
  <body>
    <h1 align="center"><font color="black">用户登录界面</font></h1>
    <h2 align="center"><font color="black">请登录</font></h2>
    <form action="login.do" method="post">
    	<p align="center">
    	用户名：<input type="text" name="username">
    	<p align="center">
    	密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password">
    	<p align="center">
    	&nbsp;&nbsp;&nbsp;<input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="reset" value="重置">
    </form>
    <p align="center">
    <a href="${pageContext.request.contextPath}/register">注册</a>
    
     <br>
  </body>
</html>
