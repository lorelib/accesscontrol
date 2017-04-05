package com.lorelib.hawk.accesscontrol.domain;

import java.util.List;

/**
 * 角色仓库
 * Created by listening on 2017/3/24.
 */
public interface RoleRepository {
    /**
     * 新增角色
     * @param role
     */
    void addRole(Role role);

    /**
     * 为角色添加新的权限
     * @param role
     */
    void addPermToRole(Role role);

    /**
     * 获取所有角色
     * @return
     */
    List<Role> getAllRoles();

    /**
     * 获取所有角色及权限
     * @return
     */
    List<Role> getAllRolesWithPerm();

    /**
     * 获取角色及权限
     * @return
     */
    List<Role> getRolesWithPerm(Role role);

    /**
     * 根据该用户角色
     * @param roleId
     * @return
     */
    List<Role> getRolesById(long roleId);
}