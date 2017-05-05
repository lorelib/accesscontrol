package com.lorelib.hawk.webadmin.web.controller;

import com.lorelib.hawk.infrastructure.helpers.base.Response;
import com.lorelib.hawk.infrastructure.helpers.query.PageList;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.RoleServiceFacade;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.command.CreateRoleCommand;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.command.CreateRoleWithPermCommand;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.command.DeleteRoleCommand;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.command.UpdateRoleCommand;
import com.lorelib.hawk.system.interfaces.facade.accesscontrol.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public Response addRoleWithPerms(@RequestBody CreateRoleWithPermCommand command) {
        roleServiceFacade.addRoleWithPerms(command);
        return new Response(0, "新增角色成功！");
    }

    @RequestMapping(
            path = "getAllRole", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Response getAllRole() {
        List<RoleDTO> roles = roleServiceFacade.getAllRole();
        return new Response(0, "", roles);
    }

    @RequestMapping(
            path = "getAllRoleWithPerms", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Response getAllRoleWithPerms() {
        List<RoleDTO> list = roleServiceFacade.getAllRoleWithPerms();
        return new Response(0, "", list);
    }

    @RequestMapping(
            path = "findRolesWithPerms", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Response findRolesWithPerms(@RequestParam String roleName,
                                       @RequestParam int pageIndex, @RequestParam int pageSize) {
        PageList list = roleServiceFacade.findRolesWithPerms(roleName, pageIndex, pageSize);
        return new Response(0, "", list);
    }

    @RequestMapping(
            path = "updateRole", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Response updateRole(@RequestBody UpdateRoleCommand command) {
        roleServiceFacade.updateRole(command);
        return new Response(0, "修改角色成功！");
    }

    @RequestMapping(
            path = "deleteRole", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Response deleteRole(@RequestBody DeleteRoleCommand command) {
        roleServiceFacade.deleteRole(command);
        return new Response(0, "删除角色成功！");
    }

    @Autowired
    private RoleServiceFacade roleServiceFacade;
}
