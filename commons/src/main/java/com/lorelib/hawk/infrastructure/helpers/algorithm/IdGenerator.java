package com.lorelib.hawk.infrastructure.helpers.algorithm;

import org.apache.commons.lang3.RandomUtils;

/**
 * id生成器
 * Created by listening on 2017/3/24.
 */
public class IdGenerator {
    private final static long DEFAULT_SEQUENCE = 1L;
    private final static long DEFAULT_DATACENTER_ID = 1L;

    public static long nextId() {
        return new Snowflake(
                Thread.currentThread().getId() + RandomUtils.nextLong(0, 9999999999L),
                DEFAULT_DATACENTER_ID,
                DEFAULT_SEQUENCE
        ).nextId();
    }

    public static void main(String[] args) {
        long num = 10000L;
        for (long i = 0; i < num; i++) {
            System.out.println("id: " + nextId());
        }
    }
}
