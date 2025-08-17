package com.flask.colorpicker;

import android.graphics.Color;

public class Utils {
    public static int a(float f2, int i2) {
        return (b(f2) << 24) | (i2 & 16777215);
    }

    public static int b(float f2) {
        return Math.round(f2 * 255.0f);
    }

    public static int c(int i2, float f2) {
        float[] fArr = new float[3];
        Color.colorToHSV(i2, fArr);
        fArr[2] = f2;
        return Color.HSVToColor(fArr);
    }

    public static float d(int i2) {
        return ((float) Color.alpha(i2)) / 255.0f;
    }

    public static String e(int i2, boolean z2) {
        int i3;
        String str;
        if (z2) {
            i3 = -1;
        } else {
            i3 = 16777215;
        }
        if (z2) {
            str = "#%08X";
        } else {
            str = "#%06X";
        }
        return String.format(str, new Object[]{Integer.valueOf(i2 & i3)}).toUpperCase();
    }

    public static float f(int i2) {
        float[] fArr = new float[3];
        Color.colorToHSV(i2, fArr);
        return fArr[2];
    }
}
