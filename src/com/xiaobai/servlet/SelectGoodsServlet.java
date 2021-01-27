package com.xiaobai.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者： 小白
 * 日期： 2020/6/24
 * 时间： 15:59
 */
//@WebServlet("/SelectGoodsServlet")
public class SelectGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        GoodsService goodsService = new GoodsServiceImpl();
//        List<Goods> list = new ArrayList<>();
//        request.setAttribute("list", list);
//        request.getRequestDispatcher("/after/goods_list.jsp").forward(request,response);
    }
//        response.getWriter().print(JSON.toJSON(list));

}
