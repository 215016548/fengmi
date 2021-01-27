package com.xiaobai.dao.Impl;

import com.xiaobai.dao.GoodsDao;
import com.xiaobai.entity.Goods;
import com.xiaobai.entity.GoodsType;
import com.xiaobai.util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 小白
 * 日期： 2020/6/24
 * 时间： 19:31
 */

//import org.eclipse.jdt.internal.compiler.batch.Main;


public class GoodsDaoImpl extends BaseDao implements GoodsDao {


    public int Goodsadd(Goods goods) {
        String sql = "insert into t_goods(goodsname,price,imgPath,comment,typeId) values(?,?,?,?,?)";
        Object[] obj = {goods.getGoodsName(), goods.getPrice(), goods.getImgPath(), goods.getDescription(), goods.getTypeId()};
        return this.setUpdate(sql, obj);
    }


    public int Goodsupdate(Goods goods) {
        String sql = "update t_goods set goodsName=?,price=?,imgPath=?,comment=?,typeId=? where id=?;";
        Object[] obj = {goods.getGoodsName(), goods.getPrice(), goods.getImgPath(), goods.getDescription(), goods.getTypeId(), goods.getId()};
        return this.setUpdate(sql, obj);
    }

    @Override
    public int GoodsDeleteById(int id) {
        String sql = "delete from t_goods where id=? ";
        Object[] obj = {id};
        return this.setUpdate(sql, obj);

    }

    @Override
    public List<Goods> GoodsSelect() {
        String sql = "select * from t_goods,t_goodstype where t_goods.typeid=t_goodstype.id";
        Object[] obj = {};
        List list = new ArrayList();
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()) {
                Goods gd = new Goods();
                gd.setId(rs.getInt(1));
                gd.setGoodsName(rs.getString(2));
                gd.setPrice(rs.getDouble(3));
                gd.setImgPath(rs.getString(4));
                gd.setDeployDate(rs.getDate(5));
                gd.setDescription(rs.getString(6));
                gd.setTypeId(rs.getInt(7));
                GoodsType gp = new GoodsType();
                gp.setId(rs.getInt("t_goodstype.id"));
                gp.setTypename(rs.getString("typename"));
                gd.setGoodstype(gp);
                list.add(gd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Goods getGoodsById(int id) {
        String sql = "select * from t_goods ,t_goodstype where t_goods.typeid = t_goodstype.id and  t_goods.id=?";
        Object[] obj = {id};
        Goods goods = new Goods();
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()) {
                goods.setId(rs.getInt(1));
                goods.setGoodsName(rs.getString(2));
                goods.setPrice(rs.getDouble(3));
                goods.setImgPath(rs.getString(4));
                goods.setDeployDate(rs.getDate(5));
                goods.setDescription(rs.getString(6));
                goods.setTypeId(rs.getInt(7));
                GoodsType goodsType = new GoodsType();
                goodsType.setId(rs.getInt("t_goodstype.id"));
                goodsType.setTypename(rs.getString("typename"));
                goods.setGoodstype(goodsType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods;
    }

    public List<Goods> GoodsSelect(String goodsname, int typeid) {
        String sql = "select * from t_goods,t_goodstype where t_goods.typeid = t_goodstype.id and goodsname=? and typeId=?";
        Object[] obj = {goodsname, typeid};
        List list = new ArrayList();
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setId(rs.getInt(1));
                goods.setGoodsName(rs.getString(2));
                goods.setPrice(rs.getDouble(3));
                goods.setImgPath(rs.getString(4));
                goods.setDeployDate(rs.getDate(5));
                goods.setDescription(rs.getString(6));
                goods.setTypeId(rs.getInt(7));
                GoodsType goodsType = new GoodsType();
                goodsType.setId(rs.getInt("t_goodstype.id"));
                goodsType.setTypename(rs.getString("typename"));
                goods.setGoodstype(goodsType);
                list.add(goods);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public List<Goods> GoodsSelectTypeid(int typeid) {
        String sql = "select * from t_goods,t_goodstype where t_goods.typeid = t_goodstype.id and typeId=?";
        Object[] obj = {typeid};
        List list = new ArrayList();
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setId(rs.getInt(1));
                goods.setGoodsName(rs.getString(2));
                goods.setPrice(rs.getDouble(3));
                goods.setImgPath(rs.getString(4));
                goods.setDeployDate(rs.getDate(5));
                goods.setDescription(rs.getString(6));
                goods.setTypeId(rs.getInt(7));
                GoodsType goodsType = new GoodsType();
                goodsType.setId(rs.getInt("t_goodstype.id"));
                goodsType.setTypename(rs.getString("typename"));
                goods.setGoodstype(goodsType);
                list.add(goods);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public List<Goods> fuzzySelectGoods(int pageNo, int pageSize, String condition) {
        String sql = "select *  from t_goods,t_goodstype where t_goods.typeid=t_goodstype.id " + condition + " limit ?,?";
        Object[] obj = {(pageNo - 1) * pageSize, pageSize};
        List list = new ArrayList();
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setId(rs.getInt(1));
                goods.setGoodsName(rs.getString(2));
                goods.setPrice(rs.getDouble(3));
                goods.setImgPath(rs.getString(6));
                goods.setDeployDate(rs.getDate(5));
                goods.setDescription(rs.getString(7));
                goods.setTypeId(rs.getInt(8));
                GoodsType goodsType = new GoodsType();
                goodsType.setId(rs.getInt("t_goodstype.id"));
                goodsType.setTypename(rs.getString("typename"));
                goods.setGoodstype(goodsType);
                list.add(goods);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int fuzzyDateCount(String condition) {
        String sql = "select count(1) from  t_goods where 1=1 " + condition;
        Object[] obj = {};
        int count = 0;
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int TyIdCount(int typeid) {
        String sql = "select count(1) from t_goods,t_goodstype where t_goods.typeid=t_goodstype.id and typeId=?";
        Object[] obj = {typeid};
        int count = 0;
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;

    }


}

