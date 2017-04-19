package com.lorelib.hawk.infrastructure.cache;

import com.lorelib.hawk.infrastructure.cache.redis.JedisUtils;
import com.lorelib.hawk.infrastructure.config.ConfigHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luomm on 2015/9/21.
 */
public class CacheManager {

    private static final int DEFAULT_CACHE_SECONDS = 180;
    public static final int CACHE_SECONDS = ConfigHolder.getInteger("cache_seconds", DEFAULT_CACHE_SECONDS);
    private static final boolean REDIS_ENABLE = ConfigHolder.getBoolean("redis.enable", false);
    private final static Map<String, Object> secondCache = new HashMap();

    public static void set(String key, String value) {
        set(key, value, DEFAULT_CACHE_SECONDS);
    }

    public static void set(String key, String value, int cacheSeconds) {
        if (REDIS_ENABLE) {
            JedisUtils.set(key, value, cacheSeconds);
        } else {
            secondCache.put(key, value);
        }
    }

    public static String get(String key) {
        if (REDIS_ENABLE) {
            return JedisUtils.get(key);
        } else {
            return (String)secondCache.get(key);
        }
    }

    public static void remove(String key) {
        if (REDIS_ENABLE) {
            JedisUtils.del(key);
        } else {
            secondCache.remove(key);
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
            if (secondCache.get(key) == null) {
                map = new HashMap<String, String>();
            } else {
                map = (Map<String, String>) secondCache.get(key);
            }
            map.put(field, value);
            secondCache.put(key, map);
        }
    }

    public static String get(String key, String field) {
        String value = null;
        if (REDIS_ENABLE) {
            try {
                value = JedisUtils.hget(key, field);
            } catch (Exception e) {
                value = null;
            }
        } else {
            Map<String, String> map = (Map<String, String>) secondCache.get(key);
            if(map != null) {
                value = map.get(field);
            }
        }
        return value;
    }

    public static void remove(String key, String field) {
        if (REDIS_ENABLE) {
            try {
                JedisUtils.hdel(key, field);
            } catch (Exception e) {

            }
        } else {
            Map<String, String> map = (Map<String, String>) secondCache.get(key);
            if(map != null) {
                map.remove(field);
            }
        }
    }

}
