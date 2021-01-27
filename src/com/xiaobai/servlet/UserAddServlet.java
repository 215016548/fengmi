package com.xiaobai.servlet;

import com.xiaobai.entity.User;
import com.xiaobai.service.UserService;
import com.xiaobai.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者： 小白
 * 日期： 2020/6/23
 * 时间： 21:22
 */
@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ServletContext servletContext = request.getServletContext();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        User user = new User(username, password ,phone, mail);
        UserService userService = new UserServiceImpl();
        if(userService.userAdd(user) > 0 ) {
            response.sendRedirect(servletContext.getContextPath()+"/UserFuzzyServlet");
        }else {
            response.sendRedirect(servletContext.getContextPath()+"/after/admin_adduser.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
