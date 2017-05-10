package com.lorelib.hawk.infrastructure.helpers.base;

import com.lorelib.hawk.infrastructure.stereotype.Dto;

/**
 * @author listening
 * @description Request:
 * @create 2017 04 13 16:22.
 */
public interface Request extends Dto {
    boolean notBlank();
}
