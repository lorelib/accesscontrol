package com.lorelib.hawk.system.accesscontrol.interfaces.facade.command;

import com.lorelib.hawk.infrastructure.stereotype.Command;

import javax.validation.constraints.NotNull;

/**
 * @author listening
 * @description CreateRoleCommand:
 * @create 2017 04 11 11:09.
 */
public class CreateRoleCommand implements Command {
    /**
     * 角色名称
     */
    @NotNull(message = "角色名称是必需的")
    private String roleName;

    /**
     * 描述（简介）
     */
    private String description;

    public CreateRoleCommand() {
    }

    public CreateRoleCommand(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
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
}
