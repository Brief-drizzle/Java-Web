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
    <title>C.jsp</title>
</head>
    <h2>C.jsp</h2>
<body>
<%
    String name=(String)session.getAttribute("name");
    String password=(String)session.getAttribute("password");
    String age=(String)session.getAttribute("age");
    String sex=(String)session.getAttribute("sex");
    String email=(String)session.getAttribute("email");
    out.print("name: "+name+"<br>");
    out.print("password: "+password+"<br>");
    out.print("age: "+age+"<br>");
    out.print("sex: "+sex+"<br>");
    out.print("E-mail: "+email+"<br>");
%>
</body>
</html>
