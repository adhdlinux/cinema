package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public final class Iterables {
    private Iterables() {
    }

    public static <T> boolean a(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.b(iterable.iterator(), predicate);
    }

    private static <E> Collection<E> b(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return Lists.i(iterable.iterator());
    }

    public static <T> T c(Iterable<? extends T> iterable, T t2) {
        return Iterators.m(iterable.iterator(), t2);
    }

    public static <T> T d(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return Iterators.k(iterable.iterator());
        }
        List list = (List) iterable;
        if (!list.isEmpty()) {
            return f(list);
        }
        throw new NoSuchElementException();
    }

    public static <T> T e(Iterable<? extends T> iterable, T t2) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return t2;
            }
            if (iterable instanceof List) {
                return f(Lists.a(iterable));
            }
        }
        return Iterators.l(iterable.iterator(), t2);
    }

    private static <T> T f(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> T g(Iterable<T> iterable) {
        return Iterators.n(iterable.iterator());
    }

    public static <T> boolean h(Iterable<T> iterable, Predicate<? super T> predicate) {
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            return Iterators.r(iterable.iterator(), predicate);
        }
        return i((List) iterable, (Predicate) Preconditions.l(predicate));
    }

    private static <T> boolean i(List<T> list, Predicate<? super T> predicate) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < list.size()) {
            T t2 = list.get(i2);
            if (!predicate.apply(t2)) {
                if (i2 > i3) {
                    try {
                        list.set(i3, t2);
                    } catch (UnsupportedOperationException unused) {
                        j(list, predicate, i3, i2);
                        return true;
                    } catch (IllegalArgumentException unused2) {
                        j(list, predicate, i3, i2);
                        return true;
                    }
                }
                i3++;
            }
            i2++;
        }
        list.subList(i3, list.size()).clear();
        if (i2 != i3) {
            return true;
        }
        return false;
    }

    private static <T> void j(List<T> list, Predicate<? super T> predicate, int i2, int i3) {
        for (int size = list.size() - 1; size > i3; size--) {
            if (predicate.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            list.remove(i4);
        }
    }

    static Object[] k(Iterable<?> iterable) {
        return b(iterable).toArray();
    }
}
