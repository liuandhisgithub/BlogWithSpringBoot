package java.com.learn.springboot.blog.entity;

import java.util.Date;

/**
 * 文章实体
 * @author liu
 */
public class Article {
    /**
     * 文章id
     */
    private String id;
    /**
     * 作者id
     * 映射为author表中的id
     */
    //TODO author表中会映射userId/adminId，同时存储文章数、作者昵称（也可做为）
    private String authorId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 内容
     */
    private String content;
    /**
     * 关键词(分类)
     */
    private String keyword;
    /**
     * 收藏数
     */
    private Integer star;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}
