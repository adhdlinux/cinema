package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;

class MapsKt__MapsJVMKt extends MapsKt__MapWithDefaultKt {
    public static <K, V> Map<K, V> b(Map<K, V> map) {
        Intrinsics.f(map, "builder");
        return ((MapBuilder) map).j();
    }

    public static <K, V> Map<K, V> c() {
        return new MapBuilder();
    }

    public static int d(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((((float) i2) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static <K, V> Map<K, V> e(Pair<? extends K, ? extends V> pair) {
        Intrinsics.f(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.c(), pair.d());
        Intrinsics.e(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> f(Map<? extends K, ? extends V> map) {
        Intrinsics.f(map, "<this>");
        Map.Entry next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics.e(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
