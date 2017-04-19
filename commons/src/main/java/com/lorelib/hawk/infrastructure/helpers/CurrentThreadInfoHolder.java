package com.lorelib.hawk.infrastructure.helpers;

import java.util.Map;

/**
 * Created by luomm on 2016/8/12.
 */
public class CurrentThreadInfoHolder {
    private static final ThreadLocal<Map<String, Object>> currentThread = new ThreadLocal<>();

    public static void setSharedInfo(Map<String, Object> info) {
        currentThread.set(info);
    }

    public static Map<String, Object> get() {
        return currentThread.get();
    }
}
