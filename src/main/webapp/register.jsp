<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="app">
    <div class="login-window">
        <div class="logo"><img src="favicon.ico"></div>
        <div class="logo-text">中软会议管理系统</div>
        <form action="<%=request.getContextPath()%>/login" method="post">
            <input type="text" hidden name="register" value="true" readonly>
            <label for="username">用户名</label>
            <input type="text" name="username" id="username">
            <label for="password">密码</label>
            <input type="password" name="password" id="password">
            <div class="button-group">
                <input type="submit" value="注册">
                <input type="reset" value="重填">
            </div>
        </form>
        <div class="msg"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></div>
        <div class="no-account">
            已有账号？点击<a href="<%=request.getContextPath()%>/login.jsp">这里</a>登录！
        </div>
    </div>
</div>
</body>
</html>