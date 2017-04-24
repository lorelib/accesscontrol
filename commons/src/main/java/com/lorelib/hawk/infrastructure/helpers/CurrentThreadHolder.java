package com.lorelib.hawk.infrastructure.helpers;

import java.util.Map;

/**
 * Created by luomm on 2016/8/12.
 */
public class CurrentThreadHolder {
    private static final ThreadLocal<Map> currentThread = new ThreadLocal<>();

    public static void set(Map info) {
        currentThread.set(info);
    }

    public static Map get() {
        return currentThread.get();
    }
}
