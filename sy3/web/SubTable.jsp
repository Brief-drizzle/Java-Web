<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/10/27
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SubTables</title>
</head>
    <h2>SubTable</h2>
<body>
    <%	out.println("<table border='4'>");
        for(int i=1;i<10;i++){
            out.print("<tr>");
            for (int j = 1; j <=i; j++) {
                out.print("<td>"+j+"*"+i+"="+i*j+"</td>");
            }
            out.print("</tr>");
        }
        out.println("</table>");
    %>
</body>
</html>
