package com.learn.springboot.blog.dao;

import com.learn.springboot.blog.entity.RelationShipDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationShipDao {
    /**
     * 根据meta编号获取关联
     * @param metaId
     * @return
     */
    List<RelationShipDomain> findByMetaId(String metaId);

    /**
     * 根据meta编号删除关联
     * @param metaId
     */
    void deleteByMetaId(String metaId);

    /**
     * 获取数量
     * @param contentId
     * @param metaId
     * @return
     */
    Long CountById(@Param("contentId") String contentId, @Param("metaId") String metaId);

    /**
     * 添加
     * @param relationShip
     * @return
     */
    void save(RelationShipDomain relationShip);

    /**
     * 根据文章编号删除关联
     * @param contentId
     */
    void deleteByContentId(String contentId);

    /**
     * 根据文章ID获取关联
     * @param contentId
     */
    List<RelationShipDomain> findByContentId(String contentId);
}
