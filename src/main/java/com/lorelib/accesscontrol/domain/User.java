package com.lorelib.accesscontrol.domain;

import com.lorelib.accesscontrol.common.Entity;

/**
 * Created by listening on 2017/3/7.
 */
public class User extends Entity {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 角色ID
     */
    private long roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
