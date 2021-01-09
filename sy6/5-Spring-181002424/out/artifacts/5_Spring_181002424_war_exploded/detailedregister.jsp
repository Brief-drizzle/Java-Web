<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>

<!-- 若表单中有INPUT type=file 元素，FORM 元素 METHOD 标签属性的值必须设置为 post， 
FORM 元素 ENCTYPE 标签属性的值必须设置为 multipart/form-data。  -->

<form method="POST" action="GetRegister" >
 <div style="text-align: center;">
 <H1><span style="color: black; ">用户注册</span></H1></div>

<p align="center">
用户名：
 <input type="text" name="User" size="20" >

<p align="center">
密码：
<input type="password" name="password1" >
<p align="center">
密码确认：
<input type="password" name="password2" >

<p align="center">
邮箱：
<input type="text" name="email" >

<p align="center">
手机号：
<!-- file元素不允许有默认值 -->
<INPUT type="text" name="phonnumber" ></p>

<p align="center">
 <input type="submit" value=" 提交">   
 <input type="reset" value="重写"></p>  
 
</form>
</body>
</html>