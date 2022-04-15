package me.hym.meeting.controller;

import me.hym.meeting.entity.Employee;
import me.hym.meeting.service.EmployeeManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    /**
     * 登录请求处理
     * @param req HTTP请求
     * @param resp HTTP响应
     * @throws ServletException Servlet错误
     * @throws IOException IO错误
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //获取员工
        Employee e = EmployeeManager.getEmployee(username);
        if(e==null||!(e.getTelephone().equals(username)&&e.getPassword().equals(password))){
            //登录失败
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else{
            int eid=e.getEid();
            HttpSession session = req.getSession();
            session.setAttribute("login_as",eid);
            resp.sendRedirect(req.getContextPath()+"/manager");
        }

    }
    /**
     * 仅用于支持POST请求
     * @param req HTTP请求
     * @param resp HTTP响应
     * @throws ServletException Servlet错误
     * @throws IOException IO错误
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
