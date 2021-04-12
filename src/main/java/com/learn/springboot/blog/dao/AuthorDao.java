package com.learn.springboot.blog.dao;

import com.learn.springboot.blog.entity.Author;
import com.learn.springboot.blog.uril.Pageable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthorDao {
    void save(Author author);

    List<Author> findAll(Pageable pageable);

    Author findById(String id);
}
