package com.lorelib.hawk.infrastructure.helpers.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by listening on 2017/3/10.
 */
public class ParamsValidatorUtil {
    private final static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final static Validator VALIDATOR = factory.getValidator();

    /**
     * 验证对象是否合法.
     * @param obj       被验证对象
     * @param groups    所属组
     * @param <T>
     */
    public static <T> boolean validate(T obj, Class<?>... groups) {
        StringBuilder err = new StringBuilder();
        Set<ConstraintViolation<T>> violations = VALIDATOR.validate(obj, groups);
        for (ConstraintViolation<T> violation: violations) {
            err.append(violation.getMessage()).append(" | ");
        }
        if (StringUtil.isNotBlank(err)) {
            throw new IllegalArgumentException(err.substring(0, err.length() - 2));
        }
        return true;
    }
}
