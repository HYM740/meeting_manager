<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List,me.hym.meeting.entity.Employee,me.hym.meeting.entity.Department"%>
<%@ page import="me.hym.meeting.service.DepartmentManager" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <% String base_url = request.getContextPath();%>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          href="<%=base_url%>/library/css/layui.css">
    <script src="<%=base_url%>/library/layui.js"></script>
</head>
<body>
<form class="layui-form" action="<%=base_url%>/manager/employee" method="post">
	<div class="layui-form-item">
    <label class="layui-form-label">员工编号</label>
    <div class="layui-input-block">
<input type="text" value="<%=request.getParameter("eid") %>" name="eid" required  lay-verify="required" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="ename" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
    </div>
  </div>
 <div class="layui-form-item">
    <label class="layui-form-label">出生日期</label>
    <div class="layui-input-block">
      <input type="date" name="birth_day" required  lay-verify="required" placeholder="请输入出生日期(yyyy-mm-dd)" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">联系方式</label>
    <div class="layui-input-block">
      <input type="text" name="telephone" required  lay-verify="required" placeholder="请输入联系方式" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">员工职位</label>
    <div class="layui-input-block">
      <select name="role" lay-verify="required">
        <option value="0">经理</option>
        <option value="1">员工</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">归属部门</label>
    <div class="layui-input-block">
      <select name="did" lay-verify="required">
          <% for(Department d: DepartmentManager.getAllDepartment()){ %>
          <option value="<%=d.getDid()%>"><%=d.getDname()%></option>
          <%}%>
      </select>
    </div>
   
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">员工状态</label>
    <div class="layui-input-block">
      <select name="e_status" lay-verify="required">
        <option value="0">正常入职</option>
        <option value="1">已离职</option>
        <option value="2">待审批</option>
      </select>
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