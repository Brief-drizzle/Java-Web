<%@ page import="user.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="user.entity.Topic" %>
<%@ page import="user.entity.Course" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程主题查看和选题</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <script src="../jquery-3.5.1.js"></script>
    <script src="../layer/layer.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <%
            Student student= (Student) session.getAttribute("now_stu");
            Course course= (Course) session.getAttribute("now_course");
            List<Topic>topicList= (List<Topic>) session.getAttribute("alltopics");
            List<Topic>mytopic= (List<Topic>) session.getAttribute("mytopics");
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
                <li class="layui-nav-item"><a href="http://localhost:8086/ks_war_exploded/jsp/s_showtopic_stu.jsp">课程主题查看和选题</a></li>
                    <%
                        if (mytopic.size()!=0){
                    %>
                    <li class="layui-nav-item"><a href="http://localhost:8086/ks_war_exploded/jsp/s_mytopic.jsp">我的选题</a></li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
    <form method="post" action="">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>课程<%=course.getCourseName()%>的选题如下</legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                    <%
                        if (mytopic.size()==0){
                    %>
                    <table class="layui-table" style="margin: 20px;">
                        <tr>
                            <th>主题名称</th>
                            <th>操作</th>
                        </tr>
                        <%
                            Topic topic=new Topic();
                            for (int i=0;i<topicList.size();i++){
                                topic=topicList.get(i);
                        %>
                        <tr>
                            <td><%=topic.getTopic()%></td>
                            <td><a href="${pageContext.request.contextPath}/stu_con/read.do?courseId=<%=course.getCourseId()%>&stuId=<%=student.getStudentId()%>&topicId=<%=topic.getTopicId()%>">我要读</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                    <%
                        }
                        else {
                    %>
                        <table class="layui-table" style="margin: 20px;">
                            <tr>
                                <th>主题名称</th>
                                <th>操作</th>
                            </tr>
                            <%
                                Topic topic=new Topic();
                                for (int i=0;i<topicList.size();i++){
                                    topic=topicList.get(i);
                            %>
                            <tr>
                                <td><a href="${pageContext.request.contextPath}/stu_con/show.do?courseId=<%=course.getCourseId()%>&stuId=<%=student.getStudentId()%>&topicId=<%=topic.getTopicId()%>"><%=topic.getTopic()%></a></td>
                                <td>我要读</td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                    <%
                        }
                    %>
                </div>
            </fieldset>
        </div>
    </form>
</div>
</body>
</html>
