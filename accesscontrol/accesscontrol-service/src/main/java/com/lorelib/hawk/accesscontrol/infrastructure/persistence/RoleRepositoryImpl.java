package com.lorelib.hawk.accesscontrol.infrastructure.persistence;

import com.lorelib.hawk.accesscontrol.domain.Role;
import com.lorelib.hawk.accesscontrol.domain.RoleRepository;
import com.lorelib.hawk.infrastructure.stereotype.Repository;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.collections.Lists;

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
        return getRolesWithPerm(null);
    }

    @Override
    public List<Role> getRolesWithPerm(List<Role> roleIds) {
        return sqlSession.selectList(RESOURCE_MAPPER + "getRolesWithPerm", roleIds);
    }

    @Autowired
    private SqlSessionTemplate sqlSession;
    private final static String RESOURCE_MAPPER = "com.lorelib.hawk.accesscontrol.domain.RoleRepository.";
}
