package androidx.media3.common.util;

import android.text.TextUtils;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

public final class Log {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f4669a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static int f4670b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4671c = true;

    /* renamed from: d  reason: collision with root package name */
    private static Logger f4672d = Logger.f4673a;

    public interface Logger {

        /* renamed from: a  reason: collision with root package name */
        public static final Logger f4673a = new Logger() {
            public void d(String str, String str2, Throwable th) {
                android.util.Log.d(str, Log.a(str2, th));
            }

            public void e(String str, String str2, Throwable th) {
                android.util.Log.e(str, Log.a(str2, th));
            }

            public void i(String str, String str2, Throwable th) {
                android.util.Log.i(str, Log.a(str2, th));
            }

            public void w(String str, String str2, Throwable th) {
                android.util.Log.w(str, Log.a(str2, th));
            }
        };

        void d(String str, String str2, Throwable th);

        void e(String str, String str2, Throwable th);

        void i(String str, String str2, Throwable th);

        void w(String str, String str2, Throwable th);
    }

    private Log() {
    }

    @Pure
    public static String a(String str, Throwable th) {
        String e2 = e(th);
        if (TextUtils.isEmpty(e2)) {
            return str;
        }
        return str + "\n  " + e2.replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "\n  ") + 10;
    }

    @Pure
    public static void b(String str, String str2) {
        synchronized (f4669a) {
            if (f4670b == 0) {
                f4672d.d(str, str2, (Throwable) null);
            }
        }
    }

    @Pure
    public static void c(String str, String str2) {
        synchronized (f4669a) {
            if (f4670b <= 3) {
                f4672d.e(str, str2, (Throwable) null);
            }
        }
    }

    @Pure
    public static void d(String str, String str2, Throwable th) {
        synchronized (f4669a) {
            if (f4670b <= 3) {
                f4672d.e(str, str2, th);
            }
        }
    }

    @Pure
    public static String e(Throwable th) {
        if (th == null) {
            return null;
        }
        synchronized (f4669a) {
            if (g(th)) {
                return "UnknownHostException (no network)";
            }
            if (!f4671c) {
                String message = th.getMessage();
                return message;
            }
            String replace = android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
            return replace;
        }
    }

    @Pure
    public static void f(String str, String str2) {
        synchronized (f4669a) {
            if (f4670b <= 1) {
                f4672d.i(str, str2, (Throwable) null);
            }
        }
    }

    @Pure
    private static boolean g(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    @Pure
    public static void h(String str, String str2) {
        synchronized (f4669a) {
            if (f4670b <= 2) {
                f4672d.w(str, str2, (Throwable) null);
            }
        }
    }

    @Pure
    public static void i(String str, String str2, Throwable th) {
        synchronized (f4669a) {
            if (f4670b <= 2) {
                f4672d.w(str, str2, th);
            }
        }
    }
}
