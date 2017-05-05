package com.lorelib.hawk.webadmin.web.controller;

import com.lorelib.hawk.system.interfaces.facade.accesscontrol.command.CreateRoleCommand;
import com.lorelib.hawk.infrastructure.test.TestNGUtil;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * @author listening
 * @description UserControllerTest:
 * @create 2017 04 18 17:59.
 */
public class UserControllerTest extends TestNGUtil {
    @Test
    public void loginTest() throws Exception {
        String username = "admin@fxt";
        String password = "a123456";
        CreateRoleCommand command = new CreateRoleCommand("普通职员2", "");
        MvcResult result = mockMvc.perform(
                post("/user/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("username", username)
                        .param("password", password)
        ).andReturn();
        Assert.assertEquals(result.getResponse().getStatus(), 200);
        println("响应结果: " + result.getResponse().getContentAsString());
    }
}
