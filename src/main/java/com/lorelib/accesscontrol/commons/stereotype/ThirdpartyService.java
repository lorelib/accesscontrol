package com.lorelib.accesscontrol.commons.stereotype;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * 调用第三方服务标识
 *
 * @author luomm
 *         2015年8月3日
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface ThirdpartyService {
    String value() default "";
}
