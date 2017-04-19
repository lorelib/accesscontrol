package com.lorelib.hawk.webadmin.web.controller;

import com.lorelib.hawk.infrastructure.test.TestNGUtil;
import org.springframework.test.web.servlet.MvcResult;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * @author listening
 * @description MenuControllerTest:
 * @create 2017 04 13 15:31.
 */
public class MenuControllerTest extends TestNGUtil {
    @Test
    public void getAllMenuTest() throws Exception {
        MvcResult result = mockMvc.perform(post("/menu/getAllMenu")).andReturn();
        Assert.assertEquals(result.getResponse().getStatus(), 200);
        println("响应结果: " + result.getResponse().getContentAsString());
    }
}
