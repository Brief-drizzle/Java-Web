<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/11/9
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板内容过少</title>
</head>
<body>
<jsp:useBean id="Liuyan" scope="request" type="jsptest.LiuyanBean"/>
<FORM ACTION="DoliuyanInput"  method="post"  >
    <div style="text-align: center;">
        <H1><span style="color: Red; ">留言板内容过少,请重新输入留言</span></H1>
        用户名:
        <input TYPE="text" NAME="name" value='<jsp:getProperty name="Liuyan" property="name"/>'><BR>
        留言:
        <input TYPE="text" NAME="word"><P>
        <input TYPE="submit" value="确定"> <!-- Press this to submit form -->
    </div>
</FORM>
</body>
</html>
