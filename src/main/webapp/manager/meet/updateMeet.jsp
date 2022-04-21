<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List"%>
<%@ page import="me.hym.meeting.entity.Employee" %>
<%@ page import="me.hym.meeting.service.EmployeeManager" %>
<%@ page import="me.hym.meeting.entity.MeetingRoom" %>
<%@ page import="me.hym.meeting.service.MeetingRoomManager" %>
<!DOCTYPE html>
<html>
<head>
    <% String base_url = request.getContextPath();%>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          href="<%=base_url%>/library/css/layui.css">
    <script src="<%=base_url%>/library/layui.js"></script>
</head>
<body>
<form class="layui-form" action="<%=base_url%>/manager/meet" method="post">
	<div class="layui-form-item">
    <label class="layui-form-label">会议编号</label>
    <div class="layui-input-block">
    	<input type="text" value="<%=request.getParameter("mid") %>" name="mid" readonly  lay-verify="required" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">会议主持人</label>
    <div class="layui-input-block">
        <select name="eid" class="layui-input">
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
        <label class="layui-form-label">会议室名称</label>
        <div class="layui-input-block">
            <select class="layui-input" name="rid">
                <% for(MeetingRoom r: MeetingRoomManager.getAllMeetingRoom()){ %>
                <option value="<%=r.getRid()%>"><%=r.getRname()%></option>
                <%}%>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">会议主题</label>
        <div class="layui-input-block">
            <input type="text" name="mtitle" required  lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">会议开始时间</label>
        <div class="layui-input-block">
            <input type="datetime-local" name="msdate" required  lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">会议结束时间</label>
        <div class="layui-input-block">
            <input type="datetime-local" name="medate" required  lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">会议状态</label>
        <div class="layui-input-block">
            <select name="mstate" class="layui-input">
                <option value="0">未开始</option>
                <option value="1">已结束</option>
                <option value="2">已取消</option>
                <option value="3">进行中</option>
            </select>
        </div>
    </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" type="submin" lay-filter="formDemo">提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
 

</body>
</html>