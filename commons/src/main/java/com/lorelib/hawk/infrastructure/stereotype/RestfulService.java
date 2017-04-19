package com.lorelib.hawk.infrastructure.stereotype;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * rest服务标识
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface RestfulService {
    String value() default "";
}
