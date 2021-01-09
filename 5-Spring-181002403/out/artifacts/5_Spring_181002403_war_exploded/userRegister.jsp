<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示请求表单的各种元素</title>
</head>
<body>

<!-- 若表单中有INPUT type=file 元素，FORM 元素 METHOD 标签属性的值必须设置为 post， 
FORM 元素 ENCTYPE 标签属性的值必须设置为 multipart/form-data。  -->

<form method="POST" action="GetUserRegister" >
<p align="center">用户注册

<p align="center">
用户名：<input type="text" name="User" size="20" >

<p align="center">
密码：
<input type="password" name="pwd" >
 <p align="center">
 确认密码：
 <input type="password" name="password" >

<p align="center">
邮箱：
 <input type="text" name="Email"  >

<p align="center">
手机号：
 <input type="text" name="Telephone">

<p align="center">
 <input type="submit" value=" 提交">   
 <input type="reset" value="重写"></p>  
 
</form>
</body>
</html>