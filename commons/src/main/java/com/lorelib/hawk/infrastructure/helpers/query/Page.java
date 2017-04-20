package com.lorelib.hawk.infrastructure.helpers.query;

import java.io.Serializable;

/**
 * @author listening
 * @description Page:
 * @create 2017 04 19 14:05.
 */
public class Page implements Serializable {
    /**
     * 页码，默认第一页
     */
    private Integer pageIndex = 1;

    /**
     * 一页显示的数据量大小，默认15行数据
     */
    private Integer pageSize = 15;

    /**
     * 数据库分页的起始索引
     */
    private Integer pageStart;

    public Page() {
    }

    public Page(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.pageStart = (pageIndex - 1) * pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public Page setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Page setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = (pageIndex - 1) * pageSize;
    }
}
