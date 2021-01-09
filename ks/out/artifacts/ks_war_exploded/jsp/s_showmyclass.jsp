<%@ page import="user.entity.Student" %>
<%@ page import="user.entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="user.entity.classes" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <script src="../jquery-3.5.1.js"></script>
    <script src="../layer/layer.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <%
            Student student= (Student) session.getAttribute("student");
            List<classes> list= (List<classes>) session.getAttribute("my_courses");
        %>
        <div class="layui-logo">您好,<%=student.getName()%>同学</div>
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
            </ul>
        </div>
    </div>
    <form method="post" action="">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>您的选课列表是</legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                    <table class="layui-table" style="margin: 20px;">
                        <tr>
                            <th>课程id</th>
                            <th>课程名</th>
                            <th>开设学期</th>
                            <th>总课时数</th>
                            <th>主讲教师姓名</th>
                        </tr>
                        <%
                            classes classes=new classes();
                            for (user.entity.classes value : list) {
                                classes = value;
                        %>
                        <tr>
                            <td><%=classes.getCourseId()%>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/stu_con/enter.do?courseId=<%=classes.getCourseId()%>&stuId=<%=student.getStudentId()%>"> <%=classes.getCourseName()%></a>
                            </td>
                            <td><%=classes.getTerm()%>
                            </td>
                            <td><%=classes.getCourseHour()%>
                            </td>
                            <td><%=classes.getName()%>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
            </fieldset>
        </div>
    </form>
</div>
</body>
</html>
