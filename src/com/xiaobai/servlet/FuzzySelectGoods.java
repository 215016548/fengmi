package com.xiaobai.servlet;

import com.xiaobai.entity.Goods;
import com.xiaobai.entity.GoodsType;
import com.xiaobai.service.GoodsService;
import com.xiaobai.service.impl.GoodsServiceImpl;
import com.xiaobai.util.DateUtil;
import com.xiaobai.util.PageUtil;

import java.io.IOException;
import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/FuzzySelectGoods")
public class FuzzySelectGoods extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer condition=new StringBuffer();
        PageUtil pageUtil=new PageUtil();
        GoodsService goodsService=new GoodsServiceImpl();
        GoodsType goodsType=new GoodsType();
        Goods goods=new Goods();

        String goodsname=request.getParameter("goodsname");
        if(goodsname!=null && !"".equals(goodsname)) {
            condition.append(" and goodsName like '%"+goodsname+"%'");
        }
        String deployDate1=request.getParameter("deployDate");
        if(deployDate1!=null && !"".equals(deployDate1)) {
            Date deployDate=(Date) DateUtil.convert(deployDate1);
            condition.append(" and deployDate like '%"+deployDate+"%'");
        }
        String typeId=request.getParameter("typeId");
        if(typeId!=null && !"".equals(typeId)) {
            int typeid=Integer.parseInt(typeId);
            condition.append(" and typeId like '%"+typeid+"%'");
        }
        int dateCount=goodsService.fuzzyDateCount(condition.toString());
        String pNo=request.getParameter("pageNo");

        if(pNo==null) {
            pNo="1";
        }
        int pageNo=Integer.parseInt(pNo);
        int pageSize=3;
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(dateCount);
        int pageCount=pageUtil.getPageCount();
        List<Goods> list = goodsService.fuzzySelectGoods(pageNo,pageSize,condition.toString());
        request.setAttribute("list", list);
        request.setAttribute("typeId",typeId);
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("dateCount", dateCount);
        request.getRequestDispatcher("/after/goods_list.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

