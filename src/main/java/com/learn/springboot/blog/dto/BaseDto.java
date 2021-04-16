package com.learn.springboot.blog.dto;

/**
 * 公共属性
 */
public class BaseDto {
    /**
     * 用户名
     */
    private String userName;
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
