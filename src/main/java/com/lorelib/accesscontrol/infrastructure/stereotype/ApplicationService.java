package com.lorelib.accesscontrol.infrastructure.stereotype;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * 应用服务标识
 * Created by listening on 2017/3/21.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface ApplicationService {
    String value() default "";
}
