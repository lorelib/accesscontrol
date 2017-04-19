package com.lorelib.hawk.system.accesscontrol.interfaces.facade.command;

import com.lorelib.hawk.system.accesscontrol.interfaces.facade.dto.ResourceDTO;
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

    public UpdateRoleCommand(Long roleId, String roleDesc, List<ResourceDTO> resources) {
        this.roleId = roleId;
        this.roleDesc = roleDesc;
        this.resources = resources;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
