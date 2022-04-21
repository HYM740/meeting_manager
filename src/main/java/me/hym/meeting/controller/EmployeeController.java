package me.hym.meeting.controller;

import me.hym.meeting.entity.Employee;
import me.hym.meeting.service.EmployeeManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/manager/employee")
public class EmployeeController extends HttpServlet {
    /**
     * 获取员工信息
     *
     * @param req  HTTP请求
     * @param resp HTTP响应
     * @throws ServletException Servlet错误
     * @throws IOException      IO错误
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setCharacterEncoding("UTF-8");
        String para = req.getParameter("e_status");

        List<Employee> employeeList = EmployeeManager.getAllEmployee();
        req.setAttribute("employee_list", employeeList);
        String method = (String) req.getAttribute("other");
        //避免递归
        if (method != null && method.equals("0")) {
            req.getRequestDispatcher("/manager/employee/employee.jsp").forward(req, resp);
            return;
        }
//        删除操作
        String delete = req.getParameter("method");
        if (delete!=null&&delete.equals("delete")) {
            String eid = req.getParameter("eid");

            if (eid == null) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            Employee e = EmployeeManager.getEmployee(Integer.parseInt(eid));
            e.setE_status(1);
            boolean result = EmployeeManager.updateEmployee(e);
            if (result) {
                req.getRequestDispatcher("/manager/employee/employee.jsp").forward(req, resp);

            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
            return;
        }

//      去除不满足参数的员工
        if (para != null && para.equals("2")) {
            employeeList.removeIf(ep -> ep.getE_status() != 2);
        }
        if (req.getParameter("eid") != null) {
            req.getRequestDispatcher("/manager/employee/updateEmp.jsp").forward(req, resp);
            return;
        }

        req.getRequestDispatcher("/manager/employee/employee.jsp").forward(req, resp);
        //BUG:转发的 / 是项目根目录，不是网站根目录
//        req.getRequestDispatcher(req.getContextPath()+"/manager/employee/employee.jsp").forward(req,resp);
    }


    /**
     * 更新、新增员工信息
     *
     * @param req  HTTP请求
     * @param resp HTTP响应
     * @throws ServletException Servlet错误
     * @throws IOException      IO错误
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        boolean result = false;
        //构造员工对象
        Employee e = null;
        if (method == null) {
            try {
                int eid = Integer.parseInt(req.getParameter("eid"));
                e = EmployeeManager.getEmployee(eid);
            } catch (NullPointerException ex) {
                return;
            }
        } else if (method.equals("put")) {
            e = new Employee();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        e.setEname(req.getParameter("ename"));
        if (e.getPassword() == null) {
            e.setPassword("123456");
        }
        try {
            String hire = req.getParameter("hire_date");
            String birth = req.getParameter("birth_day");
            e.setHire_date(hire == null ? e.getHire_date() : sdf.parse(hire));
            e.setBirth_day(sdf.parse(birth));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        String tel = req.getParameter("telephone");
        e.setTelephone(tel == null ? e.getTelephone() : e.getTelephone());
        e.setPhoto_img(req.getParameter("img"));
        e.setRole(Integer.parseInt(req.getParameter("role")));
        e.setDid(Integer.parseInt(req.getParameter("did")));
        e.setE_status(Integer.parseInt(req.getParameter("e_status")));
        if (method == null) {
            result = EmployeeManager.updateEmployee(e);
        } else if (method.equals("put")) {
            result = EmployeeManager.createEmployee(e);
        }
        if (result) {
            req.setAttribute("other", "0");
            doGet(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

}
