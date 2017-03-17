package com.lorelib.accesscontrol.domain;

import com.lorelib.accesscontrol.common.AggregateRoot;

/**
 * Created by listening on 2017/3/7.
 */
public class Role extends AggregateRoot {
    /**
     * 角色名称
     */
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
