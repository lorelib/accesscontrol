package com.lorelib.hawk.system.accesscontrol.interfaces.facade.command;

import com.lorelib.hawk.system.accesscontrol.interfaces.facade.dto.ResourceDTO;
import com.lorelib.hawk.infrastructure.stereotype.Command;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author listening
 * @description CreateRoleWithPermCommand:
 * @create 2017 04 12 19:49.
 */
public class CreateRoleWithPermCommand implements Command {
    /**
     * 角色名称
     */
    @NotNull(message = "角色名称是必需的")
    private String roleName;

    /**
     * 描述（简介）
     */
    private String description;

    /**
     * 资源集合
     */
    @Valid
    private List<ResourceDTO> resources;

    public CreateRoleWithPermCommand() {
    }

    public CreateRoleWithPermCommand(String roleName, String description, List<ResourceDTO> resources) {
        this.roleName = roleName;
        this.description = description;
        this.resources = resources;
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

    public List<ResourceDTO> getResources() {
        return resources;
    }

    public void setResources(List<ResourceDTO> resources) {
        this.resources = resources;
    }
}
