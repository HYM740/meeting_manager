package me.hym.meeting.controller;

import me.hym.meeting.entity.Employee;
import me.hym.meeting.service.EmployeeManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manager/employee")
public class EmployeeController extends HttpServlet {
    /**
     * 获取员工信息
     * @param req HTTP请求
     * @param resp HTTP响应
     * @throws ServletException Servlet错误
     * @throws IOException IO错误
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        List<Employee> employeeList = EmployeeManager.getAllEmployee();
        req.setAttribute("employee_list",employeeList);
        req.getRequestDispatcher(req.getContextPath()+"/manager/employee.jsp").forward(req,resp);
    }
    /**
     * 更新员工信息
     * @param req HTTP请求
     * @param resp HTTP响应
     * @throws ServletException Servlet错误
     * @throws IOException IO错误
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter("method");
        //请求分发
        if(method==null){
            //TODO
            Employee employee = new Employee();
            EmployeeManager.updateEmployee(employee);
//            return;
        }
        if(method.equals("delete")){
            doDelete(req,resp);
//            return;
        }else if(method.equals("put")){
            doPut(req,resp);
//            return;
        }
        doGet(req, resp);
    }

    /**
     * 新增员工
     * @param req HTTP请求
     * @param resp HTTP响应
     * @throws ServletException Servlet错误
     * @throws IOException IO错误
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO
        Employee employee = new Employee();
        EmployeeManager.createEmployee(employee);
    }

    /**
     * 删除员工
     * @param req HTTP请求
     * @param resp HTTP响应
     * @throws ServletException Servlet错误
     * @throws IOException IO错误
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eid=req.getParameter("eid");
        if(eid==null){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        boolean result = EmployeeManager.deleteEmployee(Integer.parseInt(eid));
        if(result){
            return;
        }else{
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
