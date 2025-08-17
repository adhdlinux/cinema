package com.facebook.ads.internal.q.a;

import java.util.Locale;

public class t {
    public static String a(double d2) {
        return String.format(Locale.US, "%.3f", new Object[]{Double.valueOf(d2)});
    }

    public static String a(long j2) {
        return a(((double) j2) / 1000.0d);
    }
}
