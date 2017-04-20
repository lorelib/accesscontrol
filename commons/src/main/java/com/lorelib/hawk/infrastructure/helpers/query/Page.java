package com.lorelib.hawk.infrastructure.helpers.query;

import java.io.Serializable;

/**
 * @author listening
 * @description Page:
 * @create 2017 04 19 14:05.
 */
public class Page implements Serializable {
    /**
     * 页码，默认0第一页
     */
    private Integer pageIndex = 0;

    /**
     * 一页显示的数据量大小，默认15行数据
     */
    private Integer pageSize = 15;

    public Page() {
    }

    public Page(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex - 1; // 前端传递的页面均是以1开头，故此处减1
        this.pageSize = pageSize;
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
}
