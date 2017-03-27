package com.lorelib.accesscontrol.domain.identity;

import com.lorelib.accesscontrol.commons.stereotype.Entity;
import com.lorelib.accesscontrol.domain.access.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户
 * Created by listening on 2017/3/7.
 */
public class User extends Entity {
    /**
     * 用户登录帐号
     */
    private String userLoginId;

    /**
     * 用户拥有的权限
     */
    private List<Role> roles = new ArrayList<>();

    public User() {
        super();
    }
}
