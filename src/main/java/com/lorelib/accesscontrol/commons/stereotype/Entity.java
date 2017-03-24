package com.lorelib.accesscontrol.commons.stereotype;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 * Created by listening on 2017/3/4.
 */
public abstract class Entity implements Serializable {
    /**
     * 主键ID
     */
    protected long id;

    /**
     * 创建者userId
     */
    protected String createBy;

    /**
     * 创建日期
     */
    protected Date createDate;

    /**
     * 更新者userId
     */
    protected String updateBy;

    /**
     * 更新日期
     */
    protected Date updateDate;

    protected Entity() {
        super();
        this.setId(-1);
    }

    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
