package com.xiaobai.servlet;

import com.xiaobai.dao.Impl.OrderDaoImpl;
import com.xiaobai.dao.OrderDao;
import com.xiaobai.entity.Order;
import com.xiaobai.entity.Status;
import com.xiaobai.entity.User;
import com.xiaobai.service.OrderService;
import com.xiaobai.service.impl.OrderServiceImpl;
import com.xiaobai.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/28
 * 时间： 17:45
 */
@WebServlet("/OrderFuzzySelectServlet")
@MultipartConfig
public class OrderFuzzySelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        StringBuffer condition = new StringBuffer();
        PageUtil pageUtil = new PageUtil();
        OrderService orderService = new OrderServiceImpl();
        Order order = new Order();
        Status status = new Status();
        User user = new User();
        OrderDao orderDao = new OrderDaoImpl();

        String username=request.getParameter("username");
        if(username!=null && !"".equals(username)) {
            condition.append(" and username like '%"+username+"%'");
        }
        System.out.println(username);

//        String orderStatus = request.getParameter("dropdownMenuGetValue");
//        if (orderStatus != null || !"".equals(orderStatus)) {
//            condition.append(" and order_status like '%"+orderStatus+"%'");
//        }

        int dateCount = orderService.fuzzyDataCount(condition.toString());
        String pNo=request.getParameter("pageNo");
        if (pNo == null) {
            pNo = "1";
        }
        int pageNo = Integer.parseInt(pNo);
        int pageSize = 5;
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(dateCount);
        int pageCount = pageUtil.getPageCount();

        List<Order> list =  orderService.fuzzyOrderSelect(pageNo, pageSize, condition.toString());
        request.setAttribute("list", list);
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("dateCount", dateCount);

        request.getRequestDispatcher("/after/order_processing_list.jsp").forward(request, response);
    }
}
