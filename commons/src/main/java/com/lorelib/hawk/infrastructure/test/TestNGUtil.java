package com.lorelib.hawk.infrastructure.test;

import com.lorelib.hawk.infrastructure.helpers.utils.JSONUtil;
import com.lorelib.hawk.infrastructure.helpers.utils.ParamsValidatorUtil;
import com.lorelib.hawk.infrastructure.helpers.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * 测试工具类.
 * Created by listening on 2017/3/9.
 */
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring-*.xml", "classpath*:spring/spring-*.xml"})
public class TestNGUtil extends AbstractTestNGSpringContextTests {
    @Autowired
    private WebApplicationContext applicationContext;
    protected MockMvc mockMvc;

    @BeforeClass
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.applicationContext).build();
    }

    @AfterClass
    public void destroy() {

    }

    /**
     * 对象参数验证.
     * @param obj
     * @param groups
     * @param <T>
     * @return
     */
    protected static <T> boolean validate(T obj, Class<?>... groups) {
        return ParamsValidatorUtil.validate(obj, groups);
    }

    /**
     * 转换成json数据输出.
     * @param obj
     */
    protected void writeJsonString(Object obj) {
        writeJsonString(null, obj);
    }

    /**
     * 转换成json数据输出.
     * @param obj
     */
    protected void writeJsonString(String tips, Object obj) {
        if (StringUtil.isBlank(tips)) tips = "result: ";
        System.out.println(tips + JSONUtil.toJsonString(obj));
    }

    /**
     * 打印对象信息.
     * @param obj
     */
    protected void println(Object obj) {
        println(null, obj);
    }

    /**
     * 打印对象信息.
     * @param tips 提示信息
     * @param obj
     */
    protected void println(String tips, Object obj) {
        if (StringUtil.isBlank(tips)) tips = "result: ";

        if (obj instanceof String) {
            System.out.println(tips + obj);
        } else {
            writeJsonString(tips, obj);
        }
    }

    /**
     * 打印对象信息，去掉null和空.
     * @param obj
     */
    protected void printlnNoBlank(Object obj) {
        printlnNoBlank(null, obj);
    }

    /**
     * 打印对象信息，去掉null和空.
     * @param tips 提示信息
     * @param obj
     */
    protected void printlnNoBlank(String tips, Object obj) {
        if (StringUtil.isBlank(tips)) tips = "result: ";

        if (obj instanceof String) {
            System.out.println(tips + obj);
        } else {
            System.out.println(tips + JSONUtil.noneBlank(obj));
        }
    }
}
