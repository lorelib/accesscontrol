package com.lorelib.hawk.accesscontrol.domain;

import com.lorelib.hawk.infrastructure.stereotype.BaseEntity;
import com.lorelib.hawk.accesscontrol.domain.Role;

import java.util.List;

/**
 * 用户
 * Created by listening on 2017/3/7.
 */
public class User extends BaseEntity {
    /**
     * 用户登录帐号
     */
    private String loginId;

    /**
     * 用户拥有的权限
     */
    private List<Role> roles;

    public User() {
        super();
    }

    public User addRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public String loginId() {
        return this.loginId;
    }
}
