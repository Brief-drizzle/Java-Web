<%@ page import="user.entity.Stutopic" %>
<%@ page import="user.entity.Topic" %>
<%@ page import="user.entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="user.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传论文</title>
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
    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/stu_con/updatefile.do">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>上传文件</legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <label class="layui-form-label">上传</label>
                    <div class="layui-input-inline" style="text-align: center">
                        <input type="file" name="file" style="margin-top: 8px;">
                    </div>
                </div>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <div style="margin-top: -10px;margin-bottom: 10px;margin-left: 70px">
                        <button type="submit" class="layui-btn">上传文件</button>
                    </div>
                </div>
            </fieldset>
        </div>
    </form>
</div>
</body>
</html>
