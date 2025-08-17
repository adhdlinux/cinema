package com.chartboost.sdk.impl;

import android.util.Log;
import com.chartboost.sdk.LoggingLevel;
import kotlin.jvm.internal.Intrinsics;

public final class w7 {

    /* renamed from: a  reason: collision with root package name */
    public static final w7 f18896a = new w7();

    /* renamed from: b  reason: collision with root package name */
    public static LoggingLevel f18897b = LoggingLevel.INTEGRATION;

    public static final void a(String str, String str2) {
        Intrinsics.f(str, "tag");
        Intrinsics.f(str2, "msg");
        if (f18897b == LoggingLevel.ALL) {
            Log.d(str, str2);
        }
    }

    public static final void b(String str, String str2) {
        Intrinsics.f(str, "tag");
        Intrinsics.f(str2, "msg");
        if (f18897b == LoggingLevel.ALL) {
            Log.e(str, str2);
        }
    }

    public static final void c(String str, String str2) {
        Intrinsics.f(str, "tag");
        Intrinsics.f(str2, "msg");
        if (f18897b == LoggingLevel.ALL) {
            Log.i(str, str2);
        }
    }

    public static final void d(String str, String str2) {
        Intrinsics.f(str, "tag");
        Intrinsics.f(str2, "msg");
        if (f18897b == LoggingLevel.ALL) {
            Log.v(str, str2);
        }
    }

    public static final void e(String str, String str2) {
        Intrinsics.f(str, "tag");
        Intrinsics.f(str2, "msg");
        if (f18897b == LoggingLevel.ALL) {
            Log.w(str, str2);
        }
    }

    public static final void a(String str, String str2, Throwable th) {
        Intrinsics.f(str, "tag");
        Intrinsics.f(str2, "msg");
        Intrinsics.f(th, "tr");
        if (f18897b == LoggingLevel.ALL) {
            Log.e(str, str2, th);
        }
    }
}
