package com.lorelib.hawk.infrastructure.helpers.utils;

/**
 * 单位换算
 *
 * @author luomm
 *         2015年8月23日
 */
public class UnitConvertUtil {
    /**
     * 计算机中DPI=96，DPI = 1英寸内可显示的像素点个数
     */
    private static final int DPI = 96;

    /**
     * @param val
     * @return
     * @description 厘米转英寸
     */
    public static float cmToIn(float val) {
        return val / 2.54f;
    }

    /**
     * @param val
     * @return
     * @description 英寸转厘米
     */
    public static float inToCm(float val) {
        return val * 2.54f;
    }

    /**
     * 英寸转缇
     *
     * @param val
     * @return
     * @description
     */
    public static float inToTwip(float val) {
        return val * 1440;
    }

    /**
     * 缇转英寸
     *
     * @param val
     * @return
     * @description
     */
    public static float twipToIn(float val) {
        return val / 1440;
    }

    /**
     * 厘米转缇
     *
     * @param val
     * @return
     * @description
     */
    public static float cmToTwip(float val) {
        return cmToIn(val) * 1440;
    }

    /**
     * 缇转厘米
     *
     * @param val
     * @return
     * @description
     */
    public static float twipToCm(float val) {
        return inToCm(val / 1440);
    }

    /**
     * 英寸转磅或点数
     *
     * @param val
     * @return
     * @description
     */
    public static float inToPt(float val) {
        return val * 72;
    }

    /**
     * 磅或点数转英寸
     *
     * @param val
     * @return
     * @description
     */
    public static float ptToIn(float val) {
        return val / 72;
    }

    /**
     * 厘米转磅或点数
     *
     * @param val
     * @return
     * @description
     */
    public static float cmToPt(float val) {
        return cmToIn(val) * 72;
    }

    /**
     * 磅或点数转厘米
     *
     * @param val
     * @return
     * @description
     */
    public static float ptToCm(float val) {
        return inToCm(ptToIn(val));
    }

    /**
     * 磅或点数转缇
     *
     * @param val
     * @return
     * @description
     */
    public static float ptToTwip(float val) {
        return inToTwip(ptToIn(val));
    }

    /**
     * 缇转磅或点数
     *
     * @param val
     * @return
     * @description
     */
    public static float twipToPt(float val) {
        return inToPt(twipToIn(val));
    }

    /**
     * 像素转英寸
     *
     * @param val
     * @return
     * @description
     */
    public static float pxToIn(float val) {
        return val / DPI;
    }

    /**
     * 英寸转像素
     *
     * @param val
     * @return
     * @description
     */
    public static float inToPx(float val) {
        return val * DPI;
    }

    /**
     * 磅或点数转像素
     *
     * @param val
     * @return
     */
    public static float ptToPx(float val) {
        return ptToIn(val) * DPI;
    }

    /**
     * 厘米转像素
     *
     * @param val
     * @return
     * @description
     */
    public static float cmToPx(float val) {
        return cmToIn(val) * DPI;
    }

    /**
     * 像素转厘米
     *
     * @param val
     * @return
     * @description
     */
    public static float pxToCm(float val) {
        return inToCm(pxToIn(val));
    }
}
