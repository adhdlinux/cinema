package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

class MapsKt__MapWithDefaultKt {
    public static final <K, V> V a(Map<K, ? extends V> map, K k2) {
        Intrinsics.f(map, "<this>");
        if (map instanceof MapWithDefault) {
            return ((MapWithDefault) map).c(k2);
        }
        V v2 = map.get(k2);
        if (v2 != null || map.containsKey(k2)) {
            return v2;
        }
        throw new NoSuchElementException("Key " + k2 + " is missing in the map.");
    }
}
