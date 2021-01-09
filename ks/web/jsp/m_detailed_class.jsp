<%@ page import="java.util.List" %>
<%@ page import="user.entity.Teacher" %>
<%@ page import="user.entity.Course" %>
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
    <title>课程详情</title>
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
    <form method="post" id="manage" onsubmit="return checktime()" action="${pageContext.request.contextPath}/manager/change_class.do">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <%
                Course course= (Course) session.getAttribute("m_course");
                %>
                <legend>课程: <%=course.getCourseName()%></legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                        <div class="layui-form-item">
                        <label class="layui-form-label">课程Id</label>
                        <div class="layui-input-inline">
                            <input readonly type="text" name="courseId" lay-verify="title" autocomplete="off" value="<%=course.getCourseId()%>" class="layui-input">
                        </div>
                        <label class="layui-form-label">课程名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="courseName" lay-verify="title" autocomplete="off" value="<%=course.getCourseName()%>" class="layui-input">
                        </div>
                        </div>
                        <div class="layui-form-item">
                        <label class="layui-form-label">开设学期</label>
                        <div class="layui-input-inline">
                            <input type="text" name="term" lay-verify="title" autocomplete="off" value="<%=course.getTerm()%>" class="layui-input">
                        </div>
                        <label class="layui-form-label">课时数</label>
                        <div class="layui-input-inline">
                            <input type="text" name="courseHour" lay-verify="title" autocomplete="off" value="<%=course.getCourseHour()%>" class="layui-input">
                        </div>
                        </div>
                        <table class="layui-table" lay-filter="demo1">
                            <thead>
                            <tr>
                                <th>教师Id</th>
                                <th>教师姓名</th>
                                <th>教师身份</th>
                                <th>授课学时</th>
                            </tr></thead>
                            <tbody>
                            <%
                                List<Teachers>teachers= (List<Teachers>) session.getAttribute("m_teacher");
                                Teachers teacher=new Teachers();
                                for (Teachers value:teachers)
                                {
                                    teacher=value;
                            %>
                            <tr>
                                <td>
                                    <%=teacher.getTeacher().getTeacherId()%>
                                </td>
                                <td>
                                    <%=teacher.getTeacher().getName()%>
                                </td>
                                <td>
                                    <%=teacher.getTc().getTeaIdentity()%>
                                </td>
                                <td>
                                    <%=teacher.getTc().getTeachHour()%>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
                        <div style="text-align: center">
                            <button type="submit" class="layui-btn layui-btn-radius" style="align-items: center">保存修改</button>
                        </div>
                </div>
                <script>
                    function checktime() {
                        var fa=document.getElementById("form");
                        if (fa.courseId.value==null||fa.courseName.value==null||fa.term.value==null||fa.courseHour.value==null)
                        {
                            layer.msg("不能有空值");
                            return false;
                        }
                    }
                </script>
            </fieldset>
        </div>
    </form>
</div>
</body>
</html>
