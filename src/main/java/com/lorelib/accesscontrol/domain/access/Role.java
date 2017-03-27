package com.lorelib.accesscontrol.domain.access;

import com.lorelib.accesscontrol.commons.stereotype.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色
 * Created by listening on 2017/3/7.
 */
public class Role extends Entity {
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色拥有的权限
     */
    private List<Permission> permissions = new ArrayList<>();

    public Role() {
        super();
    }
}
