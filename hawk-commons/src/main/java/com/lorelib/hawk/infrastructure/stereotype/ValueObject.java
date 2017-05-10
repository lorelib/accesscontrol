package com.lorelib.hawk.infrastructure.stereotype;

import com.lorelib.hawk.infrastructure.helpers.annotation.TypeAlias;
import com.lorelib.hawk.infrastructure.helpers.utils.JSONUtil;

import java.io.Serializable;

/**
 * 值对象标识
 * Created by listening on 2017/3/23.
 */
public abstract class ValueObject implements Serializable, TypeAlias {
    @Override
    public String toString() {
        return JSONUtil.toJsonString(this);
    }
}
