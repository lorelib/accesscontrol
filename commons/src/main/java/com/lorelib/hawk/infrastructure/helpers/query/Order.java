package com.lorelib.hawk.infrastructure.helpers.query;

import java.io.Serializable;

/**
 * @author listening
 * @description Order: 定义5个排序字段，一般来讲排序字段不会太多，5个已经比较多了
 * @create 2017 04 19 14:05.
 */
public class Order implements Serializable {
    /**
     * 是否降序
     */
    private boolean desc;

    /**
     * 排序字段1
     */
    private Object field1;

    /**
     * 排序字段2
     */
    private Object field2;

    /**
     * 排序字段3
     */
    private Object field3;

    /**
     * 排序字段4
     */
    private Object field4;

    /**
     * 排序字段5
     */
    private Object field5;

    public Order(boolean desc, Object field1) {
        this.desc = desc;
        this.field1 = field1;
    }

    public Order setField1(Object field1) {
        this.field1 = field1;
        return this;
    }

    public Order setField2(Object field2) {
        this.field2 = field2;
        return this;
    }

    public Order setField3(Object field3) {
        this.field3 = field3;
        return this;
    }

    public Order setField4(Object field4) {
        this.field4 = field4;
        return this;
    }

    public Order setField5(Object field5) {
        this.field5 = field5;
        return this;
    }

    public boolean isDesc() {
        return desc;
    }

    public void setDesc(boolean desc) {
        this.desc = desc;
    }

    public Object getField1() {
        return field1;
    }

    public Object getField2() {
        return field2;
    }

    public Object getField3() {
        return field3;
    }

    public Object getField4() {
        return field4;
    }

    public Object getField5() {
        return field5;
    }
}
