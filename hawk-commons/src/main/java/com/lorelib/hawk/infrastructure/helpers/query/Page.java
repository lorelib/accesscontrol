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
    private int pageIndex = 1;

    /**
     * 一页显示的数据量大小，默认15行数据
     */
    private int pageSize = 15;

    /**
     * 数据库分页的起始索引
     */
    private int pageStart;

    public Page() {
    }

    public Page(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex == 0 ? 1 : pageIndex;
        this.pageSize = pageSize == 0 ? 15 : pageSize;
        this.pageStart = (this.pageIndex - 1) * this.pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public Page setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Page setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = (pageIndex - 1) * pageSize;
    }
}
