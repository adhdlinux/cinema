package com.startapp;

public class l2 {

    /* renamed from: a  reason: collision with root package name */
    private static a f34853a;

    public interface a {
        void a(Throwable th);
    }

    public static class b {
        public static StackTraceElement[] a() {
            return Thread.currentThread().getStackTrace();
        }
    }

    public static void a(a aVar) {
        f34853a = aVar;
    }

    private static void a(Throwable th, boolean z2, boolean z3) {
    }

    public static void b(Throwable th) {
        a(th, true, true);
    }

    public static void c(Throwable th) {
        a aVar = f34853a;
        if (aVar != null) {
            try {
                aVar.a(th);
            } catch (Throwable unused) {
            }
        } else {
            a(th, false, false);
        }
    }

    public static void a(Throwable th) {
        a(th, true, false);
    }

    private static StackTraceElement a(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        StackTraceElement[] a2 = b.a();
        if (a2 == null) {
            return null;
        }
        String name = b.class.getName();
        int length = a2.length;
        for (int i3 = 0; i3 < length; i3++) {
            StackTraceElement stackTraceElement = a2[i3];
            if (stackTraceElement != null && name.equals(stackTraceElement.getClassName())) {
                int i4 = i3 + 3 + i2;
                if (i4 < length) {
                    return a2[i4];
                }
                return null;
            }
        }
        return null;
    }
}
