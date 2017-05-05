package com.lorelib.hawk.system.interfaces.facade.menu;

import com.lorelib.hawk.system.interfaces.facade.menu.dto.MenuDTO;

import java.util.List;

/**
 * @author listening
 * @description MenuService: 菜单应用服务接口
 * @create 2017 04 10 13:35.
 */
public interface MenuServiceFacade {
    /**
     * 获取所有菜单
     * @return
     */
    List<MenuDTO> getAllMenus();
}
