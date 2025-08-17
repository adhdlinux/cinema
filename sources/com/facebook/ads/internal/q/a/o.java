package com.facebook.ads.internal.q.a;

import java.util.Random;

public class o {
    private static String a() {
        return q.a(Thread.currentThread().getStackTrace());
    }

    public static String a(int i2) {
        if (i2 > 0 && new Random().nextFloat() < 1.0f / ((float) i2)) {
            return a();
        }
        return null;
    }
}
