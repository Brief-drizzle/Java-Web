<%@ page import="user.entity.Tc" %>
<%@ page import="user.entity.Teacher" %>
<%@ page import="user.entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="user.entity.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新建学生信息</title>
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
    <form method="post" action="${pageContext.request.contextPath}/student/insertreturn.do" class="layui-form">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>为课程：<%=course.getCourseName()%>新增学生</legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                    <div class="layui-form-item">
                        <label class="layui-form-label">教师Id</label>
                        <div class="layui-input-inline">
                            <input readonly type="text" name="teacherid" lay-verify="title" autocomplete="off" class="layui-input" value="<%=teacher.getTeacherId()%>">
                        </div>
                        <label class="layui-form-label">课程名</label>
                        <div class="layui-input-inline">
                            <input readonly type="text" name="coursename" lay-verify="title" autocomplete="off" class="layui-input" value="<%=course.getCourseName()%>">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">课程id</label>
                        <div class="layui-input-inline">
                            <input readonly type="text" name="courseid" lay-verify="title" autocomplete="off" class="layui-input" value="<%=course.getCourseId()%>">
                        </div>
                            <label class="layui-form-label">学生姓名</label>
                            <script>
                                layui.use('form', function(){
                                    var form = layui.form;
                                    form.render(null, 'name');
                                });
                            </script>
                            <div class="layui-input-inline">
                                <div class="layui-input-block">
                                    <select name="stuname" lay-filter="name">
                                        <%
                                            List<Student> studentList=(List<Student>) session.getAttribute("studentexcept");
                                            Student student=new Student();
                                            for (int i=0;i<studentList.size();i++)
                                            {
                                                student=studentList.get(i);
                                        %>
                                        <option value="<%=student.getName()%>"><%=student.getName()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                    </div>
                        <div style="margin-top: 10px">
                            <button type="submit" class="layui-btn" style="margin-left: 35px">保存</button>
                            <button type="reset" class="layui-btn">重写</button>
                        </div>
                </div>
            </fieldset>
        </div>
    </form>
</div>
</body>
</html>
