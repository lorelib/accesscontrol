package com.lorelib.hawk.system.accesscontrol.domain;

import com.lorelib.hawk.infrastructure.helpers.query.Criteria;
import com.lorelib.hawk.infrastructure.test.TestNGUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author listening
 * @description RoleRepositoryTest:
 * @create 2017 04 14 15:43.
 */
public class RoleRepositoryTest extends TestNGUtil {
    @Test
    public void getRoleByIdTest() {
        Role role = roleRepository.getRoleWithPermsBy(new RoleId(852393528581632000L));
        Assert.assertNotNull(role);
        println("role: " + role);
    }

    @Test
    public void findRolesForNoConditionTest() {
        Criteria<Role> criteria = new Criteria<>();
        List<Role> roles = roleRepository.findRoles(criteria);
        Assert.assertNotNull(roles);
        printlnNoBlank(roles);
    }

    @Test
    public void findRolesForCustPageTest() {
        Criteria<Role> criteria = new Criteria<>();
        criteria.getPage().setPageIndex(0).setPageSize(2);
        List<Role> roles = roleRepository.findRoles(criteria);
        Assert.assertNotNull(roles);
        printlnNoBlank(roles);
    }

    @Test
    public void findRolesForWhereTest() {
        Criteria<Role> criteria = new Criteria<>();
        Role role = new Role();
        role.setRoleName("经理");
        criteria.setWhere(role);
        List<Role> roles = roleRepository.findRoles(criteria);
        Assert.assertNotNull(roles);
        printlnNoBlank(roles);
    }

    @Autowired
    private RoleRepository roleRepository;
}
