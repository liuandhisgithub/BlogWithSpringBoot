package com.learn.springboot.blog.dao;

import com.learn.springboot.blog.entity.Article;
import com.learn.springboot.blog.uril.Pageable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDao {

    void save(Article article);

//    void updata(Article article);

    List<Article> findAll(Pageable pageable);

    List<Article> findByArticle(String article);

    Article findById(String id);
}
