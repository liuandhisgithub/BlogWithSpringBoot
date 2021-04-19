package com.learn.springboot.blog.service;

import com.learn.springboot.blog.cond.MetaCond;
import com.learn.springboot.blog.dto.MetaDto;
import com.learn.springboot.blog.entity.MetaDomain;

import java.util.List;

/**
 * 项目相关Service接口
 */
public interface MetaService {
    void save(String type, String name, String metaId);

    List<MetaDto> find(String type, String orderBy, int limit);

    void saveOrUpdate(String contentId, String name, String type);

    void addMetas(String contentId, String names, String type);

    void deleteById(String id);

    List<MetaDomain> find(MetaCond metaCond);

    void addMeta(MetaDomain metaDomain);

    void update(MetaDomain metaDomain);

    Long CountByType(String type);

    MetaDomain findByName(String type, String name);

}
