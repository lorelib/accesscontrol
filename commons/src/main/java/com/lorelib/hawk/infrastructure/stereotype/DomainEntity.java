package com.lorelib.hawk.infrastructure.stereotype;

import com.lorelib.hawk.infrastructure.helpers.utils.DateUtil;
import com.lorelib.hawk.infrastructure.helpers.utils.JSONUtil;

import java.util.Date;

/**
 * 基础实体类.
 * Created by listening on 2017/3/4.
 */
public abstract class DomainEntity<T, TID> implements Entity {
    /**
     * 创建者userId.
     */
    protected String createBy;

    /**
     * 创建日期.
     */
    protected Date createDate = DateUtil.getCurrentDate();

    /**
     * 更新者userId.
     */
    protected String updateBy;

    /**
     * 更新日期.
     */
    protected Date updateDate;

    protected DomainEntity() {
        super();
    }

    public abstract TID getId();

    /**
     * 通过比较唯一标识来区分不同的实体.
     * @param other
     * @return
     */
    protected abstract boolean sameIdentityAs(final T other);

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        final T other = (T) object;
        return sameIdentityAs(other);
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonString(this);
    }
}
