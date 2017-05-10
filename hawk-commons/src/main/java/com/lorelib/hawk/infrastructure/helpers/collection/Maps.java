package com.lorelib.hawk.infrastructure.helpers.collection;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * @author listening
 * @description Maps:
 * @create 2017 04 21 19:29.
 */
public class Maps {
    public static <K, V> Map<K, V> map(K key, V value) {
        Map<K, V> map = new HashedMap();
        map.put(key, value);
        return map;
    }
}
