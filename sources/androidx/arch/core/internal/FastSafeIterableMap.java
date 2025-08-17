package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {

    /* renamed from: f  reason: collision with root package name */
    private HashMap<K, SafeIterableMap.Entry<K, V>> f1567f = new HashMap<>();

    /* access modifiers changed from: protected */
    public SafeIterableMap.Entry<K, V> b(K k2) {
        return this.f1567f.get(k2);
    }

    public boolean contains(K k2) {
        return this.f1567f.containsKey(k2);
    }

    public V g(K k2, V v2) {
        SafeIterableMap.Entry b2 = b(k2);
        if (b2 != null) {
            return b2.f1573c;
        }
        this.f1567f.put(k2, e(k2, v2));
        return null;
    }

    public V h(K k2) {
        V h2 = super.h(k2);
        this.f1567f.remove(k2);
        return h2;
    }

    public Map.Entry<K, V> i(K k2) {
        if (contains(k2)) {
            return this.f1567f.get(k2).f1575e;
        }
        return null;
    }
}
