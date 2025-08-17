package kotlin.jvm.internal;

import java.util.Iterator;

public final class ArrayIteratorKt {
    public static final <T> Iterator<T> a(T[] tArr) {
        Intrinsics.f(tArr, "array");
        return new ArrayIterator(tArr);
    }
}
