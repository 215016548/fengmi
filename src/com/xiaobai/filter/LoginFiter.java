package com.xiaobai.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者： 小白
 * 日期： 2020/6/23
 * 时间： 17:43
 */
@WebFilter("/index.jsp")
public class LoginFiter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext servletContext = servletRequest.getServletContext();
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        response.sendRedirect(servletContext.getContextPath()+"/after/login.jsp");
    }

    @Override
    public void destroy() {

    }
}
