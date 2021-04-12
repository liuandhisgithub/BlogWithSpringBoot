package com.learn.springboot.blog.dao;

import com.learn.springboot.blog.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserDao {

    List<User> findAll();

    void save(User user);

    User findByUserNameAndPassword(@Param("userName")String userName, @Param("password")String password);
}
