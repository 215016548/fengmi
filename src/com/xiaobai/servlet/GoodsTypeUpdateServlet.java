package com.xiaobai.servlet;

import com.xiaobai.entity.GoodsType;
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
 * 时间： 10:44
 */
@WebServlet("/GoodsTypeUpdateServlet")
public class GoodsTypeUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = request.getServletContext();
        GoodsType goodsType = new GoodsType();
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        String typename = request.getParameter("typename");
        String chooseId = request.getParameter("id");
        goodsType.setTypename(typename);
        int i = 0;
        if (goodsTypeService.selectGoodsType(goodsType.getTypename()) > 0) {
            response.setHeader("refresh", "1;/FengMi/after/add_goods_type.jsp?error=yes");
        }else {
            if (chooseId != null || "".equals(chooseId)) {
                i = goodsTypeService.goodsTypeAdd(goodsType);
            }else {
                int id = Integer.parseInt(chooseId);
                goodsType.setId(id);
                goodsTypeService.goodsTypeUpdate(goodsType);
            }
        }
        if (i > 0 ) {
            request.getRequestDispatcher("/GoodsTypeSelectServlet").forward(request,response);
        }else {
            System.out.println("操作失败");
        }
    }
}
