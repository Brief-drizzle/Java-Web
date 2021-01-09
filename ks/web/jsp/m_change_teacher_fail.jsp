<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/13
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增课程</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <%--<script src="layui/layui.js"></script>--%>
    <script src="../jquery-3.5.1.js"></script>
    <script src="../layer/layer.js"></script>
</head>
<body>
<script>
    layer.msg('修改失败，请检查课时数或教师身份');
</script>
<jsp:include page="m_new_teacher_class.jsp"/>
</body>
</html>
