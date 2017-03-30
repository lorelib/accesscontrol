package com.lorelib.hawk.infrastructure.helpers.algorithm;

/**
 * id生成器
 * Created by listening on 2017/3/24.
 */
public class IdGenerator {
    private final static long DEFAULT_SEQUENCE = 1L;
    private final static long DEFAULT_DATACENTER_ID = 1L;

    public static long nextId() {
        Snowflake snowflake = new Snowflake(Thread.currentThread().getId(), DEFAULT_DATACENTER_ID, DEFAULT_SEQUENCE);
        return snowflake.nextId();
    }
}
