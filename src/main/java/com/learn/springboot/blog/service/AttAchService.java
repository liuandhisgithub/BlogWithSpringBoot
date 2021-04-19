package com.learn.springboot.blog.service;

import com.github.pagehelper.PageInfo;
import com.learn.springboot.blog.dto.AttAchDto;
import com.learn.springboot.blog.entity.AttAchDomain;

public interface AttAchService {

    void save(AttAchDomain attAchDomain);

    PageInfo<AttAchDto> findAtts(Integer pageNum, Integer pageSize);

    AttAchDto findById(String id);

    void deleteById(String id);

}
