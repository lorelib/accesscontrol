package com.lorelib.hawk.infrastructure.helpers;

import com.lorelib.hawk.infrastructure.helpers.collection.Maps;

import java.util.Map;

/**
 * Created by luomm on 2016/8/12.
 */
public class CurrentThreadHolder {
    /**
     * 当前线程信息持有器.
     */
    private static final ThreadLocal<Map> currentThreadHolder = new ThreadLocal<>();

    public static <K, V> void set(K key, V value) {
        Map data = currentThreadHolder.get();
        if (data == null) {
            currentThreadHolder.set(Maps.map(key, value));
        } else {
            data.put(key, value);
        }
    }

    public static <K, V> V get(K key) {
        Map data = currentThreadHolder.get();
        if (data != null) {
            return (V) data.get(key);
        }
        return null;
    }

    public static Map get() {
        return currentThreadHolder.get();
    }
}
