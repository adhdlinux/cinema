package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public static final <T> Collection<T> c(T[] tArr) {
        Intrinsics.f(tArr, "<this>");
        return new ArrayAsCollection(tArr, false);
    }

    public static final <T extends Comparable<? super T>> int d(List<? extends T> list, T t2, int i2, int i3) {
        Intrinsics.f(list, "<this>");
        m(list.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int a2 = ComparisonsKt__ComparisonsKt.a((Comparable) list.get(i5), t2);
            if (a2 < 0) {
                i2 = i5 + 1;
            } else if (a2 <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int e(List list, Comparable comparable, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = list.size();
        }
        return d(list, comparable, i2, i3);
    }

    public static <T> List<T> f() {
        return EmptyList.f40319b;
    }

    public static IntRange g(Collection<?> collection) {
        Intrinsics.f(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    public static <T> int h(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> i(T... tArr) {
        Intrinsics.f(tArr, "elements");
        if (tArr.length > 0) {
            return ArraysKt___ArraysJvmKt.d(tArr);
        }
        return f();
    }

    public static <T> List<T> j(T... tArr) {
        Intrinsics.f(tArr, "elements");
        return ArraysKt___ArraysKt.u(tArr);
    }

    public static <T> List<T> k(T... tArr) {
        Intrinsics.f(tArr, "elements");
        if (tArr.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(new ArrayAsCollection(tArr, true));
    }

    public static final <T> List<T> l(List<? extends T> list) {
        Intrinsics.f(list, "<this>");
        int size = list.size();
        if (size == 0) {
            return f();
        }
        if (size != 1) {
            return list;
        }
        return CollectionsKt__CollectionsJVMKt.b(list.get(0));
    }

    private static final void m(int i2, int i3, int i4) {
        if (i3 > i4) {
            throw new IllegalArgumentException("fromIndex (" + i3 + ") is greater than toIndex (" + i4 + ").");
        } else if (i3 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i3 + ") is less than zero.");
        } else if (i4 > i2) {
            throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + i2 + ").");
        }
    }

    public static void n() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void o() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
