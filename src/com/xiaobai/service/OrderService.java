package com.xiaobai.service;

import com.xiaobai.entity.Order;

import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/28
 * 时间： 19:35
 */
public interface OrderService {
    public List<Order> fuzzyOrderSelect(int pageNo, int pageSize, String condition);
    public int fuzzyDataCount(String condition);
    public int OrdersDeleteById(int id);
}
