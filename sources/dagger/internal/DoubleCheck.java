package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f38169c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Provider<T> f38170a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f38171b = f38169c;

    private DoubleCheck(Provider<T> provider) {
        this.f38170a = provider;
    }

    public static <P extends Provider<T>, T> Provider<T> a(P p2) {
        Preconditions.b(p2);
        if (p2 instanceof DoubleCheck) {
            return p2;
        }
        return new DoubleCheck(p2);
    }

    private static Object b(Object obj, Object obj2) {
        boolean z2;
        if (obj != f38169c) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public T get() {
        T t2 = this.f38171b;
        T t3 = f38169c;
        if (t2 == t3) {
            synchronized (this) {
                t2 = this.f38171b;
                if (t2 == t3) {
                    t2 = this.f38170a.get();
                    this.f38171b = b(this.f38171b, t2);
                    this.f38170a = null;
                }
            }
        }
        return t2;
    }
}
