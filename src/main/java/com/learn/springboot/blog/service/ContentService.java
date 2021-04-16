package com.learn.springboot.blog.service;

import com.github.pagehelper.PageInfo;
import com.learn.springboot.blog.cond.ContentCond;
import com.learn.springboot.blog.entity.ContentDomain;
import com.learn.springboot.blog.entity.MetaDomain;

import java.util.List;

public interface ContentService {
    void save(ContentDomain contentDomain);

    ContentDomain findById(String id);

    void updata(ContentDomain contentDomain);

    PageInfo<ContentDomain> findByPage(ContentCond contentCond, int page, int limit);

    void delete(String id);

    List<ContentDomain> findByCategory(String category);

    List<ContentDomain> findByTags(MetaDomain tags);
}
