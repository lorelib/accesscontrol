package com.lorelib.accesscontrol.domain.access;

import com.lorelib.accesscontrol.infrastructure.stereotype.BaseEntity;

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
     * 资源操作ID
     */
    private long optId;
}
