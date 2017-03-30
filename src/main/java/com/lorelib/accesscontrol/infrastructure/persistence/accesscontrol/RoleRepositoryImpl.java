package com.lorelib.accesscontrol.infrastructure.persistence.accesscontrol;

import com.lorelib.accesscontrol.domain.access.Role;
import com.lorelib.accesscontrol.domain.access.RoleRepository;
import com.lorelib.accesscontrol.infrastructure.stereotype.Repository;

import java.util.List;

/**
 * 角色仓库实现
 * Created by listening on 2017/3/24.
 */
@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @Override
    public void addRole(Role role) {
        System.out.println("");
    }

    @Override
    public List<Role> getAllRoles() {
        return null;
    }

    @Override
    public List<Role> getRolesByUserId(String userId) {
        return null;
    }
}
