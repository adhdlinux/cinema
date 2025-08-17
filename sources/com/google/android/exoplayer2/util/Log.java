package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

public final class Log {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f28702a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static int f28703b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f28704c = true;

    /* renamed from: d  reason: collision with root package name */
    private static Logger f28705d = Logger.f28706a;

    public interface Logger {

        /* renamed from: a  reason: collision with root package name */
        public static final Logger f28706a = new Logger() {
            public void d(String str, String str2) {
                android.util.Log.d(str, str2);
            }

            public void e(String str, String str2) {
                android.util.Log.e(str, str2);
            }

            public void i(String str, String str2) {
                android.util.Log.i(str, str2);
            }

            public void w(String str, String str2) {
                android.util.Log.w(str, str2);
            }
        };

        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void w(String str, String str2);
    }

    private Log() {
    }

    @Pure
    private static String a(String str, Throwable th) {
        String e2 = e(th);
        if (TextUtils.isEmpty(e2)) {
            return str;
        }
        return str + "\n  " + e2.replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "\n  ") + 10;
    }

    @Pure
    public static void b(String str, String str2) {
        synchronized (f28702a) {
            if (f28703b == 0) {
                f28705d.d(str, str2);
            }
        }
    }

    @Pure
    public static void c(String str, String str2) {
        synchronized (f28702a) {
            if (f28703b <= 3) {
                f28705d.e(str, str2);
            }
        }
    }

    @Pure
    public static void d(String str, String str2, Throwable th) {
        c(str, a(str2, th));
    }

    @Pure
    public static String e(Throwable th) {
        synchronized (f28702a) {
            if (th == null) {
                return null;
            }
            if (h(th)) {
                return "UnknownHostException (no network)";
            }
            if (!f28704c) {
                String message = th.getMessage();
                return message;
            }
            String replace = android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
            return replace;
        }
    }

    @Pure
    public static void f(String str, String str2) {
        synchronized (f28702a) {
            if (f28703b <= 1) {
                f28705d.i(str, str2);
            }
        }
    }

    @Pure
    public static void g(String str, String str2, Throwable th) {
        f(str, a(str2, th));
    }

    @Pure
    private static boolean h(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    @Pure
    public static void i(String str, String str2) {
        synchronized (f28702a) {
            if (f28703b <= 2) {
                f28705d.w(str, str2);
            }
        }
    }

    @Pure
    public static void j(String str, String str2, Throwable th) {
        i(str, a(str2, th));
    }
}
