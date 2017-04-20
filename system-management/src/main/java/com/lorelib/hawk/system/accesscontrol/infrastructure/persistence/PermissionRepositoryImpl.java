package com.lorelib.hawk.system.accesscontrol.infrastructure.persistence;

import com.lorelib.hawk.system.accesscontrol.domain.Permission;
import com.lorelib.hawk.system.accesscontrol.domain.PermissionRepository;
import com.lorelib.hawk.system.accesscontrol.domain.RoleId;
import com.lorelib.hawk.infrastructure.helpers.algorithm.IdGenerator;
import com.lorelib.hawk.infrastructure.stereotype.Repository;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author listening
 * @description PermissionRepositoryImpl:
 * @create 2017 04 12 18:10.
 */
@Repository
public class PermissionRepositoryImpl implements PermissionRepository {
    @Override
    public Long identifier() {
        return IdGenerator.nextId();
    }

    @Override
    public void addPerms(List<Permission> perms) {
        session.insert(PERMISSION_MAPPER + "addPerms", perms);
    }

    @Override
    public List<Permission> getPermsBy(RoleId roleId) {
        return session.selectList(PERMISSION_MAPPER + "getPermsBy", roleId);
    }

    @Override
    public void removePerms(List<Permission> perms) {
        session.delete(PERMISSION_MAPPER + "removePerms", perms);
    }

    @Override
    public void deletePermsByRole(RoleId roleId) {
        session.delete(PERMISSION_MAPPER + "deletePermsByRole", roleId);
    }

    @Autowired
    private SqlSessionTemplate session;
    private final static String PERMISSION_MAPPER = PermissionRepository.class.getName() + ".";
}
