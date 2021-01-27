package com.xiaobai.dao.Impl;

import com.xiaobai.dao.GoodsTypeDao;
import com.xiaobai.entity.GoodsType;
import com.xiaobai.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/24
 * 时间： 9:00
 */
public class GoodsTypeDaoImpl extends BaseDao implements GoodsTypeDao {
    @Override
    public List<GoodsType> goodsTypeSelect(int pageNo, int pageSize) {
        String sql = "select * from t_goodstype where 1 = 1 limit ?, ?";
        Object[] obj = {(pageNo - 1)*pageSize, pageSize};
        List<GoodsType> list = new ArrayList<GoodsType>();
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                GoodsType goodsType = new GoodsType();
                goodsType.setId(resultSet.getInt(1));
                goodsType.setTypename(resultSet.getString(2));
                goodsType.setLevel(resultSet.getInt(3));
                goodsType.setPid(resultSet.getInt(4));
                list.add(goodsType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int goodsTypeCount() {
        String sql = "select count(1) from t_goodstype";
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
    public int goodsTypeAdd(GoodsType goodsType) {
        String sql = "insert into t_goodstype (typename) values (?)";
        Object[] obj = {goodsType.getTypename()};
        return this.setUpdate(sql, obj);
    }

    @Override
    public int selectGoodsType(String typename) {
        String sql = "select * from t_goodstype where typename = ?";
        Object[] obj = {typename};
        int i = 0;
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                i = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int goodsTypeUpdate(GoodsType goodsType) {
        String sql = "update t_goodstype set typename = ? where id = ?";
        Object[] obj = {goodsType.getTypename(), goodsType.getId()};
        int i = this.setUpdate(sql, obj);
        return i;
    }

    @Override
    public GoodsType getGoodsTypeById(int id) {
        String sql = "select * from t_goodstype where id = ?";
        Object[] obj = {id};
        GoodsType goodsType = new GoodsType();
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                goodsType.setId(resultSet.getInt(1));
                goodsType.setTypename(resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsType;
    }

    @Override
    public int goodsTypeDelete(int id) {
        String sql = "delete from t_goodstype where id = ?";
        Object[] obj = {id};
        return this.setUpdate(sql, obj);
    }

    @Override
    public List<GoodsType> TypeSelect() {
        List list=new ArrayList();
        String sql="select *from t_goodstype";
        Object []obj= {};

        try {
            ResultSet rs=this.select(sql, obj);
            while(rs.next()) {
                GoodsType gp=new GoodsType();
                gp.setId(rs.getInt(1));
                gp.setTypename(rs.getString(2));
                list.add(gp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
