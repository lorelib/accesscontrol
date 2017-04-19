package com.lorelib.hawk.system.menu.interfaces.rest;

import com.lorelib.hawk.infrastructure.test.TestNGUtil;
import org.springframework.test.web.servlet.MvcResult;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * @author listening
 * @description MenuControllerTest:
 * @create 2017 04 11 20:23.
 */
public class MenuRestServiceTest extends TestNGUtil {
    @Test
    private void getAllMenusTest() throws Exception {
        MvcResult result = mockMvc.perform(get("/menu/all")).andReturn();
        Assert.assertEquals(result.getResponse().getStatus(), 200);
        println("响应结果: " + result.getResponse().getContentAsString());
    }
}
