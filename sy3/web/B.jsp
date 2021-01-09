<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/10/27
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>B.jsp</title>
</head>
    <h2>B.jsp</h2>
<body>
    <%
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String age=request.getParameter("age");
        String sex=request.getParameter("sex");
        String email=request.getParameter("email");
        session.setAttribute("name",name);
        session.setAttribute("password",password);
        session.setAttribute("age",age);
        session.setAttribute("sex",sex);
        session.setAttribute("email",email);
        out.print("name: "+name+"<br>");
        out.print("password: "+password+"<br>");
        out.print("age: "+age+"<br>");
        out.print("sex: "+sex+"<br>");
        out.print("E-mail: "+email+"<br>");
    %>
    <%--<a href="C.jsp">
        跳转到C页面
    </a>--%>
<jsp:forward page="C.jsp">
    <jsp:param name="name" value="name"/>
    <jsp:param name="password" value="password"/>
    <jsp:param name="age" value="age"/>
    <jsp:param name="sex" value="sex"/>
    <jsp:param name="email" value="email"/>
</jsp:forward>
</body>
</html>
