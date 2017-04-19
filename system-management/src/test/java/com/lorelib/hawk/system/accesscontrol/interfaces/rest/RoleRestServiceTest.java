package com.lorelib.hawk.system.accesscontrol.interfaces.rest;

import com.alibaba.fastjson.JSON;
import com.lorelib.hawk.system.accesscontrol.interfaces.facade.command.CreateRoleCommand;
import com.lorelib.hawk.infrastructure.test.TestNGUtil;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * @author listening
 * @description RoleControllerTest:
 * @create 2017 04 12 17:36.
 */
public class RoleRestServiceTest extends TestNGUtil {
    @Test
    public void addRoleTest() throws Exception {
        CreateRoleCommand command = new CreateRoleCommand("普通职员", "");
        MvcResult result = mockMvc.perform(
                post("/role/new")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(JSON.toJSONString(command))
        ).andReturn();
        Assert.assertEquals(result.getResponse().getStatus(), 200);
        println("响应结果: " + result.getResponse().getContentAsString());
    }
}
