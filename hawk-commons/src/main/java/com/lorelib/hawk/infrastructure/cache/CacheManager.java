package com.lorelib.hawk.infrastructure.cache;

import com.lorelib.hawk.infrastructure.cache.redis.JedisUtils;

import static com.lorelib.hawk.infrastructure.config.ConfigHolder.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luomm on 2015/9/21.
 */
public class CacheManager {
    private static final int DEFAULT_CACHE_SECONDS = 180;
    public static final int CACHE_SECONDS = getInteger("cache_seconds", DEFAULT_CACHE_SECONDS);
    private static final boolean REDIS_ENABLE = getBoolean("redis.enable", false);
    private static final Map<String, Object> SECOND_CACHE = new HashMap();

    public static void set(String key, String value) {
        set(key, value, DEFAULT_CACHE_SECONDS);
    }

    public static void set(String key, String value, int cacheSeconds) {
        if (REDIS_ENABLE) {
            JedisUtils.set(key, value, cacheSeconds);
        } else {
            SECOND_CACHE.put(key, value);
        }
    }

    public static void set(String key, String field, String value) {
        set(key, field, value, DEFAULT_CACHE_SECONDS);
    }

    public static void set(String key, String field, String value, int cacheSeconds) {
        if (REDIS_ENABLE) {
            JedisUtils.hset(key, field, value, cacheSeconds);
        } else {
            Map<String, String> map;
            if (SECOND_CACHE.get(key) == null) {
                map = new HashMap<String, String>();
            } else {
                map = (Map<String, String>) SECOND_CACHE.get(key);
            }
            map.put(field, value);
            SECOND_CACHE.put(key, map);
        }
    }

    public static String get(String key) {
        if (REDIS_ENABLE) {
            return JedisUtils.get(key);
        } else {
            return (String) SECOND_CACHE.get(key);
        }
    }

    public static String get(String key, String field) {
        String value = null;
        if (REDIS_ENABLE) {
            value = JedisUtils.hget(key, field);
        } else {
            Map<String, String> map = (Map<String, String>) SECOND_CACHE.get(key);
            if (map != null) {
                value = map.get(field);
            }
        }
        return value;
    }

    public static void remove(String key) {
        if (REDIS_ENABLE) {
            JedisUtils.del(key);
        } else {
            SECOND_CACHE.remove(key);
        }
    }

    public static void remove(String key, String field) {
        if (REDIS_ENABLE) {
            JedisUtils.hdel(key, field);
        } else {
            Map<String, String> map = (Map<String, String>) SECOND_CACHE.get(key);
            if (map != null) {
                map.remove(field);
            }
        }
    }
}
