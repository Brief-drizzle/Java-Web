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
                            <th lay-data="{field:'topicName',width:150}">主题id</th>
                            <th lay-data="{field:'stu',width:150}">学生姓名</th>
                        </tr></thead>
                        <tbody>
                        <%
                            List<Stutopic> stutopicList= (List<Stutopic>) session.getAttribute("allstudent");
                            List<Student>studentList= (List<Student>) session.getAttribute("allstudents");
                            for (int i=0;i<stutopicList.size();i++){
                                Stutopic stutopic=stutopicList.get(i);
                                String name="";
                                for (int i1 = 0;i1<studentList.size();i1++){
                                    if (studentList.get(i1).getStudentId().equals(stutopic.getStudentId())) {
                                        name = studentList.get(i1).getName();
                                        break;
                                    }
                                }
                        %>
                        <tr>
                            <td><%=stutopic.getTopicId()%>
                            </td>
                            <td><a href="${pageContext.request.contextPath}/topic/showpaper.do?courseid=<%=course.getCourseId()%>&teacherid=<%=teacher.getTeacherId()%>&topicid=<%=stutopic.getTopicId()%>&stuid=<%=stutopic.getStudentId()%>">
                                <%=name%>
                            </td>
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
