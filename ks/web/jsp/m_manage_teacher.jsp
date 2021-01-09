<%@ page import="user.entity.Teacher" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师管理</title>
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
    <form method="post" action="${pageContext.request.contextPath}/m_teacher/new_teacher.do">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                        <div class="layui-form-item" style="margin-top: -20px">
                            <button type="submit" class="layui-btn layui-btn-primary layui-btn-sm">新建</button>
                        </div>
                        <script>
                            layui.use('table', function () {
                                var table = layui.table;

                                //转换静态表格
                                table.init('demo1', {
                                    page: true //开启分页
                                    //支持所有基础参数
                                });
                            });
                        </script>
                        <table class="layui-table" lay-filter="demo1">
                            <thead>
                            <tr>
                                <th lay-data="{field:'courseId', width:150}">教师ID</th>
                                <th lay-data="{field:'courseName', width:150}">教师名</th>
                                <th lay-data="{field:'term', width:150}">教师性别</th>
                                <th lay-data="{field:'courseHour', width:150}">教师职称</th>
                                <th lay-data="{field:'name',width:150}">手机号</th>
                            </tr></thead>
                            <tbody>
                            <%
                                List<Teacher> list=new ArrayList<>();
                                list= (List<Teacher>) session.getAttribute("teachers");
                                Teacher teachers=new Teacher();
                                for (user.entity.Teacher value : list) {
                                    teachers = value;
                            %>
                            <tr>
                                <td><%=teachers.getTeacherId()%>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/m_teacher/enter.do?teacherId=<%=teachers.getTeacherId()%>"> <%=teachers.getName()%></a>
                                </td>
                                <td><%=teachers.getSex()%>
                                </td>
                                <td><%=teachers.getProtitle()%>
                                </td>
                                <td><%=teachers.getPhone()%>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
                </div>
            </fieldset>
        </div>
    </form>
</div>
</body>
</html>
