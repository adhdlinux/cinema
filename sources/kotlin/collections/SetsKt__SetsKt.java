package kotlin.collections;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    public static <T> Set<T> b() {
        return EmptySet.f40321b;
    }

    public static final <T> Set<T> c(Set<? extends T> set) {
        Intrinsics.f(set, "<this>");
        int size = set.size();
        if (size == 0) {
            return b();
        }
        if (size != 1) {
            return set;
        }
        return SetsKt__SetsJVMKt.a(set.iterator().next());
    }

    public static <T> Set<T> d(T... tArr) {
        Intrinsics.f(tArr, "elements");
        if (tArr.length > 0) {
            return ArraysKt___ArraysKt.S(tArr);
        }
        return b();
    }
}
