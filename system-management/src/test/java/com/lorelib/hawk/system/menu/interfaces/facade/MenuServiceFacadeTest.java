package com.lorelib.hawk.system.menu.interfaces.facade;

import com.lorelib.hawk.system.menu.interfaces.facade.dto.MenuDTO;
import com.lorelib.hawk.infrastructure.test.TestNGUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author listening
 * @description MenuServiceFacadeTest:
 * @create 2017 04 11 16:19.
 */
public class MenuServiceFacadeTest extends TestNGUtil {
    @Autowired
    private MenuServiceFacade menuServiceFacade;

    @Test
    private void getAllMenusTest() {
        List<MenuDTO> menus = menuServiceFacade.getAllMenus();
        Assert.assertNotNull(menus);
        writeJsonString(menus);
    }
}
