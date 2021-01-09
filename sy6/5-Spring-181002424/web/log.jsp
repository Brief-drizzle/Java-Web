<%@ page import="java.util.ArrayList" %>
<%@ page import="userpojo.Logtable" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="controller.UserController" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/6
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>log</title>
</head>
<body>
<div style="text-align: center;" align="center">
    <H1><span style="color: REd; ">日志</span></H1>
    <table valign="middle" align="center" border="5">
        <tr align="center">
            <th>user</th>
            <th>userlogtime</th>
            <th>userlogip</th>
            <th>userlogcontinuetime(s)</th>
        </tr>
        <%
            ApplicationContext applicationContext =
                    new ClassPathXmlApplicationContext("LoginBean.xml");
            UserController userController =
                    (UserController) applicationContext.getBean("userController");
            List<Logtable> list = new ArrayList<>();
            list=userController.getall();
            Logtable loginBean = null;
            for (int i = 0; i < list.size(); i++) {
                loginBean = (Logtable) list.get(i);
        %>
        <tr valign="middle">
            <td><%=loginBean.getUsername()%></td>
            <td><%=loginBean.getLogtime()%></td>
            <td><%=loginBean.getLogip()%></td>
            <td><%=loginBean.getLogcontime()%></td>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
