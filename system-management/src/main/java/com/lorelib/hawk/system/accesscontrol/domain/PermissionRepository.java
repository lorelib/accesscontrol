package com.lorelib.hawk.system.accesscontrol.domain;

import com.lorelib.hawk.infrastructure.helpers.base.BaseRepository;

import java.util.List;

/**
 * @author listening
 * @description PermissionRepository:
 * @create 2017 04 12 18:08.
 */
public interface PermissionRepository extends BaseRepository<Long> {
    /**
     * 新增权限
     * @param perms
     */
    void addPerms(List<Permission> perms);

    /**
     * 获取角色的权限
     * @param roleId
     * @return
     */
    List<Permission> getPermsBy(RoleId roleId);

    /**
     * 删除权限
     * @param perms
     */
    void removePerms(List<Permission> perms);

    void deletePermsByRole(RoleId roleId);
}
