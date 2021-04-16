package com.learn.springboot.blog.cond;

import java.util.Date;

public class CommentCond {
    /**
     * 状态
     */
    private String status;
    /**
     * 开始时间戳
     */
    private Date startTime;
    /**
     * 结束时间戳
     */
    private Date endTime;

    /**
     * 父评论编号
     */
    private String parent;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
