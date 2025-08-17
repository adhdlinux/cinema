package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

@Deprecated
public final class TraceCompat {

    /* renamed from: a  reason: collision with root package name */
    private static long f2625a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f2626b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f2627c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f2628d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f2629e;

    static class Api18Impl {
        private Api18Impl() {
        }

        static void a(String str) {
            Trace.beginSection(str);
        }

        static void b() {
            Trace.endSection();
        }
    }

    static {
        Class<String> cls = String.class;
        Class<Trace> cls2 = Trace.class;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f2625a = cls2.getField("TRACE_TAG_APP").getLong((Object) null);
                Class cls3 = Long.TYPE;
                f2626b = cls2.getMethod("isTagEnabled", new Class[]{cls3});
                Class cls4 = Integer.TYPE;
                f2627c = cls2.getMethod("asyncTraceBegin", new Class[]{cls3, cls, cls4});
                f2628d = cls2.getMethod("asyncTraceEnd", new Class[]{cls3, cls, cls4});
                f2629e = cls2.getMethod("traceCounter", new Class[]{cls3, cls, cls4});
            } catch (Exception e2) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e2);
            }
        }
    }

    private TraceCompat() {
    }

    public static void a(String str) {
        Api18Impl.a(str);
    }

    public static void b() {
        Api18Impl.b();
    }
}
