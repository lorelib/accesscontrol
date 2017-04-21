package com.lorelib.hawk.system.accesscontrol.infrastructure.persistence;

import com.lorelib.hawk.infrastructure.helpers.query.Criteria;
import com.lorelib.hawk.system.accesscontrol.domain.Role;
import com.lorelib.hawk.system.accesscontrol.domain.RoleId;
import com.lorelib.hawk.system.accesscontrol.domain.RoleRepository;
import com.lorelib.hawk.infrastructure.helpers.algorithm.IdGenerator;
import com.lorelib.hawk.infrastructure.stereotype.Repository;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author listening
 * @description RoleRepositoryImpl: 角色仓库实现
 * @create 2017 03 24 11:09.
 */
@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @Override
    public RoleId identifier() {
        return new RoleId(IdGenerator.nextId());
    }

    @Override
    public void addRole(Role role) {
        session.insert(ROLE_MAPPER + "addRole", role);
    }

    @Override
    public List<Role> getAllRole() {
        return session.selectList(ROLE_MAPPER + "getAllRole");
    }

    @Override
    public List<Role> getAllRoleWithPerms() {
        return session.selectList(ROLE_MAPPER + "getAllRoleWithPerms");
    }

    @Override
    public Role getRoleWithPermsBy(RoleId roleId) {
        return session.selectOne(ROLE_MAPPER + "getRoleWithPermsBy", roleId);
    }

    @Override
    public List<Role> findRoles(Criteria<Role> criteria) {
        return session.selectList(ROLE_MAPPER + "findRoles", criteria);
    }

    @Override
    public int getRolesSize(Criteria<Role> criteria) {
        return session.selectOne(ROLE_MAPPER + "getRolesSize", criteria);
    }

    @Override
    public void deleteRole(RoleId roleId) {
        session.delete(ROLE_MAPPER + "deleteRole", roleId);
    }

    @Override
    public void updateRole(Role role) {
        session.update(ROLE_MAPPER + "updateRole", role);
    }

    @Autowired
    private SqlSessionTemplate session;
    private final static String ROLE_MAPPER = RoleRepository.class.getName() + ".";
}
