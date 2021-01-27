package com.xiaobai.service.impl;

import com.xiaobai.dao.Impl.OrderDaoImpl;
import com.xiaobai.dao.OrderDao;
import com.xiaobai.entity.Order;
import com.xiaobai.service.OrderService;

import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/28
 * 时间： 19:36
 */
public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    @Override
    public List<Order> fuzzyOrderSelect(int pageNo, int pageSize, String condition) {
        List<Order> list = orderDao.fuzzyOrderSelect(pageNo, pageSize, condition);
        return  list;
    }

    @Override
    public int fuzzyDataCount(String condition) {
        return orderDao.fuzzyDataCount(condition);
    }

    @Override
    public int OrdersDeleteById(int id) {
        return orderDao.OrdersDeleteById(id);
    }
}
