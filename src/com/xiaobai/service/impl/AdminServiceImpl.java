package com.xiaobai.service.impl;

import com.xiaobai.dao.AdminDao;
import com.xiaobai.dao.Impl.AdminDaoImpl;
import com.xiaobai.entity.Admin;
import com.xiaobai.service.AdminService;

/**
 * 作者： 小白
 * 日期： 2020/6/23
 * 时间： 17:18
 */
public class AdminServiceImpl implements AdminService {
    AdminDao aa = new AdminDaoImpl();

    @Override
    public boolean login(Admin ad) {
        return aa.login(ad);
    }
}
