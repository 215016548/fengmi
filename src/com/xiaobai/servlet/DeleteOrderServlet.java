package com.xiaobai.servlet;

import com.xiaobai.service.OrderService;
import com.xiaobai.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者： 小白
 * 日期： 2020/6/29
 * 时间： 8:13
 */
@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService gs=new OrderServiceImpl();
        String oid=request.getParameter("ordersid");
        System.out.println(oid);
        String[] id=oid.split(",");
        int result=0;
        for (int i = 0; i < id.length; i++) {
            if(!id[i].equals("")) {
                int stuid=Integer.parseInt(id[i]);
                result=gs.OrdersDeleteById(stuid);
            }
        }
        request.getRequestDispatcher("/OrderFuzzySelectServlet").forward(request, response);
    }
}
