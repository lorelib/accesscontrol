package com.lorelib.accesscontrol.commons.stereotype;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * Created by listening on 2017/3/21.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface DomainService {
    String value() default "";
}
