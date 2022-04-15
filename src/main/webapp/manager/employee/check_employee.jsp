<%@
    page contentType="text/html;charset=UTF-8" language="java"
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
        <td>姓名</td>
        <td>入职日期</td>
        <td>电话</td>
        <td>状态</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <%for(Employee e:employeeList){%>
    <tr>
        <td><%=e.getEid()%></td>
        <td><%=e.getEname()%></td>
        <td><%=e.getHire_date()%></td>
        <td><%=e.getTelephone()%></td>
        <td><%=e.getE_status()%></td>
        <td>
            <form action="<%=request.getContextPath()%>/manager/employee" method="post">
                <input type="text" name="eid" value="<%=e.getEid()%>" hidden>
                <input type="text" name="method" value="update" hidden>
                <input type="submit" value="审批">
            </form>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>
