<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/11/11
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详细注册界面</title>
</head>
<body>
<H1><span style="color: REd; ">
注册详细信息失败，请重新注册
</span></H1>
<!-- 若表单中有INPUT type=file 元素，FORM 元素 METHOD 标签属性的值必须设置为 post，
FORM 元素 ENCTYPE 标签属性的值必须设置为 multipart/form-data。  -->

<form method="POST" action="GetDetailedRegister" >

    <p align="center">用户注册

    <p align="center">
        用户名：<input type="text" name="User" size="20" >

    <p align="center">
        年龄：
        <input type="text" name="age" >

    <p align="center">
        性别：
        <input type="radio" name="sexy" value=male  CHECKED> 男
        <input type="radio" name="sexy" value=female> 女</p>

    <p align="center">
        请上传照片：
        <!-- file元素不允许有默认值 -->
        <INPUT TYPE="file" NAME="uploadfile" ></p>

    <p align="center">
        <input type="submit" value=" 提交">
        <input type="reset" value="重写"></p>

</form>
</body>
</html>
