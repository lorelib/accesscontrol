package com.lorelib.hawk.system.accesscontrol.application;

import com.lorelib.hawk.infrastructure.helpers.query.Criteria;
import com.lorelib.hawk.infrastructure.helpers.utils.StringUtil;
import com.lorelib.hawk.infrastructure.stereotype.ApplicationService;
import com.lorelib.hawk.system.accesscontrol.domain.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author listening
 * @description RoleServiceImpl: 角色应用服务默认实现
 * @create 2017 03 21 11:09.
 */
@ApplicationService
@Transactional
public class RoleServiceImpl implements RoleService {
    @Override
    public void addRole(final String roleName, final String description) {
        RoleId roleId = roleRepository.identifier();
        Role role = new Role(roleId, roleName, description);
        roleRepository.addRole(role);
    }

    @Override
    public void addRoleWithPerms(final String roleName, final String description, final List<Resource> resources) {
        RoleId roleId = roleRepository.identifier();
        Role role = new Role(roleId, roleName, description);
        roleRepository.addRole(role);

        role.addPerms(resources);
        permRepository.addPerms(role.getPerms());
    }

    @Override
    public List<Role> getAllRoleWithPerms() {
        return roleRepository.getAllRoleWithPerms();
    }

    @Override
    public List<Role> findRolesWithPerms(Criteria<Role> criteria) {
        List<Role> roles = roleRepository.findRoles(criteria);
        for (Role role: roles) {
            List<Permission> perms = permRepository.getPermsBy(role.getId());
            role.setPerms(perms);
        }
        return roles;
    }

    @Override
    public int getRolesSize(Criteria<Role> criteria) {
        return roleRepository.getRolesSize(criteria);
    }

    @Override
    public void assignRoleToUser(final Long userId, final Long roleId) {

    }

    @Override
    public List<Role> getRoleForUser(final Long userId) {
        return null;
    }

    @Override
    public void deleteRole(final Long roleId) {
        RoleId rid = new RoleId(roleId);
        Role role = roleRepository.getRoleWithPermsBy(rid);
        Validate.notNull(role, "roleId: " + roleId + "的角色不存在!");
        roleRepository.deleteRole(rid);
        permRepository.deletePermsByRole(rid);
    }

    @Override
    public void updateRole(Long roleId, String roleName, String desc, List<Resource> resources) {
        RoleId rid = new RoleId(roleId);
        Role role = roleRepository.getRoleWithPermsBy(rid);
        Validate.notNull(role, "roleId: " + roleId + "的角色不存在!");

        roleRepository.updateRole(role.desc(desc).setRoleName(roleName));

        role.updatePerms(resources);
        if (CollectionUtils.isNotEmpty(role.getNeedAdd())) permRepository.addPerms(role.getNeedAdd());
        if (CollectionUtils.isNotEmpty(role.getNeedDel())) permRepository.removePerms(role.getNeedDel());
    }

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permRepository;
}
