package com.learn.springboot.blog.uril;

import com.sun.glass.ui.Size;

/**
 * 分页参数
 */
public class Pageable {
    private Integer pageSize;
    //从0开始计数，要查第一页传入0
    private Integer pageNo;

    public static Pageable createPage(Integer pageSize,Integer pageNo){
        return new Pageable(pageSize,pageNo);
    }

    private Pageable(Integer pageSize,Integer pageNo){

    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
