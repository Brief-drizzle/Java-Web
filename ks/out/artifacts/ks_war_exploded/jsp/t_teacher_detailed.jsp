<%@ page import="user.entity.Teacher" %>
<%@ page import="user.entity.Courses" %>
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
    <title>教师信息</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <script src="../jquery-3.5.1.js"></script>
    <script src="../layer/layer.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <%
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

            </ul>
        </div>
    </div>
    <form method="post" action="">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>    </legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                        <table class="layui-table" style="margin: 20px;">
                            <tr>
                                <th>课程id</th>
                                <th>课程名</th>
                                <th>教师身份</th>
                                <th>授课学时</th>
                            </tr>
                            <%
                                List<Courses> courses= (List<Courses>) session.getAttribute("m__course");
                                Courses course=new Courses();
                                for (Courses value:courses)
                                {
                                    course=value;
                            %>
                            <tr>
                                <td>
                                    <%=course.getCourse().getCourseId()%>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/m_teacher/my_detailed_class.do?teacherid=<%=teacher.getTeacherId()%>&courseid=<%=course.getCourse().getCourseId()%>">
                                    <%=course.getCourse().getCourseName()%>
                                    </a>
                                </td>
                                <td>
                                    <%=course.getTc().getTeaIdentity()%>
                                </td>
                                <td>
                                    <%=course.getTc().getTeachHour()%>
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
