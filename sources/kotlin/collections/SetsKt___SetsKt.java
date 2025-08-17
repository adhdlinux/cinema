package kotlin.collections;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

class SetsKt___SetsKt extends SetsKt__SetsKt {
    public static <T> Set<T> e(Set<? extends T> set, Iterable<? extends T> iterable) {
        int i2;
        Intrinsics.f(set, "<this>");
        Intrinsics.f(iterable, "elements");
        Integer q2 = CollectionsKt__IterablesKt.q(iterable);
        if (q2 != null) {
            i2 = set.size() + q2.intValue();
        } else {
            i2 = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.d(i2));
        linkedHashSet.addAll(set);
        boolean unused = CollectionsKt__MutableCollectionsKt.u(linkedHashSet, iterable);
        return linkedHashSet;
    }
}
