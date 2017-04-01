package com.lorelib.hawk.accesscontrol.infrastructure.persistence;

import com.lorelib.hawk.accesscontrol.domain.access.Role;
import com.lorelib.hawk.accesscontrol.domain.access.RoleRepository;
import com.lorelib.hawk.infrastructure.stereotype.Repository;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 角色仓库实现
 * Created by listening on 2017/3/24.
 */
@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @Override
    public void addRole(Role role) {
        sqlSession.insert(RESOURCE_MAPPER + "addRole", role);
    }

    @Override
    public void addPermToRole(Role role) {
        sqlSession.insert(RESOURCE_MAPPER + "addPermToRole", role);
    }

    @Override
    public List<Role> getAllRoles() {
        return sqlSession.selectList(RESOURCE_MAPPER + "getAllRoles");
    }

    @Override
    public List<Role> getAllRolesWithPerm() {
        List<Role> roles = sqlSession.selectList(RESOURCE_MAPPER + "getAllRolesWithPerm");
        return roles;
    }

    @Override
    public List<Role> getRolesByUserId(String userId) {
        return sqlSession.selectList(RESOURCE_MAPPER + "getRolesByUserId", userId);
    }

    @Autowired
    private SqlSessionTemplate sqlSession;
    private final static String RESOURCE_MAPPER = "com.lorelib.hawk.accesscontrol.domain.access.RoleRepository.";
}
