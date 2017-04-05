package com.lorelib.hawk.infrastructure.config;

import com.google.common.collect.Lists;
import com.lorelib.hawk.infrastructure.helpers.utils.StringUtil;
import com.lorelib.hawk.infrastructure.logging.LoggerUtil;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ConfigHolder {
    private static final Logger LOGGER = LoggerUtil.getLogger(ConfigHolder.class);
    private static List<String> resources = Lists.newArrayList("application.properties");
    private static Properties properties;

    private ConfigHolder() {

    }

    public static void addResource(String name) {
        resources.add(name);
        properties = null;
    }

    private static synchronized Properties getConfig() {
        if (properties == null) {
            properties = new Properties();
            for (String resource: resources) {
                try {
                    properties.load(ConfigHolder.class.getClassLoader().getResourceAsStream(resource));
                } catch (IOException e) {
                    LOGGER.error("配置文件: " + resource + "加载有误!error: " + e);
                }
            }
        }
        return properties;
    }

    public static String get(String key) {
        return getConfig().getProperty(key);
    }

    public static boolean getBoolean(String key) {
        if (StringUtil.isBlank(get(key))) throw new RuntimeException("[key: " + key + "]期望bool类型，实际为空");
        if (!(get(key).equalsIgnoreCase("true") || get(key).equalsIgnoreCase("false"))) {
            throw new RuntimeException("[key: " + key + "]期望bool类型，实际为非bool类型");
        }
        return Boolean.parseBoolean(get(key));
    }

    public static int getInteger(String key) {
        return Integer.parseInt(get(key));
    }

    public static String getString(String key) {
        return get(key);
    }

    public static long getLong(String key) {
        return Long.parseLong(get(key));
    }

    public static float getFloat(String key) {
        return Float.parseFloat(get(key));
    }

    public static Double getDouble(String key) {
        return Double.parseDouble(get(key));
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        try {
            return getBoolean(key);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static int getInteger(String key, int defaultValue) {
        try {
            return getInteger(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static String getString(String key, String defaultValue) {
        return getString(key) == null ? defaultValue : getString(key);
    }

    public static long getLong(String key, long defaultValue) {
        try {
            return getLong(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static float getFloat(String key, float defaultValue) {
        try {
            return getFloat(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static double getDouble(String key, double defaultValue) {
        try {
            return getDouble(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
