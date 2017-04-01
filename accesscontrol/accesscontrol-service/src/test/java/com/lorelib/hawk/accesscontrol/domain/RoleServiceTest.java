package com.lorelib.hawk.accesscontrol.domain;

import com.google.common.collect.Lists;
import com.lorelib.hawk.infrastructure.test.TestNGUtil;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by listening on 2017/3/30.
 */
public class RoleServiceTest extends TestNGUtil {
    @Autowired
    private RoleService roleService;

    @Test
    public void addRole() {
        long resourceId = 8053191461614784514L;
        Role role = new Role("Administrator");
        List<Permission> perms = Lists.newArrayList();
        perms.add(new Permission(role.getId(), resourceId));

        roleService.addRole(role.addPermissions(perms));
    }

    @Test
    public void addPermToRole() {
        long roleId = 6911758440524288000L;
        List<Permission> perms = Lists.newArrayList();
        perms.add(new Permission(2004003941024665600L));
        roleService.addPermToRole(roleId, perms);
    }

    @Test
    public void getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        System.out.println(new ReflectionToStringBuilder(roles.toArray()).toString());
    }

    @Test
    public void getAllRolesWithPerm() {
        List<Role> roles = roleService.getAllRolesWithPerm();
        System.out.println(new ReflectionToStringBuilder(roles.toArray()).toString());
    }

    @Test
    public void getRolesByUserId() {

    }
}
