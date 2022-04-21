package me.hym.meeting.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求日志跟踪
 * @author bataneko
 */
@WebFilter(urlPatterns = "/*")
public class LogFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        super.doFilter(req, res, chain);
        StringBuffer sb = new StringBuffer();
        getServletContext().log("请求地址："+req.getRequestURI());
        getServletContext().log("请求方式："+req.getMethod());

    }

}
