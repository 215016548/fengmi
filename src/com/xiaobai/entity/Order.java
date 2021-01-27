package com.xiaobai.entity;

import java.util.Date;

/**
 * 作者： 小白
 * 日期： 2020/6/28
 * 时间： 18:52
 */
public class Order {
    private int id;
    private int orderCode;
    private int totalPrice;
    private Date createDate;
    private int uid;
    private Status status;
    private User user;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode=" + orderCode +
                ", totalPrice=" + totalPrice +
                ", createDate=" + createDate +
                ", uid=" + uid +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
