package com.lorelib.hawk.infrastructure.helpers.base;

import com.lorelib.hawk.infrastructure.stereotype.Dto;

import java.util.Date;

/**
 * @author listening
 * @description BaseDto:
 * @create 2017 04 10 17:00.
 */
public class BaseDto implements Dto {
    /**
     * 主键ID.
     */
    protected long id;

    /**
     * 创建者userId.
     */
    protected String createBy;

    /**
     * 创建日期.
     */
    protected Date createDate;

    /**
     * 更新者userId.
     */
    protected String updateBy;

    /**
     * 更新日期.
     */
    protected Date updateDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return this.createDate == null ? null : (Date) this.createDate.clone();
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate == null ? null : (Date) createDate.clone();
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return this.updateDate == null ? null : (Date) this.updateDate.clone();
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate == null ? null : (Date) updateDate.clone();
    }
}
