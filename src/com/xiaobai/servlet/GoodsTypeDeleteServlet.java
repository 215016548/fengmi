package com.xiaobai.servlet;

import com.xiaobai.service.GoodsTypeService;
import com.xiaobai.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者： 小白
 * 日期： 2020/6/24
 * 时间： 14:06
 */
@WebServlet("/GoodsTypeDeleteServlet")
public class GoodsTypeDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deleteId = request.getParameter("id");
        ServletContext servletContext = request.getServletContext();
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        int id = Integer.parseInt(deleteId);
        int i = goodsTypeService.goodsTypeDelete(id);
        if (i > 0 ) {
            response.sendRedirect(servletContext.getContextPath()+"/GoodsTypeSelectServlet");
        }
    }
}
