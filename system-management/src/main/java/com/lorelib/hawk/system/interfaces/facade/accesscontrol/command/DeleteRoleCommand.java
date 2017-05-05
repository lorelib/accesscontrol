package com.lorelib.hawk.system.interfaces.facade.accesscontrol.command;

import com.lorelib.hawk.infrastructure.stereotype.Command;

import javax.validation.constraints.NotNull;

/**
 * @author listening
 * @description DeleteRoleCommand:
 * @create 2017 04 18 13:33.
 */
public class DeleteRoleCommand implements Command {
    /**
     * 角色标识
     */
    @NotNull(message = "角色名称是必需的")
    private Long roleId;

    public DeleteRoleCommand() {
    }

    public DeleteRoleCommand(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
