package com.lorelib.hawk.system.menu.interfaces.rest;

import com.lorelib.hawk.system.menu.interfaces.facade.MenuServiceFacade;
import com.lorelib.hawk.system.menu.interfaces.facade.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author listening
 * @description MenuRestService: 菜单rest服务，注：此处只作为样例，不作为对外restful接口
 * @create 2017 04 11 9:25.
 */
@RestController
@RequestMapping("menu")
public class MenuRestService {
    @Autowired
    private MenuServiceFacade menuServiceFacade;

    @RequestMapping(
            path = "all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public List<MenuDTO> getAllMenu() {
        return menuServiceFacade.getAllMenus();
    }
}
