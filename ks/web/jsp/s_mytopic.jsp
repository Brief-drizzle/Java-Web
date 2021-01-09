<%@ page import="user.entity.Course" %>
<%@ page import="user.entity.Student" %>
<%@ page import="user.entity.Topic" %>
<%@ page import="java.util.List" %>
<%@ page import="user.entity.Stutopic" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的选题</title>
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
            List<Topic>mytopic= (List<Topic>) session.getAttribute("mytopics");
            Stutopic stutopic= (Stutopic) session.getAttribute("stutopic");
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
                    <li class="layui-nav-item"><a href="http://localhost:8086/ks_war_exploded/jsp/s_mytopic.jsp">我的选题</a></li>
            </ul>
        </div>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/stu_con/update.do">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>课程<%=course.getCourseName()%>的选题如下</legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                        <label class="layui-form-label">学生id</label>
                        <div class="layui-input-inline">
                            <input readonly value="<%=student.getStudentId()%>" type="text" name="stuid" lay-verify="title" autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">课程id</label>
                        <div class="layui-input-inline">
                            <input readonly value="<%=course.getCourseId()%>" type="text" name="courseid" lay-verify="title" autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label">选题id</label>
                        <div class="layui-input-inline">
                            <input readonly value="<%=mytopic.get(0).getTopicId()%>" type="text" name="topicid" lay-verify="title" autocomplete="off" class="layui-input">
                        </div>
                </div>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <label class="layui-form-label">选题题目</label>
                    <div class="layui-input-inline">
                        <input readonly value="<%=mytopic.get(0).getTopic()%>" type="text" name="topic" lay-verify="title" autocomplete="off" class="layui-input">
                    </div>
                    <%
                        if (stutopic.getFlag().equals("1")){
                    %>
                    <label class="layui-form-label">是否上传论文</label>
                    <div class="layui-input-inline">
                        <input readonly value="是" type="text" name="iftopic" lay-verify="title" autocomplete="off" class="layui-input">
                    </div>
                    <%
                        }
                        else {
                    %>
                    <label class="layui-form-label">是否上传论文</label>
                    <div class="layui-input-inline">
                        <input readonly value="否" type="text" name="iftopic" lay-verify="title" autocomplete="off" class="layui-input">
                    </div>
                    <%
                        }
                    %>

                </div>
                <div class="layui-form-item" style="margin-top: 20px;">
                <div style="margin-top: -10px;margin-bottom: 10px;text-align: center">
                <button type="submit" class="layui-btn">上传文件</button>
                </div>
                </div>
            </fieldset>
        </div>
    </form>
</div>
</body>
</html>
