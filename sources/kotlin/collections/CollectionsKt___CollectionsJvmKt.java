package kotlin.collections;

import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

class CollectionsKt___CollectionsJvmKt extends CollectionsKt__ReversedViewsKt {
    public static final <T> void x(List<T> list) {
        Intrinsics.f(list, "<this>");
        Collections.reverse(list);
    }
}
