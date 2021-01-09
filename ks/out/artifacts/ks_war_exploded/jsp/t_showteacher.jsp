<%@ page import="user.entity.Teacher" %>
<%@ page import="user.entity.Course" %>
<%@ page import="user.entity.Tc" %>
<%@ page import="java.util.List" %>
<%@ page import="user.entity.Teachers" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示教师信息</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <script src="../jquery-3.5.1.js"></script>
    <script src="../layer/layer.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <%
            Course course= (Course) session.getAttribute("t_c");
            Teacher teacher= (Teacher) session.getAttribute("teacher");
            List<Teachers> teachers= (List<Teachers>) session.getAttribute("tea_courses");
            Tc tc= (Tc) session.getAttribute("t_tc");
        %>
        <div class="layui-logo">您好，<%=teacher.getName()%>老师</div>
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
                    <li class="layui-nav-item"><a href="http://localhost:8086/ks_war_exploded/jsp/t_showtopic.jsp">选题管理</a></li>
                    <li class="layui-nav-item"><a href="http://localhost:8086/ks_war_exploded/jsp/t_showstudent.jsp">学生管理</a></li>
                    <li class="layui-nav-item"><a href="http://localhost:8086/ks_war_exploded/jsp/t_showteacher.jsp">教师管理</a></li>
            </ul>
        </div>
    </div>
    <form method="post" action="">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>课程<%=course.getCourseName()%>的教师名单</legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
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
                        <table class="layui-table" style="margin: 20px;" lay-filter="demo1">
                            <thead>
                            <tr>
                                <th lay-data="{field:'teaId',width:150}">教师ID</th>
                                <th lay-data="{field:'teaname',width:150}">教师姓名</th>
                                <th lay-data="{field:'teaIden',width:150}">教师身份</th>
                                <th lay-data="{field:'teachtime',width:150}">授课学时</th>
                                <th lay-data="{field:'action',width:150}">操作</th>
                            </tr></thead>
                            <tbody>
                            <%
                                Teachers teachers1=new Teachers();
                                for (Teachers value : teachers) {
                                    teachers1 = value;
                            %>
                            <tr>
                                <td><%=teachers1.getTeacher().getTeacherId()%>
                                </td>
                                <td><%=teachers1.getTeacher().getName()%>
                                </td>
                                <td><%=teachers1.getTc().getTeaIdentity()%>
                                </td>
                                <td><%=teachers1.getTc().getTeachHour()%>
                                </td>
                                <%
                                    if (tc.getTeaIdentity().equals("主讲教师")) {
                                %>
                                <td>
                                    <a href="${pageContext.request.contextPath}/t_manage/insert.do?courseid=<%=course.getCourseId()%>&teaid=<%=teacher.getTeacherId()%>">新建</a>
                                    <a href="${pageContext.request.contextPath}/t_manage/change.do?courseid=<%=course.getCourseId()%>&teaid=<%=teacher.getTeacherId()%>&teacherid=<%=teachers1.getTeacher().getTeacherId()%>">编辑</a>
                                    <a href="${pageContext.request.contextPath}/t_manage/delete.do?courseid=<%=course.getCourseId()%>&teaid=<%=teacher.getTeacherId()%>&teacherid=<%=teachers1.getTeacher().getTeacherId()%>">删除</a>
                                </td>
                                <%
                                } else {
                                %>
                                <td>新建 编辑 删除</td>
                                <%
                                    }
                                %>
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
