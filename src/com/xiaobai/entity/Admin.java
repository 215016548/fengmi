package com.xiaobai.entity;

/**
 * 作者： 小白
 * 日期： 2020/6/23
 * 时间： 17:10
 */
public class Admin {
    private int id;
    private String name;
    private String password;

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
