package com.google.common.base;

import java.io.Serializable;

public abstract class Equivalence<T> {

    static final class Equals extends Equivalence<Object> implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        static final Equals f30388b = new Equals();

        Equals() {
        }

        /* access modifiers changed from: protected */
        public boolean a(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        /* access modifiers changed from: protected */
        public int b(Object obj) {
            return obj.hashCode();
        }
    }

    static final class Identity extends Equivalence<Object> implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        static final Identity f30389b = new Identity();

        Identity() {
        }

        /* access modifiers changed from: protected */
        public boolean a(Object obj, Object obj2) {
            return false;
        }

        /* access modifiers changed from: protected */
        public int b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    protected Equivalence() {
    }

    public static Equivalence<Object> c() {
        return Equals.f30388b;
    }

    public static Equivalence<Object> f() {
        return Identity.f30389b;
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(T t2, T t3);

    /* access modifiers changed from: protected */
    public abstract int b(T t2);

    public final boolean d(T t2, T t3) {
        if (t2 == t3) {
            return true;
        }
        if (t2 == null || t3 == null) {
            return false;
        }
        return a(t2, t3);
    }

    public final int e(T t2) {
        if (t2 == null) {
            return 0;
        }
        return b(t2);
    }
}
