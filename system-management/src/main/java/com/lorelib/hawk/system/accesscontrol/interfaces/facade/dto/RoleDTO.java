package com.lorelib.hawk.system.accesscontrol.interfaces.facade.dto;

import com.lorelib.hawk.infrastructure.stereotype.DTO;

import java.util.List;

/**
 * @author listening
 * @description RoleDTO:
 * @create 2017 04 13 13:32.
 */
public class RoleDTO implements DTO {
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
    private List<PermissionDTO> perms;

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

    public List<PermissionDTO> getPerms() {
        return perms;
    }

    public void setPerms(List<PermissionDTO> perms) {
        this.perms = perms;
    }
}
