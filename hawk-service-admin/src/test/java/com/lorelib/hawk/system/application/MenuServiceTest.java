package com.lorelib.hawk.system.application;

import com.lorelib.hawk.system.domain.menu.Menu;
import com.lorelib.hawk.infrastructure.test.TestNGUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author listening
 * @description MenuServiceTest:
 * @create 2017 04 10 16:45.
 */
public class MenuServiceTest extends TestNGUtil {
    @Autowired
    private MenuService menuService;

    @Test
    private void getAllMenusTest() {
        List<Menu> menus = menuService.getAllMenus();
        Assert.assertNotNull(menus);
        writeJsonString(menus);
    }
}
