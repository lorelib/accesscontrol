package com.lorelib.hawk.system.accesscontrol.interfaces.facade;

import com.lorelib.hawk.system.accesscontrol.interfaces.facade.command.CreateRoleCommand;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.command.CreateRoleWithPermCommand;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.dto.ResourceDTO;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.dto.RoleDTO;
import com.lorelib.hawk.system.menu.ResourceType;
import com.lorelib.hawk.infrastructure.test.TestNGUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author listening
 * @description RoleServiceFacadeTest:
 * @create 2017 04 12 17:04.
 */
public class RoleServiceFacadeTest extends TestNGUtil {
    @Test
    public void addRoleTest() {
        roleServiceFacade.addRole(new CreateRoleCommand("角色管理员", "角色管理员"));
    }

    @Test
    public void addRoleWithPermsTest() {
        ResourceDTO r1 = new ResourceDTO(ResourceType.API, 1L, "统计分析");
        List<ResourceDTO> resources = Lists.newArrayList(r1);

        CreateRoleWithPermCommand command = new CreateRoleWithPermCommand("demo", "", resources);
        roleServiceFacade.addRoleWithPerms(command);
    }

    @Test
    public void getAllRoleWithPermsTest() {
        List<RoleDTO> list = roleServiceFacade.getAllRoleWithPerms();
        Assert.assertNotNull(list);
        writeJsonString(list);
    }

    @Autowired
    private RoleServiceFacade roleServiceFacade;
}
