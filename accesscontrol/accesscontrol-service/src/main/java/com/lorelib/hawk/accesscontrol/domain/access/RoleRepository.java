package com.lorelib.hawk.accesscontrol.domain.access;

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
     * 获取所有角色
     * @return
     */
    List<Role> getAllRoles();

    /**
     * 根据该用户角色
     * @param userId
     * @return
     */
    List<Role> getRolesByUserId(String userId);
}
