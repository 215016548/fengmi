package com.xiaobai.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.xiaobai.entity.Goods;
import com.xiaobai.entity.GoodsType;
import com.xiaobai.service.GoodsService;
import com.xiaobai.service.GoodsTypeService;
import com.xiaobai.service.impl.GoodsServiceImpl;
import com.xiaobai.service.impl.GoodsTypeServiceImpl;

/**
 * Servlet implementation class AddGoodsServlet
 */
@WebServlet("/AddGoodsServlet")
@MultipartConfig
public class AddGoodsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        GoodsService gs=new GoodsServiceImpl();
        Goods gd=new Goods();
        //名字
        String goodsName=request.getParameter("goodsName");
        if(!goodsName.equals(goodsName)||"".equals(goodsName)) {
            gd.setGoodsName("5G手机");
        }else {
            gd.setGoodsName(goodsName);

        }
        System.out.println("名字"+goodsName);
        //价格
        String price1= request.getParameter("price");
        if(!price1.equals(price1)||"".equals(price1)) {
            gd.setPrice(9999);
        }else {
            Double price=Double.parseDouble(price1);
            gd.setPrice(price);
        }
        //图片
        Part part=request.getPart("imgPath");
        String imPath=part.getSubmittedFileName();
        if(!imPath.equals(imPath)||"".equals(imPath)) {
            String img="default.jpg";
            //part.write("D:\\Eclipse\\apache-tomcat-9.0.24-windows-x64\\apache-tomcat-9.0.24\\webapps\\uploadfile\\images\\"+img);
            gd.setImgPath(img);
        }else {
            String imgPath=UUID.randomUUID().toString()+imPath;
            part.write("D:\\Eclipse\\apache-tomcat-9.0.24-windows-x64\\apache-tomcat-9.0.24\\webapps\\uploadfile\\images\\"+imgPath);
            gd.setImgPath(imgPath);
        }
        //类型
        String typeId=request.getParameter("typeId");
        if(!typeId.equals(typeId)||"".equals(typeId)) {
            gd.setTypeId(5);
        }else {
            int id=Integer.parseInt(typeId);
            gd.setTypeId(id);
        }
        //描述
        String comment=request.getParameter("comment");
        if(!typeId.equals(typeId)||"".equals(typeId)) {
            gd.setDescription("这是一个测试商品");
        }else {

            gd.setDescription(comment);
        }
        //id
        int rs=0;
        String uid=request.getParameter("id");
        if(!uid.equals(uid)||"".equals(uid)) {
            rs= gs.Goodsadd(gd);
        }else {
            int id1=Integer.parseInt(uid);
            gd.setId(id1);
            rs=gs.Goodsupdate(gd);
        }
        if(rs>0) {
            request.getRequestDispatcher("/FuzzySelectGoods").forward(request, response);
        }else {
            System.out.println("失败");
        }

    }

}
