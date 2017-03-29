package com.lorelib.accesscontrol.infrastructure.stereotype;

import com.lorelib.accesscontrol.infrastructure.helpers.algorithm.IdGenerator;
import com.lorelib.accesscontrol.infrastructure.helpers.utils.DateUtil;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
    protected Date createDate = DateUtil.getCurrentDate();

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
        this.setId(IdGenerator.nextId());
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
