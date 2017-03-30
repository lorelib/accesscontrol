package com.lorelib.accesscontrol.domain.access;

import com.lorelib.accesscontrol.infrastructure.stereotype.DomainService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
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
     * 获取所有角色
     * @return
     */
    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
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
