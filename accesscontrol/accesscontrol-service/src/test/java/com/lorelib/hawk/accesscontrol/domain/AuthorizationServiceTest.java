package com.lorelib.hawk.accesscontrol.domain;

import com.google.common.collect.Lists;
import com.lorelib.hawk.infrastructure.test.TestNGUtil;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by listening on 2017/4/5.
 */
public class AuthorizationServiceTest extends TestNGUtil {
    @Autowired
    private AuthorizationService authorizationService;

    @Test
    public void assignRoleTo() {
        User user = new User("luomm@fxt");
        List<Role> roles = Lists.newArrayList();
        roles.add(new Role(849456114931503104L));
        authorizationService.assignRoleTo(user, roles);
    }

    @Test
    public void getRolesFor() {
        User user = new User("luomm@fxt");
        List<Role> roles = authorizationService.getRolesFor(user);
        System.out.println(new ReflectionToStringBuilder(roles.toArray()).toString());
    }
}
