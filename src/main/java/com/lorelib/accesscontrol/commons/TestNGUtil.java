package com.lorelib.accesscontrol.commons;

import com.lorelib.accesscontrol.commons.utils.ParamsValidatorUtil;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by listening on 2017/3/9.
 */
@ContextConfiguration(locations = {"classpath*:spring-*.xml", "classpath*:spring/spring-*.xml"})
public class TestNGUtil extends AbstractTestNGSpringContextTests {
    protected static <T> boolean validate(T obj, Class<?>... groups) {
        return ParamsValidatorUtil.validate(obj, groups);
    }
}
