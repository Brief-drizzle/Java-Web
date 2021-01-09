<%@ page import="user.entity.Course" %>
<%@ page import="user.entity.Teacher" %>
<%@ page import="java.util.List" %>
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
    <title>显示选题信息</title>
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
                <legend>课程<%=course.getCourseName()%>的选题</legend>
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
                            <th lay-data="{field:'topicId',width:150}">主题ID</th>
                            <th lay-data="{field:'topicName',width:150}">主题名</th>
                            <th lay-data="{field:'keyword',width:150}">关键词</th>
                            <th lay-data="{field:'teaname',width:150}">出题教师姓名</th>
                            <th lay-data="{field:'createtime',width:150}">创建时间</th>
                            <th lay-data="{field:'stu_num',width:150}">选题人数</th>
                            <th lay-data="{field:'action',width:150}">操作</th>
                        </tr></thead>
                        <tbody>
                        <%
                            List<Topic> topics= (List<Topic>) session.getAttribute("t_to");
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
                            <td><a href="${pageContext.request.contextPath}/topic/showstu.do?courseid=<%=course.getCourseId()%>&teacherid=<%=teacher.getTeacherId()%>&topicid=<%=topic.getTopicId()%>"><%=topic.getTopic()%></a>
                            </td>
                            <td><%=topic.getKeyword()%>
                            </td>
                            <td><%=teaname%>
                            </td>
                            <td><%=topic.getCreationTime()%>
                            </td>
                            <td><%=topic.getStudentNum()%>
                            </td>
                            <td><a href="${pageContext.request.contextPath}/topic/insert.do?courseid=<%=course.getCourseId()%>&teacherid=<%=teacher.getTeacherId()%>">新增</a></td>
                            <%
                                }
                            %>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </fieldset>
        </div>
    </form>
</div>
</body>
</html>
