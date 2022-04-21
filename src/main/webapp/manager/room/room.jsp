<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" import="java.util.List" %>
<%@ page import="me.hym.meeting.entity.MeetingRoom" %>
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
<table class="layui-table">
    <%List<MeetingRoom> l = (List) request.getAttribute("meetingRoom_list"); %>
    <thead>
    <tr>
        <th>会议室编号</th>
        <th>会议室名称</th>
        <th>容纳人数</th>
        <th>会议室使用状态</th>
        <th>会议室设施描述</th>
    </tr>
    </thead>
    <%
        for (MeetingRoom b : l) { %>
    <tr>
        <td><%= b.getRid() %>
        </td>
        <td><%= b.getRname() %>
        </td>
        <td><%= b.getRnum() %>
        </td>
        <td>
            <%if (b.getRstate() == 0) {%>正常<%} else if (b.getRstate() == 1) {%>停用<%}%>
        </td>
        <td><%= b.getRdesc() %>
        </td>
    </tr>
    <% }%>
</table>
</body>
</html>