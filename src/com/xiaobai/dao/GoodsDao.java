package com.xiaobai.dao;

import com.xiaobai.entity.Goods;

import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/24
 * 时间： 19:27
 */
public interface GoodsDao {
    public List<Goods> fuzzySelectGoods(int pageNo, int pageSize, String condition);
    public int fuzzyDateCount(String condition);
    public Goods getGoodsById(int id);
    public List<Goods> GoodsSelect();
    public int GoodsDeleteById(int id);
    public int Goodsadd(Goods goods);
    public int Goodsupdate(Goods gd);
}
