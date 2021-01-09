<%@ page import="java.util.List" %>
<%@ page import="user.entity.*" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/15
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已选学生的信息</title>
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
            List<Papers> papersList= (List<Papers>) session.getAttribute("allstu");
            Topic topic= (Topic) session.getAttribute("now_topic");
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
                <legend>选题<%=topic.getTopic()%>的选题人及上传论文如下</legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                    <table class="layui-table" style="margin: 20px;">
                        <tr>
                            <th>学生姓名</th>
                            <th>上传论文名称</th>
                            <th>论文作者</th>
                            <th>论文来源</th>
                            <th>论文关键词</th>
                            <th>论文摘要</th>
                        </tr>
                        <%
                            Papers papers=new Papers();
                            for (int i=0;i<papersList.size();i++){
                                papers=papersList.get(i);
                        %>
                        <tr>
                            <td><%=papers.getStudent().getName()%></td>
                            <td><%=papers.getPaper().getTitle()%></td>
                            <td><%=papers.getPaper().getAuthor()%></td>
                            <td><%=papers.getPaper().getSource()%></td>
                            <td><%=papers.getPaper().getKeyword()%></td>
                            <td><%=papers.getPaper().getAbstract()%></td>
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
