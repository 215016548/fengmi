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
 * 时间： 20:20
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        UserService userService = new UserServiceImpl();
        String userId = request.getParameter("id");
        int id = Integer.parseInt(userId);
        int i = userService.userDeleteById(id);
        if (i == 1 ) {
            response.sendRedirect(servletContext.getContextPath()+"/UserFuzzyServlet");
        }else {
            response.getWriter().append("删除失败");
        }
    }
}
