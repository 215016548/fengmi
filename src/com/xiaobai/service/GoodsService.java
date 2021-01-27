package com.xiaobai.service;

import com.xiaobai.entity.Goods;

import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/24
 * 时间： 19:39
 */
public interface GoodsService {
    public List<Goods> fuzzySelectGoods(int pageNo, int pageSize, String condition);
    public int fuzzyDateCount(String condition);
    public int Goodsadd(Goods goods);
    public int Goodsupdate(Goods goods);
    public Goods getGoodsById(int id);
    public int GoodsDeleteById(int id);
}
