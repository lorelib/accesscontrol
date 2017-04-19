package com.lorelib.hawk.system.accesscontrol.interfaces.rest;

import com.lorelib.hawk.system.accesscontrol.interfaces.facade.RoleServiceFacade;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.command.CreateRoleCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author listening
 * @description RoleRestService: 角色rest服务，注：此处只作为样例，不作为对外restful接口
 * @create 2017 04 12 16:57.
 */
@RestController
@RequestMapping("role")
public class RoleRestService {
    @RequestMapping(
            path = "new", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public void addRole(@RequestBody CreateRoleCommand command) {
        roleServiceFacade.addRole(command);
    }

    @Autowired
    private RoleServiceFacade roleServiceFacade;
}
