package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

class CollectionsKt__IterablesKt extends CollectionsKt__CollectionsKt {
    public static <T> int p(Iterable<? extends T> iterable, int i2) {
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return i2;
    }

    public static final <T> Integer q(Iterable<? extends T> iterable) {
        Intrinsics.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    public static <T> List<T> r(Iterable<? extends Iterable<? extends T>> iterable) {
        Intrinsics.f(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Iterable u2 : iterable) {
            boolean unused = CollectionsKt__MutableCollectionsKt.u(arrayList, u2);
        }
        return arrayList;
    }
}
