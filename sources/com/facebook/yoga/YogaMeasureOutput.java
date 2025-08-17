package com.facebook.yoga;

public class YogaMeasureOutput {
    public static float getHeight(long j2) {
        return Float.intBitsToFloat((int) (j2 & -1));
    }

    public static float getWidth(long j2) {
        return Float.intBitsToFloat((int) ((j2 >> 32) & -1));
    }

    public static long make(float f2, float f3) {
        int floatToRawIntBits = Float.floatToRawIntBits(f2);
        return ((long) Float.floatToRawIntBits(f3)) | (((long) floatToRawIntBits) << 32);
    }

    public static long make(int i2, int i3) {
        return make((float) i2, (float) i3);
    }
}
