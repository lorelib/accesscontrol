package com.lorelib.hawk.infrastructure.helpers;

import java.util.Comparator;

/**
 * Created by luomm on 2015/11/4.
 */
public class StringToLowerComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.toLowerCase().compareTo(o2.toLowerCase());
    }

}
