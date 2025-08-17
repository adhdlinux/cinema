package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

class CollectionsKt__CollectionsJVMKt {
    public static final <T> Object[] a(T[] tArr, boolean z2) {
        Intrinsics.f(tArr, "<this>");
        Class<Object[]> cls = Object[].class;
        if (z2 && Intrinsics.a(tArr.getClass(), cls)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, cls);
        Intrinsics.e(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    public static <T> List<T> b(T t2) {
        List<T> singletonList = Collections.singletonList(t2);
        Intrinsics.e(singletonList, "singletonList(element)");
        return singletonList;
    }
}
