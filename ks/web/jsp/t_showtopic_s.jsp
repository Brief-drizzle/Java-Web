<%@ page import="user.entity.Course" %>
<%@ page import="user.entity.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page import="user.entity.Student" %>
<%@ page import="user.entity.Topic" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示学生选题信息</title>
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
            Student student= (Student) session.getAttribute("student");
            List<Topic>topics= (List<Topic>) session.getAttribute("s_topic");
            List<Teacher> teachers= (List<Teacher>) session.getAttribute("teachers");
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
                <legend>学生:<%=student.getName()%>的选题信息</legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                        <table class="layui-table" style="margin: 20px;">
                            <tr>
                                <th>主题ID</th>
                                <th>主题名</th>
                                <th>关键词</th>
                                <th>指导教师姓名</th>
                            </tr>
                            <%
                                Topic topic=new Topic();
                                String teaname = "";
                                for (Topic item : topics) {
                                    topic = item;
                                    String id = topic.getTeacherId();
                                    for (Teacher value : teachers) {
                                        if (id.equals(value.getTeacherId())) {
                                            teaname = value.getName();
                                        }
                                    }
                            %>
                            <tr>
                                <td><%=topic.getTopicId()%>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/stu_to/enter_topic.do?studentid=<%=student.getStudentId()%>&courseid=<%=course.getCourseId()%>&teacherid=<%=teacher.getTeacherId()%>&topicname=<%=topic.getTopic()%>"><%=topic.getTopic()%></a>
                                </td>
                                <td><%=topic.getKeyword()%>
                                </td>
                                <td><%=teaname%>
                                </td>
                                <%
                                    }
                                %>
                            </tr>
                        </table>
                </div>
            </fieldset>
        </div>
    </form>
</div>
</body>
</html>
