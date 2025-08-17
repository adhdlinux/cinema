package androidx.tracing;

import android.annotation.SuppressLint;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Trace {

    /* renamed from: a  reason: collision with root package name */
    private static long f11690a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f11691b;

    private Trace() {
    }

    public static void a(String str) {
        TraceApi18Impl.a(str);
    }

    public static void b() {
        TraceApi18Impl.b();
    }

    private static void c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    @SuppressLint({"NewApi"})
    public static boolean d() {
        try {
            if (f11691b == null) {
                return android.os.Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return e();
    }

    private static boolean e() {
        Class<android.os.Trace> cls = android.os.Trace.class;
        try {
            if (f11691b == null) {
                f11690a = cls.getField("TRACE_TAG_APP").getLong((Object) null);
                f11691b = cls.getMethod("isTagEnabled", new Class[]{Long.TYPE});
            }
            return ((Boolean) f11691b.invoke((Object) null, new Object[]{Long.valueOf(f11690a)})).booleanValue();
        } catch (Exception e2) {
            c("isTagEnabled", e2);
            return false;
        }
    }
}
