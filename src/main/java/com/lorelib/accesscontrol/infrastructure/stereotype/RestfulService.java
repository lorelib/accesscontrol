package com.lorelib.accesscontrol.infrastructure.stereotype;

import org.springframework.stereotype.*;

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
