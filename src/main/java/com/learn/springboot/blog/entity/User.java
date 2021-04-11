package com.learn.springboot.blog.entity;

import java.util.Date;

/**
 * 用户表
 * @author liu
 */
public class User {
    /**
     * 用户id
     */
    private String id;
    /**
     * 注册时间
     */
    private Date createTime;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 邮箱
     */
    private String eMail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
