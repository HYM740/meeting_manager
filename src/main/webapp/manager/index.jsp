<%@ page import="me.hym.meeting.entity.Employee" %>
<%@ page import="me.hym.meeting.service.EmployeeManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <% String base_url = request.getContextPath();%>
    <% Employee login_as = null;%>
    <meta charset="UTF-8">
    <meta charset="UTF-8">
    <title>会议管理系统</title>
    <link rel="stylesheet"
          href="<%=base_url%>/library/css/layui.css">
    <script src="<%=base_url%>/library/layui.js"></script>
</head>
<body>
<%if(request.getSession().getAttribute("login_as")==null){response.sendRedirect(base_url+"/login.jsp");}
    else{
        login_as= EmployeeManager.getEmployee((int)request.getSession().getAttribute("login_as"));
    %>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">会议管理系统</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>

            <li class="layui-nav-item layui-hide-xs"><a href="">主页</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="">关于</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其他</a>
                <dl class="layui-nav-child">
                    <dd><a href="">故障排除</a></dd>
                    <dd><a href="">系统公告</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="<%=base_url%>/img/null.jpg" class="layui-nav-img">
                    <%=session.getAttribute("login_as")==null?"":EmployeeManager.getEmployee((int)session.getAttribute("login_as")).getEname() %>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">个人信息</a></dd>
                    <dd><a href="">设置</a></dd>
                    <dd><a href="<%=base_url%>/login.jsp">登出</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">员工模块</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=base_url%>/manager/employee" target="kk">查看员工列表</a></dd>

                        <%if (login_as.getRole()==0) { %>
                        <dd><a href="<%=base_url%>/manager/employee?e_status=2" target="kk">审批注册申请</a></dd>
                        <%} %>

                    </dl>
                </li>
                <%if (login_as.getRole()==0) { %>
                <li class="layui-nav-item">
                    <a href="javascript:;">部门模块</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=base_url%>/manager/department" target="kk">部门管理</a></dd>
                    </dl>
                </li>
                <%}%>
                <li class="layui-nav-item">
                    <a href="javascript:;">会议模块</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=base_url%>/manager/meet" target="kk">全部会议信息</a></dd>
                        <dd><a href="<%=base_url%>/manager/meet?eid=<%=login_as.getEid()%>" target="kk">我的会议信息</a></dd>
                        <dd><a href="<%=base_url%>/manager/room" target="kk">会议室状态</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;height:100%">
            <iframe name="kk" style="width:100%;height:100%;overflow: auto;border: none"></iframe>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        <a href="https://github.com/HYM740" target="_blank">hym740©2022</a>
    </div>
</div>
<%--<script src="<%=base_url%>/library/layui.js"></script>--%>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function () {
        var element = layui.element
            , layer = layui.layer
            , util = layui.util
            , $ = layui.$;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function (othis) {
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            , menuRight: function () {
                layer.open({
                    type: 1
                    , content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    , area: ['260px', '100%']
                    , offset: 'rt' //右上角
                    , anim: 5
                    , shadeClose: true
                });
            }
        });

    });
</script>
<%}%>
</body>
</html>
      