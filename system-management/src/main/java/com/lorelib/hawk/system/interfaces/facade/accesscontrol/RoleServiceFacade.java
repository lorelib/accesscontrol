package com.lorelib.hawk.system.interfaces.facade.accesscontrol;

import com.lorelib.hawk.infrastructure.helpers.query.PageList;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.command.CreateRoleCommand;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.command.CreateRoleWithPermCommand;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.command.DeleteRoleCommand;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.command.UpdateRoleCommand;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.dto.RoleDTO;

import java.util.List;

/**
 * @author listening
 * @description RoleServiceFacade:
 * @create 2017 04 11 11:09.
 */
public interface RoleServiceFacade {
    /**
     * 新增角色
     * @param command
     */
    void addRole(CreateRoleCommand command);

    /**
     * 新增角色并赋予权限
     * @param command
     */
    void addRoleWithPerms(CreateRoleWithPermCommand command);

    /**
     * 获取所有角色信息
     * @return
     */
    List<RoleDTO> getAllRole();

    /**
     * 获取所有角色及权限信息
     * @return
     */
    List<RoleDTO> getAllRoleWithPerms();

    /**
     * 根据角色名称模糊匹配查找角色及权限信息
     * @param roleName
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageList findRolesWithPerms(String roleName, int pageIndex, int pageSize);

    /**
     * 更新角色
     * @param command
     */
    void updateRole(UpdateRoleCommand command);

    /**
     * 删除角色
     * @param command
     */
    void deleteRole(DeleteRoleCommand command);
}
