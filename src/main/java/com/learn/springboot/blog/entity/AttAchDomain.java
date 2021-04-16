package com.learn.springboot.blog.entity;

import java.util.Date;

/**
 * 网站图片文件相关表
 */
public class AttAchDomain {
    /**
     * 主键
     */
    private String id;
    /**
     * 文件名称
     */
    private String fname;
    /**
     * 文件类型
     */
    private String ftype;
    /**
     * 文件地址
     */
    private String fkey;
    /**
     * 上传人id
     */
    private String authorId;
    /**
     * 创建时间
     */
    private Date created;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public String getFkey() {
        return fkey;
    }

    public void setFkey(String fkey) {
        this.fkey = fkey;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
