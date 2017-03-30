package com.lorelib.hawk.infrastructure.test;

import com.lorelib.hawk.infrastructure.helpers.utils.ParamsValidatorUtil;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

/**
 * 测试工具类
 * Created by listening on 2017/3/9.
 */
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class TestNGUtil extends AbstractTestNGSpringContextTests {
    @BeforeTest
    public void setup() {

    }

    @AfterClass
    public void destroy() {

    }

    protected static <T> boolean validate(T obj, Class<?>... groups) {
        return ParamsValidatorUtil.validate(obj, groups);
    }
}
