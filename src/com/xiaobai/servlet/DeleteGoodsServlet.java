package com.xiaobai.servlet;

import com.xiaobai.service.GoodsService;
import com.xiaobai.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者： 小白
 * 日期： 2020/6/27
 * 时间： 19:27
 */
@WebServlet("/DeleteGoodsServlet")
public class DeleteGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService gs=new GoodsServiceImpl();
        String gid=request.getParameter("goodsid");
        System.out.println(gid);
        String[] id=gid.split(",");
        int result=0;
        for (int i = 0; i < id.length; i++) {
            if(!id[i].equals("")) {
                int stuid=Integer.parseInt(id[i]);
                result=gs.GoodsDeleteById(stuid);
            }
        }
        request.getRequestDispatcher("/FuzzySelectGoods").forward(request, response);
    }
}
