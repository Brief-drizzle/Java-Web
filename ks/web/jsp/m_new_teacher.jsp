<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增教师</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <script src="../jquery-3.5.1.js"></script>
    <script src="../layer/layer.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">管理员模式</div>
        <%--左上名字--%>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui" style="color: #5FB878;" >
                powered by : mxm
            </li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <%--左侧栏--%>
                    <li class="layui-nav-item"><a href="http://localhost:8086/ks_war_exploded/jsp/m_manage_class.jsp">课程管理</a></li>
                    <li class="layui-nav-item"><a href="http://localhost:8086/ks_war_exploded/jsp/m_manage_teacher.jsp">教师管理</a></li>
            </ul>
        </div>
    </div>
    <form class="layui-form" method="post" action="${pageContext.request.contextPath}/m_teacher/insert.do">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>新增教师</legend>
                <%
                    String uid= (String) session.getAttribute("uid");
                    String tid= (String) session.getAttribute("teaid");
                %>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户Id</label>
                            <div class="layui-input-inline">
                                <input readonly value="<%=uid%>" type="text" name="userid" lay-verify="title" autocomplete="off" class="layui-input">
                            </div>
                            <label class="layui-form-label">教师Id</label>
                            <div class="layui-input-inline">
                                <input readonly value="<%=tid%>" type="text" name="teacherid" lay-verify="title" autocomplete="off" class="layui-input">
                            </div>
                            <label class="layui-form-label">教师姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="teachername" lay-verify="title" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">教师性别</label>
                            <%--<div class="layui-input-inline">
                                <input type="text" name="sex" lay-verify="title" autocomplete="off" class="layui-input">
                            </div>--%>
                            <div class="layui-input-inline">
                            <div class="layui-input-block">
                                <select name="sex" lay-filter="sex">
                                    <option value="F">F</option>
                                    <option value="M">M</option>
                                </select>
                                <script>
                                    layui.use('form', function(){
                                        var form = layui.form;
                                        form.render(null, 'sex');
                                    });
                                </script>
                            </div>
                            </div>
                            <label class="layui-form-label">教师职称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="protitle" lay-verify="title" autocomplete="off" class="layui-input">
                            </div>
                            <label class="layui-form-label">教师手机号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="phone" lay-verify="title" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div style="margin-top: 10px">
                            <button type="submit" class="layui-btn" style="margin-left: 35px">保存</button>
                            <button type="reset" class="layui-btn">重写</button>
                        </div>
            </fieldset>
        </div>
    </form>
</div>
</body>
</html>
