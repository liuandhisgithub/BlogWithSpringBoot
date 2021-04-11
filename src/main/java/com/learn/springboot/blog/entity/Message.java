package com.learn.springboot.blog.entity;

import java.util.Date;

/**
 * 留言实体
 * @author liu
 */
public class Message {
    private String id;
    /**
     * userid
     */
    private String userId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 内容
     */
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
