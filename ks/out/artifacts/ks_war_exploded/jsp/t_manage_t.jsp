<%@ page import="user.entity.Teacher" %>
<%@ page import="user.entity.Course" %>
<%@ page import="user.entity.Tc" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改教师信息</title>
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
            Teacher now_t= (Teacher) session.getAttribute("change_tea");
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
    <form method="post" action="${pageContext.request.contextPath}/t_manage/change_check.do">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>更改<%=now_t.getName()%>的授课信息</legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <label class="layui-form-label">当前登录教师id</label>
                    <div class="layui-input-inline">
                        <input readonly value="<%=teacher.getTeacherId()%>" type="text" name="teaid" lay-verify="title" autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">教师id</label>
                    <div class="layui-input-inline">
                        <input readonly value="<%=now_t.getTeacherId()%>" type="text" name="teacherid" lay-verify="title" autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">课程Id</label>
                    <div class="layui-input-inline">
                        <input readonly value="<%=course.getCourseId()%>" type="text" name="courseId" lay-verify="title" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">课程名</label>
                    <div class="layui-input-inline">
                        <input readonly value="<%=course.getCourseName()%>" type="text" name="courseName" lay-verify="title" autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">开设学期</label>
                    <div class="layui-input-inline">
                        <input readonly value="<%=course.getTerm()%>" type="text" name="term" lay-verify="title" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">授课学时</label>
                    <div class="layui-input-inline">
                        <input value="<%=tc.getTeachHour()%>" type="text" name="courseHour" lay-verify="title" autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">教师身份</label>
                    <div class="layui-input-inline">
                        <input readonly value="<%=tc.getTeaIdentity()%>" type="text" name="teaIden" lay-verify="title" autocomplete="off" class="layui-input">
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
