package com.learn.springboot.blog.service;

import com.learn.springboot.blog.cond.MetaCond;
import com.learn.springboot.blog.dao.MetaDao;
import com.learn.springboot.blog.dao.RelationShipDao;
import com.learn.springboot.blog.dao.WebConst;
import com.learn.springboot.blog.dto.MetaDto;
import com.learn.springboot.blog.entity.ContentDomain;
import com.learn.springboot.blog.entity.MetaDomain;
import com.learn.springboot.blog.entity.RelationShipDomain;
import com.learn.springboot.blog.enums.ErrorConstant;
import com.learn.springboot.blog.enums.Types;
import com.learn.springboot.blog.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MetaServiceImpl implements MetaService {

    @Autowired
    private MetaDao metaDao;

    @Autowired
    private RelationShipDao relationShipDao;

    @Autowired
    private ContentService contentService;

    @Override
    @Transactional
    public void save(String type, String name, String meatId) {
        if(StringUtils.isBlank(type) || StringUtils.isBlank(name)){
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        }

        MetaCond metaCond = new MetaCond();
        metaCond.setName(name);
        metaCond.setType(type);
        List<MetaDomain> metaDomains = metaDao.findMetasByCond(metaCond);
        if(null != metaDomains && metaDomains.size() != 0){
            throw BusinessException.withErrorCode(ErrorConstant.Meta.META_IS_EXIST);
        }
        MetaDomain metaDomain = new MetaDomain();
        metaDomain.setName(name);
        if(meatId != null){
            MetaDomain _meta = metaDao.findById(meatId);
            if(null != _meta){
                metaDomain.setId(meatId);
            }
            metaDao.update(metaDomain);
        } else {
            metaDomain.setType(type);
            metaDao.save(metaDomain);
        }
    }

    @Override
    public List<MetaDto> find(String type, String orderBy, int limit) {
        if(StringUtils.isNotBlank(type)){
            if(StringUtils.isBlank(orderBy)){
                orderBy = "count desc";
            }
            if(limit < 1 || limit > WebConst.MAX_POSTS){
                limit = 10;
            }
            Map<String, Object> paraMap = new HashMap<>();
            paraMap.put("type", type);
            paraMap.put("order", orderBy);
            paraMap.put("limit",limit);
            return metaDao.selectFromSql(paraMap);
        }
        return null;
    }

    @Override
    @Transactional
    public void saveOrUpdate(String contentId, String name, String type) {
        MetaCond metaCond = new MetaCond();
        metaCond.setName(name);
        metaCond.setType(type);
        List<MetaDomain> metaDomainList = metaDao.findMetasByCond(metaCond);

        if(null != metaDomainList && metaDomainList.size() > 1 ){
            throw BusinessException.withErrorCode(ErrorConstant.Meta.NOT_ONE_RESULT);
        }
        String mid ;
        if(metaDomainList != null && metaDomainList.size() == 1){
            mid = metaDomainList.get(0).getId();
        } else{
            MetaDomain metaDomain = new MetaDomain();
            metaDomain.setSlug(name);
            metaDomain.setName(name);
            metaDomain.setType(type);
            addMeta(metaDomain);
            mid = metaDomain.getId();
        }
        if(StringUtils.isNotEmpty(mid)){
            Long count = relationShipDao.CountById(contentId, mid);
            if(count == 0){
                RelationShipDomain relationShipDomain = new RelationShipDomain();
                relationShipDomain.setContentId(contentId);
                relationShipDomain.setMetaId(mid);
                relationShipDao.save(relationShipDomain);
            }
        }
    }

    @Override
    @Transactional
    public void addMetas(String contentId, String names, String type) {
        if(StringUtils.isBlank(contentId)){
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        }
        if(StringUtils.isBlank(names) && StringUtils.isBlank(type)) {
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        }
        String[] nameArr = StringUtils.split(names, ",");
        for(String name : nameArr){
            this.saveOrUpdate(contentId,name,type);
        }

    }

    @Override
    @Transactional
    public void deleteById(String id) {
        if (StringUtils.isNotEmpty(id))
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);

        // 通过ID找到该项目
        MetaDomain meta = metaDao.findById(id);
        if (null != meta) {
            String type = meta.getType();
            String name = meta.getName();
            // 删除meta
            metaDao.deleteById(id);
            // 需要把相关的数据删除
            List<RelationShipDomain> relationShips = relationShipDao.findByMetaId(id);
            // 判断是否查找到项目编号
            if (null != relationShips && relationShips.size() > 0) {
                for (RelationShipDomain relationShip : relationShips) {
                    // 通过关联表的文章ID找到该文章
                    ContentDomain contentDomain = contentService.findById(relationShip.getContentId());
                    // 判断是否找到文章
                    if (null != contentDomain) {
                        ContentDomain temp = new ContentDomain();
                        temp.setId(relationShip.getContentId());
                        if (type.equals(Types.CATEGORY.getType())) {
                            temp.setCategories(removeMeta(name,contentDomain.getCategories()));
                        }
                        if (type.equals(Types.TAG.getType())) {
                            temp.setTags(removeMeta(name,contentDomain.getTags()));
                        }
                        // 将删除的标签和分类从文章表中去除
                        contentService.updata(temp);
                    }
                }
                // 删除关联meta
                relationShipDao.deleteByMetaId(id);
            }
        }
    }

    private String removeMeta(String name, String metas){
        String[] ms = StringUtils.split(metas, ",");
        StringBuilder buf = new StringBuilder();
        for(String m : ms){
            if(!name.equals(m)){
                buf.append(",").append(m);
            }
        }
        if(buf.length() > 0){
            return buf.substring(1);
        }
        return "";
    }

    @Override
    public List<MetaDomain> find(MetaCond metaCond) {
        return metaDao.findMetasByCond(metaCond);
    }

    @Override
    @Transactional
    public void addMeta(MetaDomain metaDomain) {
        if(null == metaDomain){
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        }
        metaDao.save(metaDomain);
    }

    @Override
    @Transactional
    public void update(MetaDomain metaDomain) {
        if (null == metaDomain || null == metaDomain.getId())
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        metaDao.update(metaDomain);
    }

    @Override
    public Long CountByType(String type) {
        if (null == type)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        return metaDao.countByType(type);
    }

    @Override
    public MetaDomain findByName(String type, String name) {
        if (null == name)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        return metaDao.findByName(type,name);
    }
}
