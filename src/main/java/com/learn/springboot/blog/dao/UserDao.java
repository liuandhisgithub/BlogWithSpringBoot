package com.learn.springboot.blog.dao;

import com.learn.springboot.blog.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public List<User> findAll();
}
