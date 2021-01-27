package com.xiaobai.service.impl;

import com.xiaobai.dao.GoodsTypeDao;
import com.xiaobai.dao.Impl.GoodsTypeDaoImpl;
import com.xiaobai.entity.GoodsType;
import com.xiaobai.service.GoodsTypeService;

import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/24
 * 时间： 9:07
 */
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Override
    public List<GoodsType> goodsTypeSelect(int pageNo, int pageSize) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        return goodsTypeDao.goodsTypeSelect(pageNo, pageSize);
    }

    @Override
    public int goodsTypeCount() {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        return goodsTypeDao.goodsTypeCount();
    }

    @Override
    public int goodsTypeAdd(GoodsType goodsType) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        return goodsTypeDao.goodsTypeAdd(goodsType);
    }

    @Override
    public int selectGoodsType(String typename) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        return goodsTypeDao.selectGoodsType(typename);
    }

    @Override
    public int goodsTypeUpdate(GoodsType goodsType) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        return goodsTypeDao.goodsTypeUpdate(goodsType);
    }
    public GoodsType getGoodsTypeById(int id) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        return goodsTypeDao.getGoodsTypeById(id);
    }

    @Override
    public int goodsTypeDelete(int id) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        return goodsTypeDao.goodsTypeDelete(id);
    }

    @Override
    public List<GoodsType> TypeSelect() {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        return goodsTypeDao.TypeSelect();
    }
}
