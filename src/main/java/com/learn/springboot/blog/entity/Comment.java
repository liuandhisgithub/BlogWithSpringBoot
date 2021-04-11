package com.learn.springboot.blog.entity;

import com.learn.springboot.blog.enums.CommentType;

/**
 * 评论实体
 * @author liu
 */
public class Comment {
    private String id;

    private String creator;
    /**
     * 评论的type（文章、留言）
     */
    private CommentType commentType;
    /**
     * 被评论的文章id
     */
    private String commentedId;

    /**
     * 评论内容
     */
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
    }

    public String getCommentedId() {
        return commentedId;
    }

    public void setCommentedId(String commentedId) {
        this.commentedId = commentedId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
