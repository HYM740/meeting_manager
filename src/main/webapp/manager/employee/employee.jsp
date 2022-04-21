<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List,me.hym.meeting.entity.Employee,me.hym.meeting.entity.Department,me.hym.meeting.service.DepartmentManager" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head><% String base_url = request.getContextPath();
 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");%>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=base_url%>/library/css/layui.css">
<script src="<%=base_url%>/library/layui.js"></script>
</head>
<body>
 <table class="layui-table">
  <thead>
   <tr >
    <th>员工编号</th>
    <th>员工照片</th>
    <th>员工姓名</th>
    <th>部门名称</th>
    <th>入职日期</th>
    <th>联系方式</th>
    <th>出生日期</th>
    <th>员工职位</th>
    <th>员工状态</th>
    <th>操作</th>
   </tr>
  </thead>
  <tbody>
  <%if(request.getParameter("e_status")==null){%>
  <tr>
   <form action="<%=base_url%>/manager/employee" method="post">
    <input type="text" name="method" hidden value="put">
   <td><input type="text" readonly placeholder="自动填充" class="layui-input"></td>
   <td><input type="text" name="photo_img" class="layui-input"></td>
   <td><input type="text" name="ename" equired class="layui-input"></td>
   <td>
    <select class="layui-input" name="did">
    <% for(Department d: DepartmentManager.getAllDepartment()){ %>
     <option value="<%=d.getDid()%>"><%=d.getDname()%></option>
     <%}%>
    </select></td>
   <td><input type="date" name="hire_date" required class="layui-input"></td>
   <td><input type="text" name="telephone" required class="layui-input"></td>
   <td><input type="date" name="birth_day" class="layui-input"></td>
   <td><select name="role" class="layui-input"><option value="0">经理</option><option value="1">员工</option></select></td>
   <td><select name="e_status" class="layui-input"><option value="0">在职</option><option value="1">离职</option><option value="2">入职审批中</option></select></td>

   <td><input type="submit" value="新增" class="layui-btn"></td>
   </form>
  </tr>
  <%}%>
  <% 
  List<Employee> l =(List)request.getAttribute("employee_list");
   for(Employee e:l){
    %>
    <tr>
     <td>
      <%=e.getEid() %>
     </td>
     <td>
      <img src="<%=base_url%>/img/<%=e.getPhoto_img()%>" />
     </td>
     <td>
      <%=e.getEname() %>
     </td>
     <td>
      <%Department d = DepartmentManager.getDepartment(e.getDid());%>
      <%=d==null?"无":d.getDname()%>
     </td>
     <td>
      <%=df.format(e.getHire_date()) %>
     </td>
     <td>
      <%=e.getTelephone() %>
     </td>
     <td>
      <%=df.format(e.getBirth_day()) %>
     </td>
     <td>
      <%if(e.getRole()==0) {
      %>
      经理
      <%
      }else if(e.getRole()==1){
       %>
       员工
       <% 
      }%>
     </td>
     <td>
      <%if(e.getE_status()==0) {
      %>
      在职
      <% 
      }else if (e.getE_status()==1){
       %>
       离职
       <% 
      }else if(e.getE_status()==2){
       %>
       入职审批中
       <% 
      }%>
     </td>    
     <td>
      <button class="layui-btn" onclick="location.href='<%=base_url%>/manager/employee?eid=<%=e.getEid()%>&method=delete'">删除</button>
      <button class="layui-btn" onclick="location.href='<%=base_url%>/manager/employee?eid=<%=e.getEid()%>'"><%=request.getParameter("e_status")==null?"修改":"审批"%></button>
     </td>
    </tr>
    <%
    
   }
  %>
  </tbody>
 </table>
</body>
</html>