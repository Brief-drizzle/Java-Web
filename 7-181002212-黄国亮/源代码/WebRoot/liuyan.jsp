<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录成功</title>
  </head>
  
  <body>
   	<p align="center">
   	<h1 align="center"><font color="black">欢迎来到留言系统</font></h1>
   	<h2 align="center"><font color="black">请留言</font></h2>
   	<p align="center">
   	<span>${requestScope.userinfo.username}先生/女士</span>
   	<form action="liuyan.do" method="post">
   		<p align="center">
   		用&nbsp;&nbsp;&nbsp;&nbsp;户：
   		<input type="text" name="username" value="${requestScope.userinfo.username}">
   		<p align="center">
   		留言主题：
   		<input type="text" name="topic">
   		<p align="center">
   		内&nbsp;&nbsp;&nbsp;&nbsp;容：<input type="text" name="detail">
   		<p align="center">
   		<input type="submit" value="提交">&nbsp;&nbsp;&nbsp;
   		<input type="reset" value="重置">
   	</form>
    <br>
  </body>
</html>
