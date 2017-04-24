package com.lorelib.hawk.infrastructure.helpers;

import java.util.Map;

/**
 * @author listening
 * @description CurrentThreadHolderTest:
 * @create 2017 04 24 14:22.
 */
public class CurrentThreadHolderTest {
    public static void main(String[] args) {
        CurrentThreadHolder.set("k1", "test1");
        Map data = CurrentThreadHolder.get();

        CurrentThreadHolder.set("k2", "test2");
        data = CurrentThreadHolder.get();

        System.out.println(data.size());
    }
}
