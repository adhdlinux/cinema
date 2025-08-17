package com.xuhao.didi.socket.common.interfaces.utils;

public class ThreadUtils {
    public static void sleep(long j2) {
        long j3 = 0;
        long j4 = 0;
        while (true) {
            long j5 = j3 - j4;
            if (j5 < j2) {
                j2 -= j5;
                try {
                    j4 = System.currentTimeMillis();
                    Thread.sleep(j2);
                    j3 = System.currentTimeMillis();
                } catch (InterruptedException unused) {
                    j3 = System.currentTimeMillis();
                }
            } else {
                return;
            }
        }
    }
}
