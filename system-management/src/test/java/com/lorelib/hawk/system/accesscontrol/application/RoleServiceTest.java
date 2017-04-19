package com.lorelib.hawk.system.accesscontrol.application;

import com.lorelib.hawk.system.accesscontrol.domain.Resource;
import com.lorelib.hawk.system.accesscontrol.domain.Role;
import com.lorelib.hawk.system.menu.ResourceType;
import com.lorelib.hawk.infrastructure.test.TestNGUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author listening
 * @description RoleServiceTest:
 * @create 2017 04 12 16:05.
 */
public class RoleServiceTest extends TestNGUtil {
    @Autowired
    private RoleService roleService;

    /**
     * 测试新增角色参数为空的情况
     */
    @Test
    public void addRoleWithBlankTest() {
        roleService.addRole("", "");
    }

    /**
     * 测试新增角色正常的情况
     */
    @Test
    public void addRoleTest() {
        roleService.addRole("系统管理员", "");
    }

    @Test
    public void addRoleWithPermsTest() {
        Resource r1 = new Resource(ResourceType.MENU, 1L, "统计分析");
        List<Resource> resources = Lists.newArrayList(r1);
        roleService.addRoleWithPerms("经理2", "经理", resources);
    }

    @Test
    public void getAllRoleWithPermsTest() {
        List<Role> roles = roleService.getAllRoleWithPerms();
        Assert.assertNotNull(roles);
        writeJsonString(roles);
    }

    @Test
    public void updateRoleTest() {
        Long roleId = 854191890841698304L;
        String desc = "test";
        //Resource r1 = new Resource(ResourceType.MENU, 1L, "统计分析");
        Resource r2 = new Resource(ResourceType.MENU, 5L, "系统管理");
        Resource r3 = new Resource(ResourceType.MENU, 3L, "自动估价服务统计");
        Resource r4 = new Resource(ResourceType.MENU, 6L, "角色管理");
        List<Resource> resources = Lists.newArrayList(r2, r3, r4);
        roleService.updateRole(roleId, desc, resources);
    }
}
