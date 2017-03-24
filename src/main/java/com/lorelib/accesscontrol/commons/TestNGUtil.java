package com.lorelib.accesscontrol.commons;

import com.lorelib.accesscontrol.commons.utils.ParamsValidatorUtil;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

/**
 * 测试工具类
 * Created by listening on 2017/3/9.
 */
@ContextConfiguration(locations = {"classpath*:spring-*.xml", "classpath*:spring/spring-*.xml"})
public class TestNGUtil extends AbstractTestNGSpringContextTests {
    protected static <T> boolean validate(T obj, Class<?>... groups) {
        return ParamsValidatorUtil.validate(obj, groups);
    }

    @BeforeTest
    public void setup() {

    }

    @AfterClass
    public void destroy() {

    }
}
