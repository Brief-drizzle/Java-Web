<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
        
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>留言成功</title>
    

  </head>
  
  <body>
  	<p align="center">
    <h1 align="center"><font color="black">留言成功，请做出你的选择!</font></h1>
    <h2 align="center"><font color="black">是否继续留言</font></h2>
    <form action="liuyanSuccess.do" method="post">
    	<p align="center">
    	<input type="radio" name="choice" value="yes">是&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="radio" name="choice" value="no">否
    	<p align="center">
    	<input type="submit" value="提交">
    </form>
     <br>
  </body>
</html>
