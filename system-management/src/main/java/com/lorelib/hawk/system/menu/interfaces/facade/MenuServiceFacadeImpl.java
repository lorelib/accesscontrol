package com.lorelib.hawk.system.menu.interfaces.facade;

import com.lorelib.hawk.system.menu.application.MenuService;
import com.lorelib.hawk.system.menu.domain.Menu;
import com.lorelib.hawk.system.menu.interfaces.facade.assembler.MenuDTOAssembler;
import com.lorelib.hawk.system.menu.interfaces.facade.dto.MenuDTO;
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
