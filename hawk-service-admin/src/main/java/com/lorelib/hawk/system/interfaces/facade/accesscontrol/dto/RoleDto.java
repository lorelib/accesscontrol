package com.lorelib.hawk.system.interfaces.facade.accesscontrol.dto;

import com.lorelib.hawk.infrastructure.stereotype.Dto;

import java.util.List;

/**
 * @author listening
 * @description RoleDto:
 * @create 2017 04 13 13:32.
 */
public class RoleDto implements Dto {
    private String id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 描述（简介）
     */
    private String description;

    /**
     * 角色拥有的权限
     */
    private List<PermissionDto> perms;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PermissionDto> getPerms() {
        return perms;
    }

    public void setPerms(List<PermissionDto> perms) {
        this.perms = perms;
    }
}
