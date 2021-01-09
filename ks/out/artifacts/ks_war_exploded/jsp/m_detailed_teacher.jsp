<%@ page import="user.entity.Teacher" %>
<%@ page import="user.entity.Courses" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师详情</title>
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
            </ul>
        </div>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/m_teacher/change_teacher.do" id="manage" onsubmit="return checktime()">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <%
                    Teacher teacher= (Teacher) session.getAttribute("m__teacher");
                %>
                <legend>教师：<%=teacher.getName()%></legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-inline">
                                <input readonly type="text" name="userid" lay-verify="title" autocomplete="off" value="<%=teacher.getUserId()%>" class="layui-input">
                            </div>
                            <label class="layui-form-label">教师Id</label>
                            <div class="layui-input-inline">
                                <input  readonly type="text" name="teacherid" lay-verify="title" autocomplete="off" value="<%=teacher.getTeacherId()%>" class="layui-input">
                            </div>
                            <label class="layui-form-label">教师姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="teacherName" lay-verify="title" autocomplete="off" value="<%=teacher.getName()%>" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">教师性别</label>
                            <div class="layui-input-inline">
                                <input type="text" name="sex" lay-verify="title" autocomplete="off" value="<%=teacher.getSex()%>" class="layui-input">
                            </div>
                            <label class="layui-form-label">教师职称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="protitle" lay-verify="title" autocomplete="off" value="<%=teacher.getProtitle()%>" class="layui-input">
                            </div>
                            <label class="layui-form-label">手机号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="phone" lay-verify="title" autocomplete="off" value="<%=teacher.getPhone()%>" class="layui-input">
                            </div>
                        </div>
                        <table class="layui-table" style="margin: 20px;">
                            <tr>
                                <th>课程id</th>
                                <th>课程名</th>
                                <th>教师身份</th>
                                <th>授课学时</th>
                                <th>操作</th>
                            </tr>
                            <%
                                List<Courses>courses= (List<Courses>) session.getAttribute("m__course");
                                Courses course=new Courses();
                                for (Courses value:courses)
                                {
                                    course=value;
                            %>
                            <tr>
                                <td>
                                    <%=course.getCourse().getCourseId()%>
                                </td>
                                <td>
                                    <%=course.getCourse().getCourseName()%>
                                </td>
                                <td>
                                    <%=course.getTc().getTeaIdentity()%>
                                </td>
                                <td>
                                    <%=course.getTc().getTeachHour()%>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/m_teacher/change_class.do?teacherid=<%=teacher.getTeacherId()%>&courseid=<%=course.getCourse().getCourseId()%>">编辑</a>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                        <div style="text-align: center">
                            <button type="submit" class="layui-btn layui-btn-radius" style="align-items: center">保存修改</button>
                        </div>
                </div>
                <script>
                    function checktime() {
                        var fa=document.getElementById("form");
                        if (fa.courseId.value==null||fa.courseName.value==null||fa.term.value==null||fa.courseHour.value==null)
                        {
                            layer.msg("不能有空值");
                            return false;
                        }
                    }
                </script>
            </fieldset>
        </div>
    </form>
</div>
</body>
</html>
