package com.lorelib.hawk.system.accesscontrol.domain;

import com.lorelib.hawk.infrastructure.test.TestNGUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author listening
 * @description RoleRepositoryTest:
 * @create 2017 04 14 15:43.
 */
public class RoleRepositoryTest extends TestNGUtil {
    @Test
    public void getRoleById() {
        Role role = roleRepository.getRoleWithPermsBy(new RoleId(852393528581632000L));
        Assert.assertNotNull(role);
        println("role: " + role);
    }

    @Autowired
    private RoleRepository roleRepository;
}
