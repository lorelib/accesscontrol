package com.lorelib.hawk.webadmin.web.controller;

import com.lorelib.hawk.infrastructure.helpers.base.Response;
import com.lorelib.hawk.infrastructure.helpers.query.PageList;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.RoleServiceFacade;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.command.CreateRoleCommand;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.command.CreateRoleWithPermCommand;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.command.DeleteRoleCommand;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.command.UpdateRoleCommand;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.dto.RoleDTO;
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
        return new Response(1, "");
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
            path = "findRolesWithPerms", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Response findRolesWithPerms(@RequestParam String roleName,
                                       @RequestParam int pageIndex, @RequestParam int pageSize) {
        PageList list = roleServiceFacade.findRolesWithPerms(roleName, pageIndex, pageSize);
        return new Response(1, "", list);
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
