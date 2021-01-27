package com.xiaobai.service.impl;

import com.xiaobai.dao.GoodsDao;
import com.xiaobai.dao.Impl.GoodsDaoImpl;
import com.xiaobai.entity.Goods;
import com.xiaobai.service.GoodsService;

import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/24
 * 时间： 19:44
 */
public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    public List<Goods> fuzzySelectGoods(int pageNo, int pageSize, String condition) {
        return goodsDao.fuzzySelectGoods(pageNo, pageSize, condition);
    }

    @Override
    public int fuzzyDateCount(String condition) {
        return goodsDao.fuzzyDateCount(condition);
    }

    @Override
    public int Goodsadd(Goods goods) {
        return goodsDao.Goodsadd(goods);
    }

    @Override
    public int Goodsupdate(Goods goods) {
        return goodsDao.Goodsupdate(goods);
    }

    @Override
    public Goods getGoodsById(int id) {
        return goodsDao.getGoodsById(id);
    }

    @Override
    public int GoodsDeleteById(int id) {
        return goodsDao.GoodsDeleteById(id);
    }
}
