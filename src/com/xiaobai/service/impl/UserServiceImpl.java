package com.xiaobai.service.impl;

import com.xiaobai.dao.Impl.UserDaoImpl;
import com.xiaobai.dao.UserDao;
import com.xiaobai.entity.User;
import com.xiaobai.service.UserService;

import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/23
 * 时间： 19:27
 */
public class UserServiceImpl implements UserService {
    @Override
    public List<User> fuzzySelectUser(int pageNo, int pageSize, String condition) {
        UserDao userDao = new UserDaoImpl();
        return userDao.fuzzySelectUser(pageNo, pageSize,condition);
    }

    @Override
    public int userFuzzyDataCount(String condition) {
        UserDao userDao = new UserDaoImpl();
        return userDao.userFuzzyDataCount(condition);
    }

    @Override
    public int userDeleteById(int id) {
        UserDao userDao = new UserDaoImpl();
        return userDao.userDeleteById(id);
    }

    @Override
    public int userResetPassword(int id) {
        UserDao userDao = new UserDaoImpl();
        return userDao.userResetPassword(id);
    }

    @Override
    public int userAdd(User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.userAdd(user);
    }

    @Override
    public boolean login(User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.login(user);
    }

    @Override
    public int userRegister(User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.userRegister(user);
    }
}
