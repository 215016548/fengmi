package com.xiaobai.entity;

/**
 * 作者： 小白
 * 日期： 2020/6/24
 * 时间： 8:51
 */
public class GoodsType {
    private int id;
    private String typename;
    private int level;
    private int pid;

    public GoodsType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
