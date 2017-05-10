package com.lorelib.hawk.infrastructure.helpers.query;

import com.lorelib.hawk.infrastructure.helpers.annotation.TypeAlias;

import java.io.Serializable;

/**
 * @author listening
 * @description Criteria: 查询条件
 * @create 2017 04 14 13:39.
 */
public class Criteria<T> implements Serializable, TypeAlias {
    /**
     * where条件.
     */
    private T where;

    /**
     * 排序.
     */
    private Order order;

    /**
     * 分页.
     */
    private Page page = new Page();

    public Criteria() {

    }

    public Criteria(T where, Page page) {
        this.where = where;
        this.page = page;
    }

    public Criteria(T where, Order order, Page page) {
        this(where, page);
        this.order = order;
    }

    public T getWhere() {
        return this.where;
    }

    public Criteria setWhere(T where) {
        this.where = where;
        return this;
    }

    public Order getOrder() {
        return this.order;
    }

    public Criteria setOrder(Order order) {
        this.order = order;
        return this;
    }

    public Page getPage() {
        return this.page;
    }

    public Criteria setPage(Page page) {
        this.page = page;
        return this;
    }
}
