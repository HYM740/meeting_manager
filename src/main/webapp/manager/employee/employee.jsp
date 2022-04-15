<%@ page contentType="text/html;charset=UTF-8" language="java"
  import="java.util.List,me.hym.meeting.entity.Employee"
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%List<Employee> employeeList = (List<Employee>) request.getAttribute("employee_list")%>
  <table>
    <thead>
      <tr>
        <td>员工ID</td>
        <td>头像</td>
        <td>姓名</td>
        <td>入职日期</td>
        <td>电话</td>
        <td>生日</td>
        <td>角色</td>
        <td>部门ID</td>
        <td>状态</td>
        <td>操作</td>
      </tr>
    </thead>
    <tbody>
    <tr>
      <form action="<%=request.getContextPath()%>/manager/employee" method="post" id="form_new"></form>
      <td><input type="text" value="" form="form_new"></td>
      <td><img src="<%=request.getContextPath()%>/null.jpg"></td>
      <td><input type="text" value="" form="form_new"></td>
      <td><input type="text" value="" form="form_new"></td>
      <td><input type="text" value="" form="form_new"></td>
      <td><input type="text" value="" form="form_new"></td>
      <td><input type="text" value="" form="form_new"></td>
      <td><input type="text" value="" form="form_new"></td>
      <td><input type="text" value="" form="form_new"></td>
      <td>
        <input type="submit" value="新增" form="form_new">
      </td>
    </tr>
    <%for(Employee e:employeeList){%>
      <form action="<%=request.getContextPath()%>/manager/employee" method="post" id="form_<%=e.getEid()%>"></form>
      <tr>
        <td><input type="text" value="<%=e.getEid()%>" form="form_<%=e.getEid()%>"></td>
        <td><img src="<%=request.getContextPath()%>/<%=e.getPhoto_img()%>"></td>
        <td><input type="text" value="<%=e.getEname()%>" form="form_<%=e.getEid()%>"></td>
        <td><input type="text" value="<%=e.getHire_date()%>" form="form_<%=e.getEid()%>"></td>
        <td><input type="text" value="<%=e.getTelephone()%>" form="form_<%=e.getEid()%>"></td>
        <td><input type="text" value="<%=e.getBirth_day()%>" form="form_<%=e.getEid()%>"></td>
        <td><input type="text" value="<%=e.getRole()%>" form="form_<%=e.getEid()%>"></td>
        <td><input type="text" value="<%=e.getDid()%>" form="form_<%=e.getEid()%>"></td>
        <td><input type="text" value="<%=e.getE_status()%>" form="form_<%=e.getEid()%>"></td>
        <td>
          <form action="<%=request.getContextPath()%>/manager/employee" method="post">
            <input type="text" name="eid" value="<%=e.getEid()%>" hidden>
            <input type="text" name="method" value="delete" hidden>
            <input type="submit" value="删除">
          </form>
          <input type="submit" value="提交" form="form_<%=e.getEid()%>">
        </td>
      </tr>
    <%}%>
    </tbody>
  </table>
</body>
</html>
