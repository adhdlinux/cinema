package com.facebook.react.views.view;

import com.facebook.imageutils.JfifUtil;

public class ColorUtil {
    private static int clamp255(double d2) {
        return Math.max(0, Math.min(JfifUtil.MARKER_FIRST_BYTE, (int) Math.round(d2)));
    }

    public static int getOpacityFromColor(int i2) {
        int i3 = i2 >>> 24;
        if (i3 == 255) {
            return -1;
        }
        return i3 == 0 ? -2 : -3;
    }

    public static int multiplyColorAlpha(int i2, int i3) {
        if (i3 == 255) {
            return i2;
        }
        if (i3 == 0) {
            return i2 & 16777215;
        }
        return (i2 & 16777215) | ((((i2 >>> 24) * (i3 + (i3 >> 7))) >> 8) << 24);
    }

    public static int normalize(double d2, double d3, double d4, double d5) {
        return (clamp255(d2) << 16) | (clamp255(d5 * 255.0d) << 24) | (clamp255(d3) << 8) | clamp255(d4);
    }
}
