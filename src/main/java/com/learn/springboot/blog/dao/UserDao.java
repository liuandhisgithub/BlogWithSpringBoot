package com.learn.springboot.blog.dao;

import com.learn.springboot.blog.entity.UserDomain;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    /**
     * 根据用户名密码获取用户信息
     * @param username  用户名
     * @param password  密码
     * @return
     */
    UserDomain findByCond(@Param("username") String username, @Param("password") String password);
    /**
     * 通过用户ID获取用户信息
     * @param id
     * @return
     */
    UserDomain findById(String id);
    /**
     * 更改用户信息
     * @param userDomain
     * @return
     */
    int update(UserDomain userDomain);
}
