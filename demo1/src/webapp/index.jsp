<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录</title>
  <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
  <script src="layui/layui.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">用户登录</div>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item layui" style="color: #5FB878;" >
        powered by : mxm
      </li>
    </ul>
  </div>
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
    </div>
  </div>
  <form method="post" action="Getlogin">
    <div class="layui-body">
      <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
        <legend>登录界面</legend>
        <div class="layui-form-item" style="margin-top: 20px;">
          <label class="layui-form-label">用户名</label>
          <div class="layui-input-inline">
            <input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入用户名" class="layui-input">
          </div>
          <label class="layui-form-label">密码</label>
          <div class="layui-input-inline">
            <input type="password" name="password" lay-verify="title" autocomplete="off" placeholder="请输入密码" class="layui-input">
          </div>
          <div style="margin-left: 20px;margin-top: 20px;">
            <button type="submit" class="layui-btn layui-btn-radius" >登录</button>
            <button type="reset" class="layui-btn layui-btn-radius">重写</button>
          </div>
        </div>
      </fieldset>
    </div>
  </form>
</div>
</body>
</html>
