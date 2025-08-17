package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

class MapsKt__MapsKt extends MapsKt__MapsJVMKt {
    public static <K, V> Map<K, V> g() {
        EmptyMap emptyMap = EmptyMap.f40320b;
        Intrinsics.d(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static <K, V> V h(Map<K, ? extends V> map, K k2) {
        Intrinsics.f(map, "<this>");
        return MapsKt__MapWithDefaultKt.a(map, k2);
    }

    public static <K, V> HashMap<K, V> i(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.f(pairArr, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(MapsKt__MapsJVMKt.d(pairArr.length));
        r(hashMap, pairArr);
        return hashMap;
    }

    public static <K, V> Map<K, V> j(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.f(pairArr, "pairs");
        if (pairArr.length > 0) {
            return v(pairArr, new LinkedHashMap(MapsKt__MapsJVMKt.d(pairArr.length)));
        }
        return g();
    }

    public static <K, V> Map<K, V> k(Map<? extends K, ? extends V> map, K k2) {
        Intrinsics.f(map, "<this>");
        Map w2 = w(map);
        w2.remove(k2);
        return m(w2);
    }

    public static <K, V> Map<K, V> l(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.f(pairArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.d(pairArr.length));
        r(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> m(Map<K, ? extends V> map) {
        Intrinsics.f(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return g();
        }
        if (size != 1) {
            return map;
        }
        return MapsKt__MapsJVMKt.f(map);
    }

    public static <K, V> Map<K, V> n(Map<? extends K, ? extends V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.f(map, "<this>");
        Intrinsics.f(iterable, "pairs");
        if (map.isEmpty()) {
            return s(iterable);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        q(linkedHashMap, iterable);
        return linkedHashMap;
    }

    public static <K, V> Map<K, V> o(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        Intrinsics.f(map, "<this>");
        Intrinsics.f(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static <K, V> Map<K, V> p(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V> pair) {
        Intrinsics.f(map, "<this>");
        Intrinsics.f(pair, "pair");
        if (map.isEmpty()) {
            return MapsKt__MapsJVMKt.e(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.c(), pair.d());
        return linkedHashMap;
    }

    public static final <K, V> void q(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.f(map, "<this>");
        Intrinsics.f(iterable, "pairs");
        for (Pair pair : iterable) {
            map.put(pair.a(), pair.b());
        }
    }

    public static final <K, V> void r(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.f(map, "<this>");
        Intrinsics.f(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put(pair.a(), pair.b());
        }
    }

    public static <K, V> Map<K, V> s(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Object obj;
        Intrinsics.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return m(t(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return g();
        }
        if (size != 1) {
            return t(iterable, new LinkedHashMap(MapsKt__MapsJVMKt.d(collection.size())));
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = iterable.iterator().next();
        }
        return MapsKt__MapsJVMKt.e((Pair) obj);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M t(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m2) {
        Intrinsics.f(iterable, "<this>");
        Intrinsics.f(m2, "destination");
        q(m2, iterable);
        return m2;
    }

    public static <K, V> Map<K, V> u(Map<? extends K, ? extends V> map) {
        Intrinsics.f(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return g();
        }
        if (size != 1) {
            return w(map);
        }
        return MapsKt__MapsJVMKt.f(map);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M v(Pair<? extends K, ? extends V>[] pairArr, M m2) {
        Intrinsics.f(pairArr, "<this>");
        Intrinsics.f(m2, "destination");
        r(m2, pairArr);
        return m2;
    }

    public static <K, V> Map<K, V> w(Map<? extends K, ? extends V> map) {
        Intrinsics.f(map, "<this>");
        return new LinkedHashMap(map);
    }
}
