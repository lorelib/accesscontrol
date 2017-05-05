package com.lorelib.hawk.system.interfaces.facade.menu;

import com.lorelib.hawk.system.application.MenuService;
import com.lorelib.hawk.system.domain.menu.Menu;
import com.lorelib.hawk.system.interfaces.facade.menu.assembler.MenuDTOAssembler;
import com.lorelib.hawk.system.interfaces.facade.menu.dto.MenuDTO;
import com.lorelib.hawk.infrastructure.stereotype.Facade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author listening
 * @description MenuServiceFacadeImpl:
 * @create 2017 04 11 10:37.
 */
@Facade
public class MenuServiceFacadeImpl implements MenuServiceFacade {
    @Autowired
    private MenuService menuService;

    @Override
    public List<MenuDTO> getAllMenus() {
        List<Menu> menus = menuService.getAllMenus();
        return MenuDTOAssembler.toDTO(menus);
    }
}
