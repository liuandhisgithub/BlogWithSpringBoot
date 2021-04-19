package com.learn.springboot.blog.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.springboot.blog.dao.AttAchDao;
import com.learn.springboot.blog.dto.AttAchDto;
import com.learn.springboot.blog.entity.AttAchDomain;
import com.learn.springboot.blog.enums.ErrorConstant;
import com.learn.springboot.blog.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttAchServiceImpl implements AttAchService {

    @Autowired
    private AttAchDao attAchDao;

    @Override
    public void save(AttAchDomain attAchDomain) {
        if(null != attAchDomain){
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        }
        attAchDao.save(attAchDomain);
    }

    @Override
    public PageInfo<AttAchDto> findAtts(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AttAchDto> attAchDtoList = attAchDao.list();
        PageInfo<AttAchDto> pageInfo = new PageInfo<>(attAchDtoList);
        return pageInfo;
    }

    @Override
    public AttAchDto findById(String id) {
        if(StringUtils.isNotEmpty(id)){
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        }
        return attAchDao.findById(id);
    }

    @Override
    public void deleteById(String id) {
        if (null == id)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        attAchDao.deleteById(id);
    }
}
