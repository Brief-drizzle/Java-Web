<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="user.entity.Teacher" %>
<%@ page import="user.entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="user.entity.classes" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程管理</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <script src="../jquery-3.5.1.js"></script>
    <script src="../layer/layer.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">管理员模式</div>
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
                <li class="layui-nav-item"><a href="http://localhost:8086/ks_war_exploded/jsp/m_manage_class.jsp">课程管理</a></li>
                <li class="layui-nav-item"><a href="http://localhost:8086/ks_war_exploded/jsp/m_manage_teacher.jsp">教师管理</a></li>
                    <%--<form method="post" action="${pageContext.request.contextPath}/user/classmanage.do">
                    <li class="layui-nav-item "><button class="layui-btn layui-btn-radius">课程管理</button></li>
                    </form>
                    <form method="post" action="${pageContext.request.contextPath}/user/teachermanage.do">
                    <li class="layui-nav-item"><button class="layui-nav-item">教师管理</button></li>
                    </form>--%>
            </ul>
        </div>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/manager/new_class.do">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button"style="margin-top: 20px;" >
                <div class="layui-form-item"style="margin-top: 20px;">
                    <%--主体--%>
                        <%--<div class="layui-row">
                            <table class="layui-table" id="managetable"></table>
                        </div>
                    <script>
                            layui.use('table', function()
                            {
                                var table = layui.table;
                                table.render(
                                    {
                                        /* //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档*/
                                        elem: '#managetable'
                                        ,height: 312
                                        ,url:'${pageContext.request.contextPath}/user/all.do'
                                        ,layout: ['limit', 'count', 'prev', 'page', 'next', 'skip']
                                        /*//自定义分页布局*/
                                        ,curr: 1 /*//设定初始在第 1 页*/
                                        ,groups: 1 /*//只显示 1 个连续页码*/
                                        ,first: false /*//不显示首页*/
                                        ,last: false/* //不显示尾页*/
                                        ,cols:
                                            [
                                                [
                                                    {field:'courseId', width:150, title: '课程ID'}
                                                    ,{field:'courseName', width:150, title: '课程名'}
                                                    ,{field:'term', width:150, title: '开设学期'}
                                                    ,{field:'courseHour', width:150, title: '总课时数'}
                                                    ,{field:'name',width:150, title: '主讲教师'}
                                                ]
                                            ]
                                    });
                            })
                        </script>--%>
                        <div class="layui-form-item" style="margin-top: -20px">
                            <button type="submit" class="layui-btn layui-btn-primary layui-btn-sm">新建</button>
                        </div>
                        <script>
                            layui.use('table', function () {
                                var table = layui.table;

                                //转换静态表格
                                table.init('demo', {
                                    page: true //开启分页
                                    //支持所有基础参数
                                });
                            });
                        </script>
                        <table class="layui-table" lay-filter="demo">
                            <thead>
                        <tr>
                            <th lay-data="{field:'courseId', width:150}">课程ID</th>
                            <th lay-data="{field:'courseName', width:150}">课程名</th>
                            <th lay-data="{field:'term', width:150}">开设学期</th>
                            <th lay-data="{field:'courseHour', width:150}">总课时数</th>
                            <th lay-data="{field:'name',width:150}">主讲教师</th>
                        </tr></thead>
                            <tbody>
                        <%
                            List<classes> list=new ArrayList<>();
                            list= (List<classes>) session.getAttribute("classes");
                            classes classes=new classes();
                            for (user.entity.classes value : list) {
                                classes = value;
                        %>
                        <tr>
                            <td><%=classes.getCourseId()%>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/manager/enter.do?courseId=<%=classes.getCourseId()%>"> <%=classes.getCourseName()%></a>
                            </td>
                            <td><%=classes.getTerm()%>
                            </td>
                            <td><%=classes.getCourseHour()%>
                            </td>
                            <td><%=classes.getName()%>
                            </td>
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
