package com.lorelib.hawk.system.interfaces.facade.accesscontrol.command;

import com.lorelib.hawk.system.interfaces.facade.accesscontrol.dto.ResourceDTO;
import com.lorelib.hawk.infrastructure.stereotype.Command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author listening
 * @description UpdateRoleCommand:
 * @create 2017 04 14 17:07.
 */
public class UpdateRoleCommand implements Command {
    /**
     * 角色标识
     */
    @NotNull(message = "角色名称是必需的")
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述信息
     */
    private String roleDesc;

    /**
     * 资源集合
     */
    @Size(min = 1, message = "资源是必需的")
    private List<ResourceDTO> resources;

    public UpdateRoleCommand() {
    }

    public UpdateRoleCommand(Long roleId, List<ResourceDTO> resources) {
        this.roleId = roleId;
        this.resources = resources;
    }

    public UpdateRoleCommand(Long roleId, String roleName, List<ResourceDTO> resources) {
        this(roleId, resources);
        this.roleName = roleName;
    }

    public UpdateRoleCommand(Long roleId, String roleName, String roleDesc, List<ResourceDTO> resources) {
        this(roleId, roleName, resources);
        this.roleDesc = roleDesc;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<ResourceDTO> getResources() {
        return resources;
    }

    public void setResources(List<ResourceDTO> resources) {
        this.resources = resources;
    }
}