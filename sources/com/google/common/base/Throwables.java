package com.google.common.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Throwables {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f30421a;

    /* renamed from: b  reason: collision with root package name */
    private static final Method f30422b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f30423c;

    static {
        Method method;
        Object b2 = b();
        f30421a = b2;
        Method method2 = null;
        if (b2 == null) {
            method = null;
        } else {
            method = a();
        }
        f30422b = method;
        if (b2 != null) {
            method2 = d(b2);
        }
        f30423c = method2;
    }

    private Throwables() {
    }

    private static Method a() {
        return c("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    private static Object b() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, (ClassLoader) null).getMethod("getJavaLangAccess", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader) null).getMethod(str, clsArr);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Object obj) {
        try {
            Method c2 = c("getStackTraceDepth", Throwable.class);
            if (c2 == null) {
                return null;
            }
            c2.invoke(obj, new Object[]{new Throwable()});
            return c2;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Deprecated
    public static <X extends Throwable> void e(Throwable th, Class<X> cls) throws Throwable {
        if (th != null) {
            h(th, cls);
        }
    }

    @Deprecated
    public static void f(Throwable th) {
        if (th != null) {
            i(th);
        }
    }

    public static <X extends Throwable> void g(Throwable th, Class<X> cls) throws Throwable {
        e(th, cls);
        f(th);
    }

    public static <X extends Throwable> void h(Throwable th, Class<X> cls) throws Throwable {
        Preconditions.l(th);
        if (cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    public static void i(Throwable th) {
        Preconditions.l(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        }
    }
}
