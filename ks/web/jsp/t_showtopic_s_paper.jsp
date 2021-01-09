<%@ page import="java.util.List" %>
<%@ page import="user.entity.*" %><%--
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
            Topic topic= (Topic) session.getAttribute("now_topic");
            List<Paper> papers= (List<Paper>) session.getAttribute("s_papers");
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
                <legend>学生:<%=student.getName()%> 关于选题 <%=topic.getTopic()%> 提交的论文</legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                    <table class="layui-table" style="margin: 20px;">
                        <tr>
                            <th>论文ID</th>
                            <th>论文名</th>
                            <th>论文作者</th>
                            <th>出处</th>
                            <th>关键词</th>
                            <th>上传时间</th>
                        </tr>
                        <%
                            Paper paper=new Paper();
                            for (Paper item : papers) {
                                paper = item;
                        %>
                        <tr>
                            <td><%=paper.getPaperId()%>
                            </td>
                            <td><%=paper.getTitle()%>
                            </td>
                            <td><%=paper.getAuthor()%>
                            </td>
                            <td><%=paper.getSource()%>
                            </td>
                            <td><%=paper.getKeyword()%>
                            </td>
                            <td><%=paper.getUploadingTime()%>
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
