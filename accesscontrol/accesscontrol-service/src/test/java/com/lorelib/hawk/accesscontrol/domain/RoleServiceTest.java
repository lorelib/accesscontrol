package com.lorelib.hawk.accesscontrol.domain;

import com.google.common.collect.Lists;
import com.lorelib.hawk.accesscontrol.domain.access.Permission;
import com.lorelib.hawk.accesscontrol.domain.access.Role;
import com.lorelib.hawk.accesscontrol.domain.access.RoleService;
import com.lorelib.hawk.infrastructure.test.TestNGUtil;
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
        Role role = new Role("Administrator");
        List<Permission> permissions = Lists.newArrayList();
        permissions.add(new Permission(role.getId(), 100L));

        roleService.addRole(role.addPermissions(permissions));
    }

    @Test
    public void getAllRoles() {

    }

    @Test
    public void getRolesByUserId() {

    }
}
