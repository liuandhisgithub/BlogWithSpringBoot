package com.learn.springboot.blog.dao;

import com.learn.springboot.blog.cond.CommentCond;
import com.learn.springboot.blog.entity.CommentDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentDao {

    void save(CommentDomain commentDomain);

    List<CommentDomain> findByContentId(String contentId);

    void deleteById(String id);

    Long countComment();

    List<CommentDomain>  list(CommentCond commentCond);

    CommentDomain findById(@Param("id") String id);

    void update(CommentDomain commentDomain);
}
