package com.google.android.exoplayer2.ui;

import android.graphics.Color;
import com.google.android.exoplayer2.util.Util;

final class HtmlUtils {
    private HtmlUtils() {
    }

    public static String a(String str) {
        return "." + str + ",." + str + " *";
    }

    public static String b(int i2) {
        return Util.C("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i2)), Integer.valueOf(Color.green(i2)), Integer.valueOf(Color.blue(i2)), Double.valueOf(((double) Color.alpha(i2)) / 255.0d));
    }
}
