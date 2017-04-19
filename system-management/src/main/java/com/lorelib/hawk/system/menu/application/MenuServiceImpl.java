package com.lorelib.hawk.system.menu.application;

import com.lorelib.hawk.system.menu.domain.Menu;
import com.lorelib.hawk.system.menu.domain.MenuRepository;
import com.lorelib.hawk.infrastructure.stereotype.ApplicationService;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author listening
 * @description MenuAppService: 菜单应用服务接口实现
 * @create 2017 04 10 12:01.
 */
@ApplicationService
@Transactional
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuRepository menuRepository;

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.getAllMenu();
    }
}
