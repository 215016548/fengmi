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
 * 日期： 2020/6/29
 * 时间： 18:00
 */
@WebServlet("/BeforeUserRegisterServlet")
public class BeforeUserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset = utf-8");
        ServletContext servletContext = request.getServletContext();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setMail(mail);
        System.out.println(user.toString());

        if(userService.userRegister(user) == 1) {
            response.sendRedirect(servletContext.getContextPath()+"/before/success.html");
        }else {
            response.sendRedirect(servletContext.getContextPath()+"/before/success.html");
        }
    }
}
