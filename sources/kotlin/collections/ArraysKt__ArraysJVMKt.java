package kotlin.collections;

import java.lang.reflect.Array;
import kotlin.jvm.internal.Intrinsics;

class ArraysKt__ArraysJVMKt {
    public static final <T> T[] a(T[] tArr, int i2) {
        Intrinsics.f(tArr, "reference");
        Object newInstance = Array.newInstance(tArr.getClass().getComponentType(), i2);
        Intrinsics.d(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) newInstance;
    }

    public static final void b(int i2, int i3) {
        if (i2 > i3) {
            throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i3 + ").");
        }
    }
}
