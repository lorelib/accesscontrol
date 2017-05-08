package com.lorelib.hawk.infrastructure.helpers.utils.num;

import java.text.DecimalFormat;

public class DecimalFormatHelper {

    private static final DecimalFormat DOUBLE_FORMATTER = new DecimalFormat("0.00");

    public static double formatDouble(double number) {
        return Double.parseDouble(format(number));
    }

    public static String format(double number) {
        return DOUBLE_FORMATTER.format(number);
    }

}
