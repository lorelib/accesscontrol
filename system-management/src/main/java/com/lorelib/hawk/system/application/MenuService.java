package com.lorelib.hawk.system.application;

import com.lorelib.hawk.system.domain.menu.Menu;

import java.util.List;

/**
 * @author listening
 * @description MenuService: 菜单应用服务接口
 * @create 2017 04 10 13:35.
 */
public interface MenuService {
    /**
     * 获取所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
