package com.lorelib.hawk.infrastructure.helpers.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil extends StringUtils {

    private final static Set<Map.Entry<String, String>> sets = new HashSet<>();

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("一", "1");
        hashMap.put("二", "2");
        hashMap.put("三", "3");
        hashMap.put("四", "4");
        hashMap.put("五", "5");
        hashMap.put("六", "6");
        hashMap.put("七", "7");
        hashMap.put("八", "8");
        hashMap.put("九", "9");
        hashMap.put("壹", "1");
        hashMap.put("贰", "2");
        hashMap.put("叁", "3");
        hashMap.put("肆", "4");
        hashMap.put("伍", "5");
        hashMap.put("陆", "6");
        hashMap.put("柒", "7");
        hashMap.put("捌", "8");
        hashMap.put("玖", "9");
        hashMap.put("零", "0");
        sets.addAll(hashMap.entrySet());
    }
    
    /**
     * @param format
     * @param args
     * @return
     * @description 目前只支持{i}模式匹配.
     */
    public static String format(String format, Object... args) {
        for (int i = 0; i < args.length; i++) {
            format = format.replace("{" + i + "}", args[i] == null ? "" : args[i].toString());
        }
        return format;
    }

    public static boolean isBlank(final CharSequence cs) {
        if (StringUtils.isBlank(cs) || "null".equalsIgnoreCase((cs + "").trim())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

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

    public static boolean isBlankOr0(final CharSequence cs) {
        if (isBlank(cs) || "0".equalsIgnoreCase((cs + "").trim())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * null和"null"转化成"".
     *
     * @param str
     * @return
     */
    public static String nullToBlankStr(String str) {
        return isBlank(str) ? "" : str;
    }

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
     * 去掉特殊字符.
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

    /**
     * 中文转义代码.
     *
     * @param str
     * @return
     */
    public static String stringToNcr(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char num = str.charAt(i);
            if (num > 127) {
                sb.append("&#x" + Integer.toHexString(str.charAt(i)).toUpperCase() + ";");
            } else {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    /**
     * 将字符串中的中文数字转阿拉伯数字，不处理类似“一十一”这样的数字.
     *
     * @param str
     * @return
     */
    public static String toArabicNumerals(String str) {
        // 判断str是否包含类似十、十一、二十、二十一的中文数字，先处理这部分数据
        if (str.matches(".*[十][一二三四五六七八九]*.*")) {
            // 拆分得到类似十、二十、十一、二十一的数组
            String[] arr = str.split("[^一二三四五六七八九十]+");
            for (int i = 0; i < arr.length; i++) {
                String s = arr[i];
                if (s.matches("[一二三四五六七八九][十][一二三四五六七八九]")) { // 判断是否是类似二十一
                    str = str.replace(s, handleLike21(s));
                } else if (s.matches("[一二三四五六七八九][十]")) { // 判断是否是类似二十
                    str = str.replace(s, handleLike20(s));
                } else if (s.matches("[十][一二三四五六七八九]")) { // 判断是否是类似十一
                    str = str.replace(s, handleLike11(s));
                }
            }
            // 判断是否还包含十
            if (str.contains("十")) {
                str = str.replace("十", "10");
            }
        }

        // 处理不包含十的中文数字
        for (Map.Entry<String, String> entry : sets) {
            str = str.replace(entry.getKey(), entry.getValue());
        }
        return str;
    }

    /**
     * 处理类似21的中文数字，不可包含非中文数字的字符.
     * @return
     */
    private static String handleLike21(String str) {
        return toArabicNumerals(str.replace("十", ""));
    }

    /**
     * 处理类似20的中文数字，不可包含非中文数字的字符.
     * @return
     */
    private static String handleLike20(String str) {
        return toArabicNumerals(str.replace("十", "0"));
    }

    /**
     * 处理类似11的中文数字，不可包含非中文数字的字符.
     * @return
     */
    private static String handleLike11(String str) {
        return toArabicNumerals(str.replace("十", "1"));
    }

    /***
     * 多个字符是否为空 有一个不为空 则返回true.
     * @param cs
     * @return
     */
    public static boolean isNotAllBlank(final CharSequence... cs) {
        for (CharSequence c: cs) {
            if (!isBlank(c)) {
                return true;
            }
        }
        return false;
    }

    /***
     * 多个值比较 contains 以排除空值.
     * @param cs
     * @param searchChars
     * @return
     */
    public static boolean containsAny(String cs, String... searchChars) {
        if (!isEmpty(cs) && StringUtil.isNotAllBlank(searchChars)) {
            for (String c: searchChars) {
                if (!isBlank(c) && cs.contains(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String trim(String str, int len) {
        if (isBlank(str)) return "";

        if (str.length() >= len) return str.substring(0, len);

        return str;
    }

    public static String trim(Object obj, int len) {
        if (obj == null) return "";

        return trim(obj.toString(), len);
    }

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

    /**
     * 判断字符串中是否含有数字.
     * @param content
     * @return
     */
    public static boolean hasDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(content);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }

    /**
     * 一个数字都没有.
     * @param content
     * @return
     */
    public static boolean notAnyDigit(String content) {
        return !hasDigit(content);
    }

    // 判断一个字符串是否都为数字
    public static boolean isDigit(String strNum) {
        return strNum.matches("[0-9]{1,}");
    }

    public static boolean notDigit(String strNum) {
        return !isDigit(strNum);
    }
}
