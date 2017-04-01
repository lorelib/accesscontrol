package com.lorelib.hawk.accesscontrol.domain.access;

import com.lorelib.hawk.infrastructure.stereotype.DomainService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by listening on 2017/3/30.
 */
@DomainService
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    /**
     * 新增角色
     * @param role
     */
    public void addRole(Role role) {
        roleRepository.addRole(role);
    }

    /**
     * 为角色添加新的权限
     * @param roleId
     * @param perms
     */
    public void addPermToRole(long roleId, List<Permission> perms) {
        roleRepository.addPermToRole(new Role(roleId).addPermissions(perms));
    }

    /**
     * 获取所有角色
     * @return
     */
    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }

    /**
     * 获取所有角色及权限
     * @return
     */
    public List<Role> getAllRolesWithPerm() {
        return roleRepository.getAllRolesWithPerm();
    }

    /**
     * 根据该用户角色
     * @param userId
     * @return
     */
    public List<Role> getRolesByUserId(String userId) {
        return roleRepository.getRolesByUserId(userId);
    }
}
