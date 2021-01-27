package com.xiaobai.servlet;

import com.xiaobai.entity.GoodsType;
import com.xiaobai.service.GoodsTypeService;
import com.xiaobai.service.impl.GoodsTypeServiceImpl;
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
 * 日期： 2020/6/24
 * 时间： 8:45
 */
@WebServlet("/GoodsTypeSelectServlet")
public class GoodsTypeSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PageUtil pageUtil = new PageUtil();
        ServletContext servletContext = request.getServletContext();
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        int count = goodsTypeService.goodsTypeCount();
        String pNo = request.getParameter("pageNo");
        if (pNo == null) {
            pNo = "1";
        }
        int pageNo = Integer.parseInt(pNo);
        int pageSize = 3;
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(count);
        int pageCount = pageUtil.getPageCount();
        List<GoodsType> goodsTypes = goodsTypeService.goodsTypeSelect(pageNo,pageSize);
        request.setAttribute("list", goodsTypes);
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("pageCount", pageCount);
        request.getRequestDispatcher("/after/goods_type_list.jsp").forward(request, response);

    }
}
