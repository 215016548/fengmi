package com.xiaobai.dao.Impl;

import com.xiaobai.dao.OrderDao;
import com.xiaobai.entity.Order;
import com.xiaobai.entity.Status;
import com.xiaobai.entity.User;
import com.xiaobai.util.BaseDao;
import com.xiaobai.util.JDBCUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/28
 * 时间： 18:56
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public List<Order> fuzzyOrderSelect(int pageNo, int pageSize, String condition)  {
        String sql = "select * from t_order, t_user, t_status where t_order.uid = t_user.id and t_order.status = t_status.id " + condition + " limit ?, ?";
        Object[] obj = {(pageNo - 1) * pageSize, pageSize};
        List<Order> list = new ArrayList<>();
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setOrderCode(resultSet.getInt("orderCode"));
                order.setTotalPrice(resultSet.getInt("totalPrice"));
                order.setCreateDate(resultSet.getDate("createDate"));
                Status status = new Status();
                status.setId(resultSet.getInt(6));
                status.setOrder_status(resultSet.getString("order_status"));
                order.setStatus(status);
                User user = new User();
                user.setId(resultSet.getInt("uid"));
                user.setUsername(resultSet.getString("username"));
                order.setUser(user);
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int fuzzyDataCount(String condition) {
        String sql = "select count(1) from t_order,t_user where t_order.uid = t_user.id " + condition;
        Object[] obj = {};
        int count = 0;
        try {
            ResultSet resultSet = this.select(sql, obj);
            while(resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int OrdersDeleteById(int id) {
        String sql = "delete from t_order where id = ?";
        Object[] obj = {id};
        return this.setUpdate(sql, obj);
    }

}
