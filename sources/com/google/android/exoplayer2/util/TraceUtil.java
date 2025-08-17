package com.google.android.exoplayer2.util;

import android.os.Trace;

public final class TraceUtil {
    private TraceUtil() {
    }

    public static void a(String str) {
        if (Util.f28808a >= 18) {
            b(str);
        }
    }

    private static void b(String str) {
        Trace.beginSection(str);
    }

    public static void c() {
        if (Util.f28808a >= 18) {
            d();
        }
    }

    private static void d() {
        Trace.endSection();
    }
}
