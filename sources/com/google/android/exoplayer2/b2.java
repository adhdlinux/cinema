package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;

public final /* synthetic */ class b2 {
    public static int a(int i2) {
        return b(i2, 0, 0);
    }

    public static int b(int i2, int i3, int i4) {
        return c(i2, i3, i4, 0, 128);
    }

    @SuppressLint({"WrongConstant"})
    public static int c(int i2, int i3, int i4, int i5, int i6) {
        return i2 | i3 | i4 | i5 | i6;
    }

    @SuppressLint({"WrongConstant"})
    public static int d(int i2) {
        return i2 & 24;
    }

    @SuppressLint({"WrongConstant"})
    public static int e(int i2) {
        return i2 & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
    }

    @SuppressLint({"WrongConstant"})
    public static int f(int i2) {
        return i2 & 7;
    }

    @SuppressLint({"WrongConstant"})
    public static int g(int i2) {
        return i2 & 64;
    }

    @SuppressLint({"WrongConstant"})
    public static int h(int i2) {
        return i2 & 32;
    }
}
