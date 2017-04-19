package com.lorelib.hawk.webadmin.web.controller;

import com.lorelib.hawk.system.accesscontrol.interfaces.facade.RoleServiceFacade;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.command.CreateRoleCommand;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.command.CreateRoleWithPermCommand;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.command.DeleteRoleCommand;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.command.UpdateRoleCommand;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.dto.RoleDTO;
import com.lorelib.hawk.webadmin.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author listening
 * @description RoleController: 角色控制器
 * @create 2017 04 13 16:57.
 */
@RestController
@RequestMapping("role")
public class RoleController {
    @RequestMapping(
            path = "addRole", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public void addRole(@RequestBody CreateRoleCommand command) {
        roleServiceFacade.addRole(command);
    }

    @RequestMapping(
            path = "addRoleWithPerms", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Result addRoleWithPerms(@RequestBody CreateRoleWithPermCommand command) {
        roleServiceFacade.addRoleWithPerms(command);
        return new Result(1, "");
    }

    @RequestMapping(
            path = "getAllRoleWithPerms", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public List<RoleDTO> getAllRoleWithPerms() {
        List<RoleDTO> list = roleServiceFacade.getAllRoleWithPerms();
        return list;
    }

    @RequestMapping(
            path = "updateRole", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public void updateRole(@RequestBody UpdateRoleCommand command) {
        roleServiceFacade.updateRole(command);
    }

    @RequestMapping(
            path = "deleteRole", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public void deleteRole(@RequestBody DeleteRoleCommand command) {
        roleServiceFacade.deleteRole(command);
    }

    @Autowired
    private RoleServiceFacade roleServiceFacade;
}
