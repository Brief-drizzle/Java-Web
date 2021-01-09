<%@ page import="javax.swing.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <%--<script src="layui/layui.js"></script>--%>
    <script src="../jquery-3.5.1.js"></script>
    <script src="../layer/layer.js"></script>
</head>
<body>
<jsp:include page="index.jsp"/>
<script>
    layer.msg('用户名或密码错误，请重新输入');
</script>
</body>
</html>
