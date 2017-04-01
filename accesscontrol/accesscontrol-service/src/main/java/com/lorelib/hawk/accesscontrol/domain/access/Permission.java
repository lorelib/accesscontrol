package com.lorelib.hawk.accesscontrol.domain.access;

import com.lorelib.hawk.infrastructure.stereotype.BaseEntity;

/**
 * 权限
 * Created by listening on 2017/3/7.
 */
public class Permission extends BaseEntity {
    /**
     * 角色
     */
    private Role role;

    /**
     * 资源
     */
    private Resource resource;

    public Permission() {
        super();
    }

    public Permission(long resourceId) {
        this();
        this.resource = new Resource(resourceId);
    }

    public Permission(long roleId, long resourceId) {
        this();
        this.role = new Role(roleId);
        this.resource = new Resource(resourceId);
    }
}
