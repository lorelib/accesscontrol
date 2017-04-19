package com.lorelib.hawk.infrastructure.helpers.utils.num;


import com.lorelib.hawk.infrastructure.helpers.utils.StringUtil;

/**
 * Created by luomm on 2016/3/16.
 */
public class NumUtil {
    public static float parseFloat(String s) throws NumberFormatException {
        if (StringUtil.isBlank(s)) return 0;
        return Float.parseFloat(s);
    }

    public static int parseInt(Object obj) throws NumberFormatException {
        if (obj != null) {
            if (StringUtil.isBlank(obj.toString())) return 0;
            return Integer.parseInt(obj.toString());
        }
        return 0;
    }

    public static long parseLong(Object obj) throws NumberFormatException {
        if (obj != null) {
            if (StringUtil.isBlank(obj.toString())) return 0;
            return Long.parseLong(obj.toString());
        }
        return 0;
    }

    public static double parseDouble(String s) throws NumberFormatException {
        if (StringUtil.isBlank(s)) return 0;
        return Double.parseDouble(s);
    }
}
