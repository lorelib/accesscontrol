package com.lorelib.accesscontrol.common.utils;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by listening on 2017/3/17.
 */
public class IdGenerator {
    private IdGenerator() {}

    public static Serializable id() {
        return UUID.randomUUID().toString().toUpperCase();
    }
}
