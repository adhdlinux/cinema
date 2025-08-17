package kotlin.collections;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    public static <T> List<T> c(T[][] tArr) {
        Intrinsics.f(tArr, "<this>");
        int i2 = 0;
        for (T[] length : tArr) {
            i2 += length.length;
        }
        ArrayList arrayList = new ArrayList(i2);
        for (T[] v2 : tArr) {
            boolean unused = CollectionsKt__MutableCollectionsKt.v(arrayList, v2);
        }
        return arrayList;
    }
}
