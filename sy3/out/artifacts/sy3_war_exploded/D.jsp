<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/10/27
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <h2>D.jsp</h2>
<body>
    <%
        String name=(String)session.getAttribute("name");
        String password=(String)session.getAttribute("password");
        String age=(String)session.getAttribute("age");
        String sex=(String)session.getAttribute("sex");
        String email=(String)session.getAttribute("email");
        if (application.getAttribute("counter")==null)
            application.setAttribute("counter","1");
        else 
            {
                String strnum=null;
                strnum=application.getAttribute("counter").toString();
                int icount=0;
                icount=Integer.valueOf(strnum).intValue();
                icount++;
                application.setAttribute("counter",Integer.toString(icount));
            }
        out.print("name: "+name+"<br>");
        out.print("password: "+password+"<br>");
        out.print("age: "+age+"<br>");
        out.print("sex: "+sex+"<br>");
        out.print("E-mail: "+email+"<br>");
        out.print("访问次数："+application.getAttribute("counter")+"<br>");
    %>
</body>
</html>
