package com.xiaobai.servlet;

import com.xiaobai.entity.User;
import com.xiaobai.service.UserService;
import com.xiaobai.service.impl.UserServiceImpl;
import com.xiaobai.util.PageUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/23
 * 时间： 17:30
 */
@WebServlet("/UserFuzzyServlet")
public class UserFuzzyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = request.getServletContext();
        StringBuffer condition = new StringBuffer();
        PageUtil pageUtil = new PageUtil();
        UserService userService = new UserServiceImpl();
        User user = new User();
        String username = request.getParameter("username");
        if (username != null || "".equals(username)) {
            //模糊查询时，拼接condition字符串进行查询
            condition.append("and username like '%" +username+"%'" );
        }
        //查询结果最后一条数据的id值即为数据的总长度,一共有count条数据
        int count = userService.userFuzzyDataCount(condition.toString());
        String pNo = request.getParameter("pageNo");
        if (pNo == null ) {
            pNo = "1";
        }
        int pageNo = Integer.parseInt(pNo);
        int pageSize =3;
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(count);
        int pageCount = pageUtil.getPageCount();
        List<User> list = userService.fuzzySelectUser(pageNo,pageSize,condition.toString());
        request.setAttribute("list", list);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("/after/user.jsp").forward(request,response);
    }
}
