package com.lorelib.hawk.infrastructure.helpers.base;

import com.lorelib.hawk.infrastructure.stereotype.DTO;

import java.util.Date;

/**
 * @author listening
 * @description BaseDTO:
 * @create 2017 04 10 17:00.
 */
public class BaseDTO implements DTO {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
