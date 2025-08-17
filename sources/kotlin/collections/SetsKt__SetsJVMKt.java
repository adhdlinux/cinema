package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

class SetsKt__SetsJVMKt {
    public static <T> Set<T> a(T t2) {
        Set<T> singleton = Collections.singleton(t2);
        Intrinsics.e(singleton, "singleton(element)");
        return singleton;
    }
}
