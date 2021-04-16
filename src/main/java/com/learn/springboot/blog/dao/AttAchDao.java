package com.learn.springboot.blog.dao;

import com.learn.springboot.blog.dto.AttAchDto;
import com.learn.springboot.blog.entity.AttAchDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件相关Dao接口
 */
@Mapper
public interface AttAchDao {
    /**
     * 添加单个附件文件
     */
    void save(AttAchDomain attAchDomain);

    /**
     * 返回所有的附件信息
     * @return
     */
    List<AttAchDto> list();

    /**
     * 获取附件总数
     * @return
     */
    Long attAchCount();

    /**
     * 通过id获取附件信息
     * @param id
     * @return
     */
    AttAchDto findById(@Param("id") String id);

    /**
     * 通过id删除附件信息
     */
    void deleteById(@Param("id") String id);

}
