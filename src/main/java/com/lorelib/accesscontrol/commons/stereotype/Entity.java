package com.lorelib.accesscontrol.commons.stereotype;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

public abstract class Entity implements Serializable {
    /**
     * 主键ID
     */
    protected Serializable id;

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
    }

    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
