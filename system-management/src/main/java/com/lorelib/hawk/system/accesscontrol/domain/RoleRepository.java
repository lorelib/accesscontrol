package com.lorelib.hawk.system.accesscontrol.domain;

import com.lorelib.hawk.infrastructure.helpers.base.BaseRepository;

import java.util.List;

/**
 * @author listening
 * @description RoleRepository: 角色仓库
 * @create 2017 03 24 11:09.
 */
public interface RoleRepository extends BaseRepository<RoleId> {
    /**
     * 新增角色
     * @param role
     */
    void addRole(Role role);

    /**
     * 获取所有角色及对应权限
     * @return
     */
    List<Role> getAllRoleWithPerms();

    /**
     * 通过角色标识获取角色及其权限
     * @param roleId
     * @return
     */
    Role getRoleWithPermsBy(RoleId roleId);

    /**
     * 删除角色
     * @param roleId
     */
    void deleteRole(RoleId roleId);

    /**
     * 更新角色
     * @param role
     */
    void updateRole(Role role);
}
