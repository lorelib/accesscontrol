package com.lorelib.accesscontrol.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期转换,日期比较,日期获取的工具类(修改格式化SimpleDateFormat的方式和增加方法继承)
 *
 * @author luomm
 */
public class DateUtil {
    public final static String DEFAULT_PATTERN = DateFormatPattern.YMD_HMS_LINE;

    /**
     * 使用默认的日期格式来创建SimpleDateFormat
     */
    private static SimpleDateFormat getFormattor() {
        return getFormattor(DEFAULT_PATTERN);
    }

    /**
     * 使用指定的日期格式来创建SimpleDateFormat
     */
    public static SimpleDateFormat getFormattor(String format) {
        return new SimpleDateFormat(format);
    }

    /**
     * 使用默认的日期格式把当前系统日期转换为文本
     */
    public static String dateToText() {
        return getFormattor().format(getCurrentDate());
    }

    public static String dateToText(String format) {
        return getFormattor(format).format(getCurrentDate());
    }

    /**
     * 转换指定日期为默认格式的文本
     */
    public static String dateToText(Date date) {
        return getFormattor().format(date);
    }

    /**
     * 使用指定的文本日期格式转换指定日期为文本
     */
    public static String dateToText(String format, Date date) {
        return getFormattor(format).format(date);
    }

    /**
     * 使用默认的日期格式转换文本为日期
     */
    public static Date textToDate(String dateStr) {
        return textToDate(DEFAULT_PATTERN, dateStr);
    }

    /**
     * 使用指定的日期格式转换文本为日期,如果解析出错,返回null;
     */
    public static Date textToDate(String format, String dateStr) {
        Date date = null;
        try {
            date = getFormattor(format).parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    /**
     * 获取系统当前日期
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 获取指定日期的下一天
     */
    public static Date nextDate(Date date) {
        return getDateForDay(date, 1);
    }

    /**
     * 获取指定日期的前一天
     */
    public static Date beforeDate(Date date) {
        return getDateForDay(date, -1);
    }

    /**
     * 获取指定天数后的日期,
     *
     * @param date   指定当前日期
     * @param amount 正数表示以后的天数,负数表示之前的天数, 比如scope=1表示下一天,scope=-1表示前一天
     */
    public static Date getDateForDay(Date date, int amount) {
        return getDate(date, Calendar.DATE, amount);
    }

    public static Date getDateForDay(int amount) {
        return getDate(getCurrentDate(), Calendar.DATE, amount);
    }

    /**
     * 获取date指定amount分钟前或后的日期
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date getDateForMinute(Date date, int amount) {
        return getDate(date, Calendar.MINUTE, amount);
    }

    public static Date getDateForMinute(int amount) {
        return getDate(getCurrentDate(), Calendar.MINUTE, amount);
    }

    public static Date getDate(Date date, int field, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * 比较两个文本日期的相差天数,可带时分秒的
     *
     * @param bigDay      大的日期
     * @param smallDay    小的日期
     * @param datePattern 使用的日期格式
     * @return bigDay比smallDay大时会返回正数的天数, bigDay比smallDay小时会返回负数的天数
     */
    public static long compareDay(String bigDay, String smallDay, String datePattern) {
        Calendar cc = Calendar.getInstance();
        cc.setTime(textToDate(datePattern, bigDay));
        long time1 = cc.getTimeInMillis();
        cc.setTime(textToDate(datePattern, smallDay));
        long time2 = cc.getTimeInMillis();
        if (time1 < time2) {
            return ((time1 - time2) / 1000 / 60 / 60 / 24);
        }
        return ((time1 - time2) / 1000 / 60 / 60 / 24);
    }

    /**
     * 获得Date的日期字段的数值表示
     */
    public static int getDatePart(Date date, int ymd) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        return calendar.get(ymd);
    }

    /**
     * 获得年的数值表示
     */
    public static int getYear(Date date) {
        return getDatePart(date, Calendar.YEAR);
    }

    /**
     * 获得月的数值表示
     */
    public static int getMonth(Date date) {
        return getDatePart(date, Calendar.MONTH) + 1;
    }

    /**
     * 获得所给日期月份的几号
     */
    public static int getDay(Date date) {
        return getDatePart(date, Calendar.DATE);
    }

    public static int getHour(Date date) {
        return getDatePart(date, Calendar.HOUR_OF_DAY);
    }

    public static int getMinute(Date date) {
        return getDatePart(date, Calendar.MINUTE);
    }

    public static int getSecond(Date date) {
        return getDatePart(date, Calendar.SECOND);
    }

    /**
     * 日期格式
     *
     * @author luomm
     */
    public interface DateFormatPattern {

        /**
         * 日期格式 yyyy-MM-dd 如:2007-07-20
         */
        String YMD_LINE = "yyyy-MM-dd";

        /**
         * 日期格式 yyyyMMdd 如:20070720
         */
        String YMD_NO_LINE = "yyyyMMdd";

        /**
         * 日期格式 yyyy-MM-dd HH:mm:ss 如:2007-07-20 07:30:30 小时范围是0-24
         */
        String YMD_HMS_LINE = "yyyy-MM-dd HH:mm:ss";

        /**
         * 日期格式 yyyyMMddHHmmss 如:20070720073030 小时范围是0-24
         */
        String YMD_HMS_NO_LINE = "yyyyMMddHHmmss";

        /**
         * 日期格式 yyyy年MM月dd日 HH时mm分ss秒
         */
        String CNYMD_HMS_LINE = "yyyy年MM月dd日 HH时mm分ss秒";

        /**
         * 日期格式 yyyy-MM-dd kk:mm:ss 如:2007-07-20 07:30:30 小时范围是1-12
         */
        String YMD_12HMS_LINE = "yyyy-MM-dd hh:mm:ss";

        /**
         * 日期格式 MM-dd HH:mm 如:07-20 07:30
         */
        String MD_HM_LINE = "MM-dd HH:mm";
    }
}
