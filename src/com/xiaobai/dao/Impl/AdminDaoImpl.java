package com.xiaobai.dao.Impl;

import com.xiaobai.dao.AdminDao;
import com.xiaobai.entity.Admin;
import com.xiaobai.util.BaseDao;

import java.sql.ResultSet;

/**
 * 作者： 小白
 * 日期： 2020/6/23
 * 时间： 17:12
 */
public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public boolean login(Admin ad) {
        Boolean flag = false;
        String sql = "select * from admin where username = ? and password = ?";
        Object[] obj = {ad.getName(), ad.getPassword()};
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
