package com.learn.springboot.blog.dao;

import com.learn.springboot.blog.cond.ContentCond;
import com.learn.springboot.blog.entity.ContentDomain;
import com.learn.springboot.blog.entity.RelationShipDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContentDao {

    void save(ContentDomain contentDomain);

    ContentDomain findById(String id);

    void update(ContentDomain contentDomain);

    List<ContentDomain> findByCond(ContentCond contentCond);

    void deleteById(String id);

    Long countContent();

    List<ContentDomain> findByCategory(@Param("category") String category);

    List<ContentDomain> findByTags(List<RelationShipDomain> cid);
}
