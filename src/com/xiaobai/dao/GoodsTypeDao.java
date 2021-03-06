package com.xiaobai.dao;

import com.xiaobai.entity.GoodsType;

import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/24
 * 时间： 8:48
 */
public interface GoodsTypeDao {
    public List<GoodsType> goodsTypeSelect(int pageNo, int pageSize);
    public int goodsTypeCount();
    public int goodsTypeAdd(GoodsType goodsType);
    public int selectGoodsType(String typename);
    public int goodsTypeUpdate(GoodsType goodsType);
    public GoodsType getGoodsTypeById(int id);
    public int goodsTypeDelete(int id);
    public List<GoodsType> TypeSelect();
}
