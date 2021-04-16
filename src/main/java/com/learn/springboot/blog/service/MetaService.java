package com.learn.springboot.blog.service;

import com.learn.springboot.blog.dto.MetaDto;

import java.util.List;

/**
 * 项目相关Service接口
 */
public interface MetaService {
    void save(String type, String name);

    List<MetaDto> find(String type, String orderBy, int limit);


}
