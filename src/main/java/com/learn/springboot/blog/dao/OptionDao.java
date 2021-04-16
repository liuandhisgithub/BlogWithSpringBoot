package com.learn.springboot.blog.dao;

import com.learn.springboot.blog.entity.OptionsDomain;

import java.util.List;

public interface OptionDao {

    /**
     * 获取网站全部信息
     * @return
     */
    List<OptionsDomain> list();

    /**
     * 更新网站配置
     * @param optionsDomain
     */
    void update(OptionsDomain optionsDomain);

    /**
     * 通过名称网站配置
     * @param name
     * @return
     */
    OptionsDomain findByName(String name);
}
