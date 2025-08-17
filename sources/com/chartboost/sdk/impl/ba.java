package com.chartboost.sdk.impl;

public abstract class ba {
    public static final int a(float f2) {
        if (f2 == 0.0f) {
            return 0;
        }
        double d2 = (double) f2;
        if (d2 < 0.25d) {
            return 1;
        }
        if (d2 < 0.5d) {
            return 2;
        }
        if (d2 < 0.75d) {
            return 3;
        }
        return f2 < 1.0f ? 4 : 5;
    }
}
