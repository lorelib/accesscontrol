package com.lorelib.hawk.webadmin.web.controller;

import com.lorelib.hawk.system.interfaces.facade.menu.MenuServiceFacade;
import com.lorelib.hawk.system.interfaces.facade.menu.dto.MenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author listening
 * @description MenuController: 菜单控制器
 * @create 2017 04 13 9:25.
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuServiceFacade menuServiceFacade;

    @RequestMapping(
            path = "getAllMenu", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public List<MenuDto> getAllMenu() {
        return menuServiceFacade.getAllMenus();
    }
}
