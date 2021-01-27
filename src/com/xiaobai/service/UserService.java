package com.xiaobai.service;

import com.xiaobai.entity.User;

import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/23
 * 时间： 19:25
 */
public interface UserService {
    public List<User> fuzzySelectUser(int pageNo, int pageSize, String condition);
    public int userFuzzyDataCount(String condition);
    public int userDeleteById(int id);
    public int userResetPassword(int id);
    public int userAdd(User user);
    public boolean login(User user);
    public int userRegister(User user);
}
