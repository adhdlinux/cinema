package kotlin.collections;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public static <T> boolean u(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.f(collection, "<this>");
        Intrinsics.f(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z2 = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z2 = true;
            }
        }
        return z2;
    }

    public static <T> boolean v(Collection<? super T> collection, T[] tArr) {
        Intrinsics.f(collection, "<this>");
        Intrinsics.f(tArr, "elements");
        return collection.addAll(ArraysKt___ArraysJvmKt.d(tArr));
    }

    public static <T> T w(List<T> list) {
        Intrinsics.f(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(CollectionsKt__CollectionsKt.h(list));
        }
        throw new NoSuchElementException("List is empty.");
    }
}
