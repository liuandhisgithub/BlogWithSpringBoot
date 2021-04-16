package com.learn.springboot.blog.dao;

import com.learn.springboot.blog.cond.MetaCond;
import com.learn.springboot.blog.dto.MetaDto;
import com.learn.springboot.blog.entity.MetaDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MetaDao {

    void save(MetaDomain metaDomain);

    void update(MetaDomain metaDomain);

    List<MetaDomain> findMetasByCond(MetaCond metaCond);

    MetaDomain findById(@Param("id") String id);

    /**
     * 根据sql查询
     */
    List<MetaDto> selectFromSql(Map<String, Object> parMap);

    void deleteById(String id);

    Long findByType(@Param("type") String type);

    MetaDomain findByName(@Param("type") String type, @Param("name") String name);

}
