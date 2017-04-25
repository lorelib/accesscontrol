package com.lorelib.hawk.infrastructure.helpers.utils;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class ListSortUtil {
    /** 升序排列
     * @param targetList 目标排序List
     * @param sortField  排序字段(实体类属性名)
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> void sort(final List<T> targetList, final String sortField) {
        sort(targetList, sortField, SortMode.ASC);
    }

    /** 排序
     * @param targetList 目标排序List
     * @param sortField  排序字段(实体类属性名)
     * @param sortMode   排序方式（asc or  desc）
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> void sort(final List<T> targetList, final String sortField, final SortMode sortMode) {
        Collections.sort(targetList, new Comparator() {
            public int compare(Object obj1, Object obj2) {
                int retVal = 0;
                try {
                    //首字母转大写
                    String newStr = sortField.substring(0, 1).toUpperCase() + sortField.replaceFirst("\\w", "");
                    String methodStr = "get" + newStr;

                    Method method1 = ((T) obj1).getClass().getMethod(methodStr);
                    Method method2 = ((T) obj2).getClass().getMethod(methodStr);
                    Comparable r1 = (Comparable) method1.invoke((obj1));
                    Comparable r2 = (Comparable) method2.invoke((obj2));
                    if (sortMode != null && SortMode.DESC.equals(sortMode)) {
                        retVal = r2.compareTo(r1);
                    } else {
                        retVal = r1.compareTo(r2);
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Can not compare for " + JSONUtil.toJsonString(targetList));
                }
                return retVal;
            }
        });
    }

    public enum SortMode {
        ASC, DESC
    }
}