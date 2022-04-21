<%@ page import="me.hym.meeting.entity.Employee" %>
<%@ page import="me.hym.meeting.service.EmployeeManager" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 黄油猫
  Date: 2022/4/21
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% String base_url = request.getContextPath();%>
    <title>Title</title>
    <link rel="stylesheet" href="<%=base_url%>/library/css/layui.css">
    <script src="<%=base_url%>/library/layui.js"></script>
</head>
<body>
<form class="layui-form" action="<%=base_url%>/manager/department" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">部门编号</label>
        <div class="layui-input-block">
            <input type="text" readonly value="<%=request.getParameter("did") %>" name="did" required  lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">部门名称</label>
        <div class="layui-input-block">
            <input type="text" name="dname" required  lay-verify="required" placeholder="请输入部门名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">部门经理</label>
        <div class="layui-input-block">
            <select class="layui-input" name="manager_id">
                <% List<Employee> employeeList = EmployeeManager.getAllEmployee();
                    employeeList.removeIf(e->e.getE_status()!=0);
                %>
                <% for(Employee e: employeeList){ %>
                <option value="<%=e.getEid()%>"><%=e.getEname()%></option>
                <%}%>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">部门状态</label>
        <div class="layui-input-block">
            <select name="d_status" lay-verify="required">
            <option value="0">正常</option>
            <option value="1">停用</option>
        </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">部门描述</label>
        <div class="layui-input-block">
            <input type="text" name="d_desc" required  lay-verify="required" autocomplete="off" class="layui-input">

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" type="submin" lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</body>
</html>
