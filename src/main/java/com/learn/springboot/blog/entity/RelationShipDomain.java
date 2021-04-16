package com.learn.springboot.blog.entity;
/**
 * 文章关联信息表
 */
public class RelationShipDomain {

    /**
     * 文章主键
     */
    private String contentId;

    /**
     * 项目编号
     */
    private String metaId;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getMetaId() {
        return metaId;
    }

    public void setMetaId(String metaId) {
        this.metaId = metaId;
    }
}
