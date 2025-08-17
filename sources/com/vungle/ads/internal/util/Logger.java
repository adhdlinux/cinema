package com.vungle.ads.internal.util;

import android.util.Log;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

public final class Logger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static boolean enabled;

    public static final int d(String str, String str2) {
        return Companion.d(str, str2);
    }

    public static final int e(String str, String str2) {
        return Companion.e(str, str2);
    }

    public static final int e(String str, String str2, Throwable th) {
        return Companion.e(str, str2, th);
    }

    public static final int i(String str, String str2) {
        return Companion.i(str, str2);
    }

    public static final int i(String str, String str2, Throwable th) {
        return Companion.i(str, str2, th);
    }

    public static final int w(String str, String str2) {
        return Companion.w(str, str2);
    }

    public static final int w(String str, String str2, Throwable th) {
        return Companion.w(str, str2, th);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int d(String str, String str2) {
            Intrinsics.f(str, "tag");
            Intrinsics.f(str2, "message");
            if (!Logger.enabled) {
                return -1;
            }
            return Log.d(str, eraseSensitiveData(str2));
        }

        public final int e(String str, String str2) {
            Intrinsics.f(str, "tag");
            Intrinsics.f(str2, "message");
            if (!Logger.enabled) {
                return -1;
            }
            return Log.e(str, eraseSensitiveData(str2));
        }

        public final void enable(boolean z2) {
            Logger.enabled = z2;
        }

        public final String eraseSensitiveData(String str) {
            Intrinsics.f(str, "<this>");
            Pattern compile = Pattern.compile("[\\d]{1,3}\\.[\\d]{1,3}\\.[\\d]{1,3}\\.[\\d]{1,3}");
            Intrinsics.e(compile, "compile(\"[\\\\d]{1,3}\\\\.[\\…[\\\\d]{1,3}\\\\.[\\\\d]{1,3}\")");
            return new Regex(compile).h(str, "xxx.xxx.xxx.xxx");
        }

        public final int i(String str, String str2) {
            Intrinsics.f(str, "tag");
            Intrinsics.f(str2, "message");
            if (!Logger.enabled) {
                return -1;
            }
            return Log.i(str, eraseSensitiveData(str2));
        }

        public final int w(String str, String str2) {
            Intrinsics.f(str, "tag");
            Intrinsics.f(str2, "message");
            if (!Logger.enabled) {
                return -1;
            }
            return Log.w(str, eraseSensitiveData(str2));
        }

        public final int e(String str, String str2, Throwable th) {
            Intrinsics.f(str, "tag");
            Intrinsics.f(str2, "message");
            Intrinsics.f(th, "throwable");
            if (!Logger.enabled) {
                return -1;
            }
            return Log.e(str, eraseSensitiveData(str2) + "; error: " + th.getLocalizedMessage());
        }

        public final int i(String str, String str2, Throwable th) {
            Intrinsics.f(str, "tag");
            Intrinsics.f(str2, "message");
            Intrinsics.f(th, "throwable");
            if (!Logger.enabled) {
                return -1;
            }
            return Log.i(str, eraseSensitiveData(str2) + "; error: " + th.getLocalizedMessage());
        }

        public final int w(String str, String str2, Throwable th) {
            Intrinsics.f(str, "tag");
            Intrinsics.f(str2, "message");
            Intrinsics.f(th, "throwable");
            if (!Logger.enabled) {
                return -1;
            }
            return Log.w(str, eraseSensitiveData(str2) + "; error: " + th.getLocalizedMessage());
        }
    }
}
