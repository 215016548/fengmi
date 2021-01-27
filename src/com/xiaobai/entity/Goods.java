package com.xiaobai.entity;

/**
 * 作者： 小白
 * 日期： 2020/6/24
 * 时间： 19:27
 */

import java.util.Date;

public class Goods {
    private int id;
    private String goodsName;
    private double price;
    private String imgPath;
    private Date deployDate;
    private String description;
    private int typeId;
    private GoodsType goodstype;

    public Goods() {}

    public Goods(int id, String goodsName, double price, String imgPath, Date deployDate, String description,
                 int typeId, GoodsType goodstype) {
        this.id = id;
        this.goodsName = goodsName;
        this.price = price;
        this.imgPath = imgPath;
        this.deployDate = deployDate;
        this.description = description;
        this.typeId = typeId;
        this.goodstype = goodstype;
    }

    public GoodsType getGoodstype() {
        return goodstype;
    }
    public void setGoodstype(GoodsType goodstype) {
        this.goodstype = goodstype;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImgPath() {
        return imgPath;
    }
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    public Date getDeployDate() {
        return deployDate;
    }
    public void setDeployDate(Date deployDate) {
        this.deployDate = deployDate;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getTypeId() {
        return typeId;
    }
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }



}

