package com.xiaobai.dao;

import com.xiaobai.entity.Order;

import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/28
 * 时间： 18:49
 */
public interface OrderDao {
    public List<Order> fuzzyOrderSelect(int pageNo, int pageSize,String condition);
    public int fuzzyDataCount(String condition);
    public int OrdersDeleteById(int id);
}
