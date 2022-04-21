<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" import="me.hym.meeting.entity.Department,java.util.List"%>
<%@ page import="me.hym.meeting.service.EmployeeManager" %>
<%@ page import="me.hym.meeting.entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
<% String base_url = request.getContextPath();%>
	<meta charset="utf-8"><title>Insert title here</title>
	<link rel="stylesheet" href="<%=base_url%>/library/css/layui.css">
	<script src="<%=base_url%>/library/layui.js"></script>
</head>
<body>
<table class="layui-table">
	<%List<Department> l =(List)request.getAttribute("department_list"); %>
	<thead>
	<tr>
			<th>部门编号</th> 
			<th>部门名称</th> 
			<th>经理</th>
			<th>部门状态</th>
			<th>部门说明</th>
			<th>操作</th>
		</tr>
		</thead>
	<tr>
		<form action="<%=base_url%>/manager/department" method="post">
			<input type="text" name="method" hidden readonly value="put">
		<td><input class="layui-input" type="text" placeholder="自动填充" readonly></td>
		<td><input class="layui-input" type="text" name="dname" required></td>
		<td>
			<select class="layui-input" name="manager_id">
				<% List<Employee> employeeList = EmployeeManager.getAllEmployee();
				   employeeList.removeIf(e->e.getE_status()!=0);
				%>
				<% for(Employee e: employeeList){ %>
				<option value="<%=e.getEid()%>"><%=e.getEname()%></option>
				<%}%>
			</select>
		</td>
		<td><input class="layui-input" type="text" name="d_status"></td>
		<td><input class="layui-input" type="text" name="d_desc"></td>
		<td><input class="layui-btn" type="submit" value="提交"></td>
		</form>
	</tr>
	<%for(Department b:l){  %>
	<tr>
		<td><%= b.getDid() %></td>
		<td><%= b.getDname() %></td>
		<td><%= EmployeeManager.getEmployee(b.getManager_id()).getEname() %></td>
		<td><%if(b.getD_status()==0) {%>正常<%}else if(b.getD_status()==1){%>停用<%}%></td>
		<td><%= b.getD_desc() %></td>
		<td>
			<button class="layui-btn" onclick="location.href='<%=base_url%>/manager/department?did=<%=b.getDid()%>'">修改</button>
			<button class="layui-btn" onclick="location.href='<%=base_url%>/manager/department?did=<%=b.getDid()%>&method=delete'">停用</button>
		</td>
	</tr><%}%>
</table>	
</body>
</html>