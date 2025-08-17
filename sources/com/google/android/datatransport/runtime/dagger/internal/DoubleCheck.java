package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f22563c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Provider<T> f22564a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f22565b = f22563c;

    private DoubleCheck(Provider<T> provider) {
        this.f22564a = provider;
    }

    public static <P extends Provider<T>, T> Lazy<T> a(P p2) {
        if (p2 instanceof Lazy) {
            return (Lazy) p2;
        }
        return new DoubleCheck((Provider) Preconditions.b(p2));
    }

    public static <P extends Provider<T>, T> Provider<T> b(P p2) {
        Preconditions.b(p2);
        if (p2 instanceof DoubleCheck) {
            return p2;
        }
        return new DoubleCheck(p2);
    }

    public static Object c(Object obj, Object obj2) {
        boolean z2;
        if (obj == f22563c || (obj instanceof MemoizedSentinel)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public T get() {
        T t2 = this.f22565b;
        T t3 = f22563c;
        if (t2 == t3) {
            synchronized (this) {
                t2 = this.f22565b;
                if (t2 == t3) {
                    t2 = this.f22564a.get();
                    this.f22565b = c(this.f22565b, t2);
                    this.f22564a = null;
                }
            }
        }
        return t2;
    }
}
