package com.learn.springboot.blog.dao;

import com.learn.springboot.blog.entity.LogDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogDao {
    void save(LogDomain logDomain);

    List<LogDomain> list();
}
