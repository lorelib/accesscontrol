package com.lorelib.hawk.infrastructure.stereotype;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author listening
 * @description Facade:
 * @create 2017 04 11 16:22.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Facade {
    String value() default "";
}
