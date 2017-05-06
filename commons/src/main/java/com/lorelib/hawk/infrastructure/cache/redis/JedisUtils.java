package com.lorelib.hawk.infrastructure.cache.redis;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

/**
 * Jedis Cache 工具类.
 */
@Component
public class JedisUtils {
    private static Logger LOGGER = LoggerFactory.getLogger(JedisUtils.class);
    @Autowired
    private static JedisPool jedisPool;

    /**
     * 获取缓存.
     *
     * @param key 键
     * @return 值
     */
    public static String get(String key) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                value = jedis.get(key);
                value = StringUtils.isNotBlank(value) && !"nil".equalsIgnoreCase(value) ? value : null;
            }
        } catch (Exception e) {
            LOGGER.warn("Cache Exception: get {} = {}", key, value, e);
        } finally {
            closeResource(jedis);
        }
        return value;
    }

    /**
     * 获取缓存.
     *
     * @param key 键
     * @return 值
     */
    public static String hget(String key, String field) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                value = jedis.hget(key, field);
                value = StringUtils.isNotBlank(value) && !"nil".equalsIgnoreCase(value) ? value : null;
            }
        } catch (Exception e) {
            LOGGER.warn("Cache Exception: get {} = {}", key, value, e);
        } finally {
            closeResource(jedis);
        }
        return value;
    }

    /**
     * 设置缓存.
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static String set(String key, String value) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.set(key, value);
        } catch (Exception e) {
            LOGGER.warn("Cache Exception: set {} = {}", key, value, e);
        } finally {
            closeResource(jedis);
        }
        return result;
    }

    /**
     * 设置缓存.
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static long hset(String key, String field, String value) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hset(key, field, value);
        } catch (Exception e) {
            LOGGER.warn("Cache Exception: set {} = {}", key, value, e);
        } finally {
            closeResource(jedis);
        }
        return result;
    }

    public static long hset(String key, String field, String value, int cacheSeconds) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.hset(key, field, value);
            jedis.expire(key, cacheSeconds);
        } catch (Exception e) {
            LOGGER.warn("Cache Exception: set {} = {}", key, value, e);
        } finally {
            closeResource(jedis);
        }
        return result;
    }

    /**
     * 设置缓存.
     *
     * @param key          键
     * @param value        值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static String set(String key, String value, int cacheSeconds) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.set(key, value);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
        } catch (Exception e) {
            LOGGER.warn("Cache Exception: set {} = {}", key, value, e);
        } finally {
            closeResource(jedis);
        }
        return result;
    }

    /**
     * 删除缓存.
     *
     * @param key 键
     * @return
     */
    public static long del(String key) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                result = jedis.del(key);
            } else {
                LOGGER.debug("Cache Exception: del {} not exists", key);
            }
        } catch (Exception e) {
            LOGGER.warn("del {}", key, e);
        } finally {
            closeResource(jedis);
        }
        return result;
    }

    /**
     * 删除缓存.
     *
     * @param key 键
     * @return
     */
    public static long hdel(String key, String field) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = getResource();
            if (jedis.exists(key)) {
                result = jedis.hdel(key, field);
            } else {
                LOGGER.debug("Cache Exception: del {} not exists", key);
            }
        } catch (Exception e) {
            LOGGER.warn("del {}", key, e);
        } finally {
            closeResource(jedis);
        }
        return result;
    }

    /**
     * 缓存是否存在.
     *
     * @param key 键
     * @return
     */
    public static boolean exists(String key) {
        boolean result = false;
        Jedis jedis = null;
        try {
            jedis = getResource();
            result = jedis.exists(key);
        } catch (Exception e) {
            LOGGER.warn("Cache Exception: exists {}", key, e);
        } finally {
            closeResource(jedis);
        }
        return result;
    }

    /**
     * 获取资源.
     *
     * @return
     */
    public static Jedis getResource() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
        } catch (JedisException e) {
            closeResource(jedis);
            throw new RuntimeException(e);
        }
        return jedis;
    }

    /**
     * 释放资源.
     *
     * @param jedis
     */
    public static void closeResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
