        <%@ page import="java.util.ArrayList" %>
<%@ page import="beans.LoginBean" %>
        <%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/11/13
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员管理界面</title>
</head>
<body>
    <div style="text-align: center;" align="center">
        <H1><span style="color: REd; ">管理</span></H1>
    <table valign="middle" align="center">
    <tr align="center">
        <th>user</th>
        <th>work</th>
    </tr>
    <%
        List<LoginBean> list = new ArrayList<>();
        //ArrayList list = (ArrayList) request.getAttribute("loginbean");
        list= (List<LoginBean>) request.getSession().getAttribute("loginbean");
        LoginBean loginBean = null;
        for (int i = 0; i < list.size(); i++) {
            loginBean = (LoginBean) list.get(i);
    %>
    <tr valign="middle">
        <td><%=loginBean.getUsername()%></td>
        <td><a  href="Delete?username=<%=loginBean.getUsername()%>">删除</a> </td>
    </tr>
    <%}%>
    </table>
    </div>
</body>
</html>
