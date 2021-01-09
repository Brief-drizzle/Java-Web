<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
    
  </head>
  
  <body>
    <p align="center">
    <h1 align="center"><font color="black">注册页面</font></h1>
    <h2 align="center"><font color="black">请输入用户名和密码</font></h2>
    <form action="register.do" method="post">
    	<p align="center">
    	用户名：
    	<input type="text" name="username">
    	<p align="center">
    	密&nbsp;&nbsp;&nbsp;码：
    	<input type="password" name="password">
    	<p align="center">
    	&nbsp;&nbsp;<input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="reset" value="重置">
    </form>
     <br>
  </body>
</html>
