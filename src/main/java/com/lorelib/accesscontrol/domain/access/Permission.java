package com.lorelib.accesscontrol.domain.access;

import com.lorelib.accesscontrol.infrastructure.stereotype.Entity;

/**
 * 权限
 * Created by listening on 2017/3/7.
 */
public class Permission extends Entity {
    /**
     * 角色ID
     */
    private long roleId;

    /**
     * 资源ID
     */
    private long resourceId;
}
