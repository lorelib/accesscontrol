package com.lorelib.hawk.infrastructure.stereotype;

import java.lang.annotation.*;

/**
 * 数据仓库标识
 * Created by listening on 2017/3/21.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@org.springframework.stereotype.Repository
public @interface Repository {
    String value() default "";
}
