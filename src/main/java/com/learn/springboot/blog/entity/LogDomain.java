package com.learn.springboot.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志表
 */
public class LogDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志主键
     */
    private String id;

    /**
     * 产生的动作
     */
    private String action;

    /**
     * 产生的数据
     */
    private String data;

    /**
     * 发生人id
     */
    private String authorId;

    /**
     * 日志产生的IP
     */
    private String ip;

    /**
     * 日志创建时间
     */
    private Date created;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
