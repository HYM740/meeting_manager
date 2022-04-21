package me.hym.meeting.controller;

import me.hym.meeting.entity.Department;
import me.hym.meeting.entity.Employee;
import me.hym.meeting.service.DepartmentManager;
import me.hym.meeting.service.EmployeeManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/manager/department")
public class DepartmentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setCharacterEncoding("UTF-8");
        List<Department> departmentList = DepartmentManager.getAllDepartment();
        req.setAttribute("department_list", departmentList);
        //避免递归
        String method = (String) req.getAttribute("other");
        if (method != null && method.equals("0")) {
            req.getRequestDispatcher("/manager/department/department.jsp").forward(req, resp);
            return;
        }
//        删除操作
        String delete = req.getParameter("method");
        if (delete!=null&&delete.equals("delete")) {
            String did = req.getParameter("did");

            if (did == null) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            Department d = DepartmentManager.getDepartment(Integer.parseInt(did));
            d.setD_status(1);
            boolean result = DepartmentManager.updateDepartment(d);
            if (result) {
                req.getRequestDispatcher("/manager/department/department.jsp").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
            return;
        }
        if(req.getParameter("did")!=null){
            req.getRequestDispatcher("/manager/department/updateDep.jsp").forward(req,resp);
            return;
        }
        req.getRequestDispatcher("/manager/department/department.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        boolean result = false;
        //构造部门对象
        Department d = null;
        if (method == null) {
            try {
                int did = Integer.parseInt(req.getParameter("did"));
                d = DepartmentManager.getDepartment(did);
            } catch (NullPointerException ex) {
                return;
            }
        } else if (method.equals("put")) {
            d = new Department();
        }
        d.setDname(req.getParameter("dname"));
        d.setManager_id(Integer.parseInt(req.getParameter("manager_id")));
        d.setD_desc(req.getParameter("d_desc"));
        d.setD_status(Integer.parseInt(req.getParameter("d_status")));
        if (method == null) {
            result = DepartmentManager.updateDepartment(d);
        } else if (method.equals("put")) {
            result = DepartmentManager.createDepartment(d);
        }
        if (result) {
            req.setAttribute("other", "0");
            doGet(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
