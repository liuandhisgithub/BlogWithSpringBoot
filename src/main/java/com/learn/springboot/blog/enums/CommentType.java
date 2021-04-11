package com.learn.springboot.blog.enums;

public enum CommentType {
    ARTICLE("文章评论","article"),
    MESSAGE("留言评论","message"),
    ;
    private String title;
    private String CODE;

    CommentType(String title, String CODE) {
        this.title = title;
        this.CODE = CODE;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }
}
