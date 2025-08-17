package com.squareup.duktape;

import java.io.Closeable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

public final class Duktape implements Closeable {
    /* access modifiers changed from: private */
    public long context;

    static {
        System.loadLibrary("duktape");
    }

    private Duktape(long j2) {
        this.context = j2;
    }

    /* access modifiers changed from: private */
    public native Object call(long j2, long j3, Object obj, Object[] objArr);

    public static Duktape create() {
        long createContext = createContext();
        if (createContext != 0) {
            return new Duktape(createContext);
        }
        throw new OutOfMemoryError("Cannot create Duktape instance");
    }

    private static native long createContext();

    private native void destroyContext(long j2);

    private native Object evaluate(long j2, String str, String str2);

    private native long get(long j2, String str, Object[] objArr);

    private native void set(long j2, String str, Object obj, Object[] objArr);

    public synchronized void close() {
        long j2 = this.context;
        if (j2 != 0) {
            this.context = 0;
            destroyContext(j2);
        }
    }

    public synchronized Object evaluate(String str, String str2) {
        return evaluate(this.context, str, str2);
    }

    /* access modifiers changed from: protected */
    public synchronized void finalize() {
        if (this.context != 0) {
            Logger.getLogger(Duktape.class.getName()).warning("Duktape instance leaked!");
        }
    }

    public synchronized <T> T get(String str, Class<T> cls) {
        final long j2;
        final String str2;
        final Class<T> cls2;
        if (!cls.isInterface()) {
            throw new UnsupportedOperationException("Only interfaces can be proxied. Received: " + cls);
        } else if (cls.getInterfaces().length <= 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Method[] methods = cls.getMethods();
            int length = methods.length;
            int i2 = 0;
            while (i2 < length) {
                Method method = methods[i2];
                if (linkedHashMap.put(method.getName(), method) == null) {
                    i2++;
                } else {
                    throw new UnsupportedOperationException(method.getName() + " is overloaded in " + cls);
                }
            }
            j2 = get(this.context, str, linkedHashMap.values().toArray());
            str2 = str;
            cls2 = cls;
        } else {
            throw new UnsupportedOperationException(cls + " must not extend other interfaces");
        }
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                Object access$100;
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                synchronized (this) {
                    access$100 = Duktape.this.call(this.context, j2, method, objArr);
                }
                return access$100;
            }

            public String toString() {
                return String.format("DuktapeProxy{name=%s, type=%s}", new Object[]{str2, cls2.getName()});
            }
        });
    }

    public synchronized <T> void set(String str, Class<T> cls, T t2) {
        if (!cls.isInterface()) {
            throw new UnsupportedOperationException("Only interfaces can be bound. Received: " + cls);
        } else if (cls.getInterfaces().length > 0) {
            throw new UnsupportedOperationException(cls + " must not extend other interfaces");
        } else if (cls.isInstance(t2)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Method[] methods = cls.getMethods();
            int length = methods.length;
            int i2 = 0;
            while (i2 < length) {
                Method method = methods[i2];
                if (linkedHashMap.put(method.getName(), method) == null) {
                    i2++;
                } else {
                    throw new UnsupportedOperationException(method.getName() + " is overloaded in " + cls);
                }
            }
            set(this.context, str, t2, linkedHashMap.values().toArray());
        } else {
            throw new IllegalArgumentException(t2.getClass() + " is not an instance of " + cls);
        }
    }

    public synchronized Object evaluate(String str) {
        return evaluate(this.context, str, "?");
    }
}
