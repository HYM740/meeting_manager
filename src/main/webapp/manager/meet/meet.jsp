<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" import="java.util.List" %>
<%@ page import="me.hym.meeting.entity.Meet" %>
<%@ page import="me.hym.meeting.service.EmployeeManager" %>
<%@ page import="me.hym.meeting.service.MeetingRoomManager" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="me.hym.meeting.entity.Employee" %>
<%@ page import="me.hym.meeting.entity.MeetingRoom" %>
<!DOCTYPE html>
<html>
<head>
    <%String base_url = request.getContextPath();%>
    <%DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="<%=base_url%>/library/css/layui.css"/>
    <script src="<%=base_url%>/library/layui.js"></script>
</head>
<body>
<table class="layui-table">
    <%List<Meet> l = (List) request.getAttribute("meetList"); %>
    <thead>
    <tr>
        <th>会议主持人</th>
        <th>会议编号</th>
        <th>会议室名称</th>
        <th>会议主题</th>
        <th>会议开始时间</th>
        <th>会议结束时间</th>
        <th>会议状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <form action="<%=base_url%>/manager/meet" method="post">
            <input type="text" name="method" hidden value="put">
            <td>
                <select class="layui-input" name="eid">
                    <% for(Employee e: EmployeeManager.getAllEmployee()){ %>
                    <option value="<%=e.getEid()%>"><%=e.getEname()%></option>
                    <%}%>
                </select>
            </td>
            <td><input type="text" readonly placeholder="自动填充" class="layui-input"></td>

            <td>
                <select class="layui-input" name="rid">
                    <% for(MeetingRoom r: MeetingRoomManager.getAllMeetingRoom()){ %>
                    <option value="<%=r.getRid()%>"><%=r.getRname()%></option>
                    <%}%>
                </select>
            </td>
            <td><input type="text" name="mtitle" required class="layui-input"></td>
            <td><input type="datetime-local" name="msdate" class="layui-input"></td>
            <td><input type="datetime-local" name="medate" class="layui-input"></td>
            <td><select name="mstate" class="layui-input"><option value="0">未开始</option><option value="1">已结束</option><option value="2">已取消</option><option value="3">进行中</option></select></td>

            <td><input type="submit" value="新增" class="layui-btn"></td>
        </form>
    </tr>
    <%
        for (Meet b : l) { %>
    <tr>
        <td><%= EmployeeManager.getEmployee(b.getEid()).getEname() %>
        </td>
        <td><%= b.getMid() %>
        </td>
        <td><%= MeetingRoomManager.getMeetingRoom(b.getRid()).getRname() %>
        </td>
        <td><%= b.getMtitle() %>
        </td>
        <td><%= df.format(b.getMsdate()) %>
        </td>
        <td><%= df.format(b.getMedate()) %>
        </td>
        <td>
                <%if(b.getMstate()==0) {%>未开始
                <%}else if(b.getMstate()==1){%>已结束
                <%}else if(b.getMstate()==2){%>已取消
                <%}else if(b.getMstate()==3){%>进行中
                <%}%>
        <td>
            <button class="layui-btn" onclick="location.href='<%=base_url%>/manager/meet?mid=<%=b.getMid()%>'">
                修改
            </button>
            <%if (b.getEid() == (int) request.getSession().getAttribute("login_as")) {%>
            <button class="layui-btn"
                    onclick="location.href='<%=base_url%>/manager/meet?mid=<%=b.getMid()%>&method=delete'">
                取消
            </button>
            <%}else{%>
        <button class="layui-btn"
                onclick="location.href='<%=base_url%>/manager/participants?mid=<%=b.getMid()%>&eid=<%=request.getSession().getAttribute("login_as")%>'">
            参与
        </button>
            <%}%>
        </td>
    </tr>
    <% }
    %>
    </tbody>

</table>
</body>
</html>