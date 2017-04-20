package com.lorelib.hawk.infrastructure.helpers.query;

import java.util.List;

/**
 * @author listening
 * @description PageList:
 * @create 2017 04 20 11:24.
 */
public final class PageList {
    private final int totalSize;

    private final List list;

    public PageList(int totalSize, List list) {
        this.totalSize = totalSize;
        this.list = list;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public List getList() {
        return list;
    }
}
