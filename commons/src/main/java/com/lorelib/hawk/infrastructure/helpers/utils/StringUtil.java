package com.lorelib.hawk.infrastructure.helpers.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class StringUtil extends StringUtils {
    /**
     * 字符串模式匹配
     * @param format
     * @param args
     * @return
     * @description 目前只支持{i}模式匹配
     */
    public static String format(String format, Object... args) {
        for (int i = 0; i < args.length; i++) {
            format = format.replace("{" + i + "}", args[i] == null ? "" : args[i].toString());
        }
        return format;
    }

    /**
     * 是否是空或字符串“null”
     * @param cs
     * @return
     */
    public static boolean isBlank(final CharSequence cs) {
        if (StringUtils.isBlank(cs) || "null".equalsIgnoreCase((cs + "").trim())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 是否是空或字符串“null”
     * @param obj
     * @return
     */
    public static boolean isBlank(final Object obj) {
        if (obj == null) return true;
        return isBlank(obj.toString());
    }

    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    public static boolean isNotBlank(final Object obj) {
        return !isBlank(obj);
    }

    /**
     * 是否是空或字符串“null”、0
     * @param cs
     * @return
     */
    public static boolean isBlankOr0(final CharSequence cs) {
        if (isBlank(cs) || "0".equalsIgnoreCase((cs + "").trim())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * null和"null"转化成""
     *
     * @param str
     * @return
     */
    public static String nullToBlankStr(String str) {
        return str == null ? "" : (str == "null" ? "" : str);
    }

    /**
     * 字符串相等比较
     * @param s1
     * @param s2
     * @return
     */
    public static boolean equals(String s1, String s2) {
        if (s1 == null) {
            if (s2 == null) return Boolean.TRUE;
        } else {
            if (s2 != null) {
                if (s1.equals(s2)) return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 去掉特殊字符
     *
     * @param orignal
     */
    public static String removeSpecialLetter(String orignal) {
        List<String> list = Arrays.asList("`", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "+", "=",
                "{", "}", "[", "]", ":", ";", "\"", "'", "|", "\\", "<", ">", ",", ".", "/", "?");
        for (String letter : list) {
            orignal = orignal.replace(letter, "");
        }
        return orignal;
    }

    /***
     * 如果多个字符有一个不为空，则返回true
     * @param cs
     * @return
     */
    public static boolean isNotAllBlank(final CharSequence... cs) {
        for (CharSequence c : cs) {
            if (!isBlank(c)) {
                return true;
            }
        }
        return false;
    }

    /***
     * 多个值比较 contains 以排除空值
     * @param cs
     * @param searchChars
     * @return
     */
    public static boolean containsAny(String cs, String... searchChars) {
        if (!isEmpty(cs) && StringUtil.isNotAllBlank(searchChars)) {
            for (String c : searchChars) {
                if (!isBlank(c) && cs.contains(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 字符串截断
     * @param str
     * @param len
     * @return
     */
    public static String trim(String str, int len) {
        if (isBlank(str)) return "";
        if (str.length() >= len) return str.substring(0, len);
        return str;
    }

    public static String trim(Object obj, int len) {
        if (obj == null) return "";
        return trim(obj.toString(), len);
    }

    /**
     * JSON字符串截断
     * @param str
     * @param len
     * @return
     */
    public static String trimJsonContent(String str, int len) {
        StringBuilder sb = new StringBuilder();
        if (isNotBlank(str)) {
            int slen = str.indexOf("[{");
            if (slen != -1 && str.length() > len) {
                int elen = str.lastIndexOf("}]");

                sb.append(str.substring(0, slen + 1));

                String body = str.substring(slen + 1, elen);
                sb.append(trim(body, len));

                sb.append(str.substring(elen));
            }
        }
        return sb.length() > 0 ? sb.toString() : str;
    }

    public static String trimJsonContent(Object obj, int len) {
        if (obj == null) return "";
        return trimJsonContent(obj.toString(), len);
    }
}
