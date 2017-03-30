package com.lorelib.hawk.accesscontrol.domain.access;

import com.lorelib.hawk.infrastructure.stereotype.BaseEntity;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 角色
 * Created by listening on 2017/3/7.
 */
public class Role extends BaseEntity {
    /**
     * 角色名称
     */
    @NotNull(message = "角色名称为空")
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