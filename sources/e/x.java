package e;

import android.annotation.SuppressLint;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;

public final /* synthetic */ class x {
    public static int a(int i2) {
        return c(i2, 0, 0, 0);
    }

    public static int b(int i2, int i3, int i4) {
        return e(i2, i3, i4, 0, 128, 0);
    }

    public static int c(int i2, int i3, int i4, int i5) {
        return e(i2, i3, i4, 0, 128, i5);
    }

    public static int d(int i2, int i3, int i4, int i5, int i6) {
        return e(i2, i3, i4, i5, i6, 0);
    }

    @SuppressLint({"WrongConstant"})
    public static int e(int i2, int i3, int i4, int i5, int i6, int i7) {
        return i2 | i3 | i4 | i5 | i6 | i7;
    }

    @SuppressLint({"WrongConstant"})
    public static int f(int i2) {
        return i2 & 24;
    }

    @SuppressLint({"WrongConstant"})
    public static int g(int i2) {
        return i2 & 3584;
    }

    @SuppressLint({"WrongConstant"})
    public static int h(int i2) {
        return i2 & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
    }

    @SuppressLint({"WrongConstant"})
    public static int i(int i2) {
        return i2 & 7;
    }

    @SuppressLint({"WrongConstant"})
    public static int j(int i2) {
        return i2 & 64;
    }

    @SuppressLint({"WrongConstant"})
    public static int k(int i2) {
        return i2 & 32;
    }

    public static boolean l(int i2, boolean z2) {
        int i3 = i(i2);
        return i3 == 4 || (z2 && i3 == 3);
    }
}
