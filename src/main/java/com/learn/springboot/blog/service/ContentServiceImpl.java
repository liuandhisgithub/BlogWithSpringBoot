package com.learn.springboot.blog.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.springboot.blog.dao.WebConst;
import org.apache.commons.lang3.StringUtils;
import com.learn.springboot.blog.cond.ContentCond;
import com.learn.springboot.blog.dao.CommentDao;
import com.learn.springboot.blog.dao.ContentDao;
import com.learn.springboot.blog.dao.RelationShipDao;
import com.learn.springboot.blog.entity.CommentDomain;
import com.learn.springboot.blog.entity.ContentDomain;
import com.learn.springboot.blog.entity.MetaDomain;
import com.learn.springboot.blog.entity.RelationShipDomain;
import com.learn.springboot.blog.enums.ErrorConstant;
import com.learn.springboot.blog.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{

    @Autowired
    private ContentDao contentDao;

    @Autowired
    private RelationShipDao relationShipDao;

    @Autowired
    private CommentDao commentDao;

    @Override
    @Transactional
    public void save(ContentDomain contentDomain) {
        if(null == contentDomain){
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        }
        if(StringUtils.isBlank(contentDomain.getTitle())){
            throw BusinessException.withErrorCode(ErrorConstant.Article.TITLE_CAN_NOT_EMPTY);
        }
        if(contentDomain.getTitle().length() > WebConst.MAX_TITLE_COUNT){
            throw BusinessException.withErrorCode(ErrorConstant.Article.TITLE_IS_TOO_LONG);
        }
        if (StringUtils.isBlank(contentDomain.getContent())){
            throw BusinessException.withErrorCode(ErrorConstant.Article.CONTENT_CAN_NOT_EMPTY);
        }
        if (contentDomain.getContent().length() > WebConst.MAX_CONTENT_COUNT){
            throw BusinessException.withErrorCode(ErrorConstant.Article.CONTENT_IS_TOO_LONG);
        }
        // 取到标签和分类
        String tags = contentDomain.getTags();
        String categories = contentDomain.getCategories();

        // 添加文章
        contentDao.save(contentDomain);
        //TODO 添加分类和标签
    }

    @Override
    public ContentDomain findById(String id) {
        if(StringUtils.isEmpty(id)){
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        }
        return contentDao.findById(id);
    }

    @Override
    public void updata(ContentDomain contentDomain) {
        String tags = contentDomain.getTags();
        String categories = contentDomain.getCategories();

        if(null != contentDomain && StringUtils.isNotEmpty(contentDomain.getId())){
            contentDao.update(contentDomain);
        }
        String id = contentDomain.getId();
        //删掉relationShip后并没有添加新的relationShip
        if(StringUtils.isNotEmpty(tags)){
            relationShipDao.deleteByContentId(id);
            //TODO
        }

    }

    @Override
    public PageInfo<ContentDomain> findByPage(ContentCond contentCond, int page, int limit) {
        if(null == contentCond){
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        }
        PageHelper.startPage(page,limit);
        List<ContentDomain> contentDomainList = contentDao.findByCond(contentCond);
        PageInfo<ContentDomain> pageInfo = new PageInfo<>(contentDomainList);
        return pageInfo;
    }

    @Override
    public void delete(String id) {
        if(StringUtils.isEmpty(id)){
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        }
        contentDao.deleteById(id);

        // 同时要删除该 文章下的所有评论
        List<CommentDomain> comments = commentDao.findByContentId(id);
        if (null != comments && comments.size() > 0) {
            comments.forEach(comment -> {
                commentDao.deleteById(comment.getId());
            });
        }

        // 删除标签和分类关联
        List<RelationShipDomain> relationShips = relationShipDao.findByContentId(id);
        if (null != relationShips && relationShips.size() > 0) {
            relationShipDao.deleteByContentId(id);
        }
    }

    @Override
    public List<ContentDomain> findByCategory(String category) {
        if(null == category){
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        }
        return contentDao.findByCategory(category);
    }

    @Override
    public List<ContentDomain> findByTags(MetaDomain tags) {
        if(null == tags){
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        }
        List<RelationShipDomain> relationShipDomainList = relationShipDao.findByMetaId(tags.getId());
        if(null != relationShipDomainList && relationShipDomainList.size() > 0){
            return contentDao.findByTags(relationShipDomainList);
        }
        return new ArrayList<>();
    }
}
