package com.lorelib.hawk.accesscontrol.domain.access;

import com.lorelib.hawk.infrastructure.stereotype.BaseEntity;

/**
 * 权限
 * Created by listening on 2017/3/7.
 */
public class Permission extends BaseEntity {
    /**
     * 角色ID
     */
    private long roleId;

    /**
     * 资源ID
     */
    private long resourceId;

    public Permission() {}

    public Permission(long roleId, long resourceId) {
        this();
        this.roleId = roleId;
        this.resourceId = resourceId;
    }
}
