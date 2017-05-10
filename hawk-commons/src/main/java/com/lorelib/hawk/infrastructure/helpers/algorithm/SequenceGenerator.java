package com.lorelib.hawk.infrastructure.helpers.algorithm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SequenceGenerator {

    private static final long ONE_STEP = 100;

    private static final Lock LOCK = new ReentrantLock();

    private static long lastTime = System.currentTimeMillis();

    private static short lastCount = 0;

    private static int count = 0;

    @SuppressWarnings("finally")
    public static String nextId() {
        LOCK.lock();
        try {
            if (lastCount == ONE_STEP) {
                boolean done = Boolean.FALSE;
                while (!done) {
                    long now = System.currentTimeMillis();
                    if (now == lastTime) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                        }
                    } else {
                        lastTime = now;
                        lastCount = 0;
                        done = Boolean.TRUE;
                    }
                }
            }
            count = lastCount++;
        } finally {
            LOCK.unlock();
            return lastTime + "" + String.format("%03d", count);
        }
    }

}
