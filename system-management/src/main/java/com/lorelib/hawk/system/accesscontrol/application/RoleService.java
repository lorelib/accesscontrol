package com.lorelib.hawk.system.accesscontrol.application;

import com.lorelib.hawk.system.accesscontrol.domain.Resource;
import com.lorelib.hawk.system.accesscontrol.domain.Role;

import java.util.List;

/**
 * @author listening
 * @description RoleService: 角色应用服务
 * @create 2017 03 21 11:09.
 */
public interface RoleService {
    /**
     * 新增角色
     * @param roleName      角色名称
     * @param description   描述信息
     */
    void addRole(String roleName, String description);

    /**
     * 新增角色并赋予权限
     * @param roleName      角色名称
     * @param description   描述信息
     * @param resources     资源
     */
    void addRoleWithPerms(String roleName, String description, List<Resource> resources);

    /**
     * 获取所有角色信息
     * @return
     */
    List<Role> getAllRole();

    /**
     * 获取所有角色及权限信息
     * @return
     */
    List<Role> getAllRoleWithPerms();

    /**
     * 为用户分配角色
     * @param userId
     * @param roleId
     */
    void assignRoleToUser(Long userId, Long roleId);

    /**
     * 获取用户拥有的角色
     * @param userId
     */
    List<Role> getRoleForUser(Long userId);

    /**
     * 删除角色
     * @param roleId
     */
    void deleteRole(Long roleId);

    /**
     * 更新角色
     * @param roleId    角色标识
     * @param desc      角色描述信息
     * @param resources 资源
     */
    void updateRole(Long roleId, String desc, List<Resource> resources);
}
