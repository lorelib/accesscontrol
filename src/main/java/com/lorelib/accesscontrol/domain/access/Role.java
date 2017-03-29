package com.lorelib.accesscontrol.domain.access;

import com.lorelib.accesscontrol.infrastructure.stereotype.Entity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
    private List<Permission> permissions;

    public Role() {
        super();
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
