<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录</title>
  <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
  <script src="../layui/layui.js"></script>
</head>
<body background="back4.jpg" style="background-size: 100%;background-position-x: center;background-repeat: no-repeat;">
<div class="layui-layout layui-layout-admin">
  <form method="post" action="${pageContext.request.contextPath}/user/login.do">
    <div class="layui-body">
      <fieldset class="layui-elem-field site-demo-button" style="-moz-border-radius:8px;margin-top: 110px;margin-left: 240px;margin-right: 410px;background-color: rgba(255,255,255,0.65)">
       <%-- <legend style="margin-left: 130px">登录界面</legend>--%>
        <label class="layui-form-label"style="margin-left: 130px;font-size: large">登录界面</label>
        <div class="layui-form-item" style="margin-top: 40px;">
          <label class="layui-form-label">用户名</label>
          <div class="layui-input-inline">
            <label>
              <input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入用户名" class="layui-input">
            </label>
          </div>
        </div>
        <div class="layui-form-item" style="margin-top: 20px;">
          <label class="layui-form-label">密码</label>
          <div class="layui-input-inline">
            <label>
              <input type="password" name="password" lay-verify="title" autocomplete="off" placeholder="请输入密码" class="layui-input">
            </label>
          </div>
        </div>
        <div class="layui-form-item" style="margin-top: 20px;margin-left: 90px;">
          <div style="margin-left: 20px;margin-top: 20px;">
            <button type="submit" class="layui-btn layui-btn-radius" >登录</button>
            <button type="reset" class="layui-btn layui-btn-radius layui-btn-normal">重写</button>
          </div>
        </div>
      </fieldset>
    </div>
  </form>
</div>
</body>
</html>
