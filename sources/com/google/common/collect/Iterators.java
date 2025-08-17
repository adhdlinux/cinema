package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Iterators {

    private static final class ArrayItr<T> extends AbstractIndexedListIterator<T> {

        /* renamed from: e  reason: collision with root package name */
        static final UnmodifiableListIterator<Object> f30549e = new ArrayItr(new Object[0], 0);

        /* renamed from: d  reason: collision with root package name */
        private final T[] f30550d;

        ArrayItr(T[] tArr, int i2) {
            super(tArr.length, i2);
            this.f30550d = tArr;
        }

        /* access modifiers changed from: protected */
        public T a(int i2) {
            return this.f30550d[i2];
        }
    }

    private enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.c(false);
        }
    }

    private static final class SingletonIterator<T> extends UnmodifiableIterator<T> {

        /* renamed from: c  reason: collision with root package name */
        private static final Object f30553c = new Object();

        /* renamed from: b  reason: collision with root package name */
        private Object f30554b;

        SingletonIterator(T t2) {
            this.f30554b = t2;
        }

        public boolean hasNext() {
            return this.f30554b != f30553c;
        }

        public T next() {
            T t2 = this.f30554b;
            T t3 = f30553c;
            if (t2 != t3) {
                this.f30554b = t3;
                return t2;
            }
            throw new NoSuchElementException();
        }
    }

    private Iterators() {
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it2) {
        Preconditions.l(collection);
        Preconditions.l(it2);
        boolean z2 = false;
        while (it2.hasNext()) {
            z2 |= collection.add(it2.next());
        }
        return z2;
    }

    public static <T> boolean b(Iterator<T> it2, Predicate<? super T> predicate) {
        return o(it2, predicate) != -1;
    }

    static void c(Iterator<?> it2) {
        Preconditions.l(it2);
        while (it2.hasNext()) {
            it2.next();
            it2.remove();
        }
    }

    public static boolean d(Iterator<?> it2, Object obj) {
        if (obj == null) {
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it2.hasNext()) {
            if (obj.equals(it2.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0006  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean e(java.util.Iterator<?> r3, java.util.Iterator<?> r4) {
        /*
        L_0x0000:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x001d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = com.google.common.base.Objects.a(r0, r2)
            if (r0 != 0) goto L_0x0000
            return r1
        L_0x001d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterators.e(java.util.Iterator, java.util.Iterator):boolean");
    }

    static <T> UnmodifiableIterator<T> f() {
        return g();
    }

    static <T> UnmodifiableListIterator<T> g() {
        return ArrayItr.f30549e;
    }

    static <T> Iterator<T> h() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> UnmodifiableIterator<T> i(final Iterator<T> it2, final Predicate<? super T> predicate) {
        Preconditions.l(it2);
        Preconditions.l(predicate);
        return new AbstractIterator<T>() {
            /* access modifiers changed from: protected */
            public T a() {
                while (it2.hasNext()) {
                    T next = it2.next();
                    if (predicate.apply(next)) {
                        return next;
                    }
                }
                return b();
            }
        };
    }

    public static <T> T j(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.l(it2);
        Preconditions.l(predicate);
        while (it2.hasNext()) {
            T next = it2.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public static <T> T k(Iterator<T> it2) {
        T next;
        do {
            next = it2.next();
        } while (it2.hasNext());
        return next;
    }

    public static <T> T l(Iterator<? extends T> it2, T t2) {
        return it2.hasNext() ? k(it2) : t2;
    }

    public static <T> T m(Iterator<? extends T> it2, T t2) {
        return it2.hasNext() ? it2.next() : t2;
    }

    public static <T> T n(Iterator<T> it2) {
        T next = it2.next();
        if (!it2.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <");
        sb.append(next);
        for (int i2 = 0; i2 < 4 && it2.hasNext(); i2++) {
            sb.append(", ");
            sb.append(it2.next());
        }
        if (it2.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');
        throw new IllegalArgumentException(sb.toString());
    }

    public static <T> int o(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.m(predicate, "predicate");
        int i2 = 0;
        while (it2.hasNext()) {
            if (predicate.apply(it2.next())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    static <T> T p(Iterator<T> it2) {
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        it2.remove();
        return next;
    }

    public static boolean q(Iterator<?> it2, Collection<?> collection) {
        Preconditions.l(collection);
        boolean z2 = false;
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static <T> boolean r(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.l(predicate);
        boolean z2 = false;
        while (it2.hasNext()) {
            if (predicate.apply(it2.next())) {
                it2.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static <T> UnmodifiableIterator<T> s(T t2) {
        return new SingletonIterator(t2);
    }
}
