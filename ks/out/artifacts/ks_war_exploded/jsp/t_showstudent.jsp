<%@ page import="user.entity.Teacher" %>
<%@ page import="user.entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="user.entity.students" %>
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
    <title>显示学生信息</title>
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
                <legend>课程<%=course.getCourseName()%>的选课名单</legend>
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
                            <th lay-data="{field:'stuId',width:150}">学生学号</th>
                            <th lay-data="{field:'stuName',width:150}">学生姓名</th>
                            <th lay-data="{field:'sex',width:150}">学生性别</th>
                            <th lay-data="{field:'major',width:150}">学生专业</th>
                            <th lay-data="{field:'class',width:150}">学生班级</th>
                            <th lay-data="{field:'action',width:150}">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<students> studentsList= (List<students>) session.getAttribute("t_s");
                            students students=new students();
                            for (user.entity.students value : studentsList) {
                                students = value;
                        %>
                        <tr>
                            <td><%=students.getStudent().getStudentId()%></td>
                            <td><a href="${pageContext.request.contextPath}/stu_to/enter.do?courseid=<%=course.getCourseId()%>&teacherid=<%=teacher.getTeacherId()%>&stuname=<%=students.getStudent().getName()%>">
                                <%=students.getStudent().getName()%></a></td>
                            <td><%=students.getStudent().getSex()%></td>
                            <td><%=students.getStudent().getMajor()%></td>
                            <td><%=students.getStudent().getClasses()%></td>
                            <%
                                if (tc.getTeaIdentity().equals("主讲教师"))
                                {
                            %>
                            <td>
                                <a href="${pageContext.request.contextPath}/student/insert.do?courseid=<%=course.getCourseId()%>&teacherid=<%=teacher.getTeacherId()%>" >新增</a>
                                <a href="${pageContext.request.contextPath}/student/delete.do?studentid=<%=students.getStudent().getStudentId()%>&courseid=<%=course.getCourseId()%>&teacherid=<%=teacher.getTeacherId()%>" >删除</a>
                            </td>
                            <%
                                }
                                else{
                            %>
                            <td>新增 删除</td>
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
