package com.xiaobai.dao.Impl;

import com.xiaobai.dao.UserDao;
import com.xiaobai.entity.User;
import com.xiaobai.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/23
 * 时间： 19:14
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<User> fuzzySelectUser(int pageNo, int pageSize, String condition) {
        String sql = "select * from t_user where 1=1 "+condition+" limit ?,?";
        Object[] obj = {(pageNo - 1)*pageSize, pageSize};
        List<User> list = new ArrayList<>();
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setPhone(resultSet.getString(4));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int userFuzzyDataCount(String condition) {
        String sql = "select count(1) from t_user where 1=1 "+condition;
        Object[] obj = {};
        int count = 0;
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int userDeleteById(int id) {
        String sql = "delete from t_user where id = ?";
        Object[] obj = {id};
        return this.setUpdate(sql, obj);
    }

    @Override
    public int userResetPassword(int id) {
        String sql = "update t_user set password = ? where id = ?";
        Object[] obj = {123456,id};
        return this.setUpdate(sql, obj);
    }

    @Override
    public int userAdd(User user) {
        String sql = "insert into t_user (username, password, phone, mail) values (?, ?, ?, ?)";
        Object[] obj = {user.getUsername(), user.getPassword(), user.getPhone(), user.getMail()};
        return this.setUpdate(sql, obj);
    }

    @Override
    public boolean login(User user) {
        Boolean flag = false;
        String sql = "select * from t_user where username = ? and password = ?";
        Object[] obj = {user.getUsername(), user.getPassword()};
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

    @Override
    public int userRegister(User user) {
        String sql = "insert into t_user (username, password, phone, mail) values (?, ?, ?, ?)";
        Object[] obj = {user.getUsername(), user.getPassword(), user.getPhone(), user.getMail()};
        return this.setUpdate(sql,obj);
    }
}
