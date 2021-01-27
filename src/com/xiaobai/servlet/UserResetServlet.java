package com.xiaobai.servlet;

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
 * 时间： 20:59
 */
@WebServlet("/UserResetServlet")
public class UserResetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("id");
        ServletContext servletContext = request.getServletContext();
        UserService userService = new UserServiceImpl();
        int id = Integer.parseInt(userid);
        int i = userService.userResetPassword(id);
        if (i == 1) {
            response.sendRedirect(servletContext.getContextPath()+"/UserFuzzyServlet");
        }
    }
}
