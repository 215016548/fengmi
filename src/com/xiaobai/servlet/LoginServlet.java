package com.xiaobai.servlet;

import com.xiaobai.entity.Admin;
import com.xiaobai.service.AdminService;
import com.xiaobai.service.impl.AdminServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 作者： 小白
 * 日期： 2020/6/23
 * 时间： 17:08
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminService aa = new AdminServiceImpl();
        Admin ad = new Admin();
        ad.setName(username);
        ad.setPassword(password);
        boolean rs = aa.login(ad);
        if(rs) {
            request.getSession().setAttribute("username",username);
            response.sendRedirect(servletContext.getContextPath()+"/UserFuzzyServlet");
        }else {
            response.sendRedirect(servletContext.getContextPath()+"/after/login.jsp");
        }
    }
}
