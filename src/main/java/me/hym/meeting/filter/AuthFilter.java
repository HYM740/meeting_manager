package me.hym.meeting.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 对未登录的会话访问系统予以拦截
 * @author bataneko
 */
@WebFilter(urlPatterns = "/manager/*")
public class AuthFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException,
            ServletException {
        HttpSession session = req.getSession();
        if(session.getAttribute("login_as")==null){
            //HTTP 401
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            //跳转到登录
//            req.getRequestDispatcher(req.getContextPath()+"/login.jsp").forward(req,res);
        }
//        super.doFilter(req, res, chain);
    }
}
