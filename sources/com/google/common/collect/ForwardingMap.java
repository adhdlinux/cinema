package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {
    protected ForwardingMap() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Map<K, V> a();

    public void clear() {
        a().clear();
    }

    public boolean containsKey(Object obj) {
        return a().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return a().containsValue(obj);
    }

    /* access modifiers changed from: protected */
    public boolean d(Object obj) {
        return Maps.b(this, obj);
    }

    /* access modifiers changed from: protected */
    public boolean e(Object obj) {
        return Maps.c(this, obj);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return a().entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || a().equals(obj);
    }

    /* access modifiers changed from: protected */
    public int f() {
        return Sets.d(entrySet());
    }

    public V get(Object obj) {
        return a().get(obj);
    }

    public int hashCode() {
        return a().hashCode();
    }

    public boolean isEmpty() {
        return a().isEmpty();
    }

    public Set<K> keySet() {
        return a().keySet();
    }

    public V put(K k2, V v2) {
        return a().put(k2, v2);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        a().putAll(map);
    }

    public V remove(Object obj) {
        return a().remove(obj);
    }

    public int size() {
        return a().size();
    }

    public Collection<V> values() {
        return a().values();
    }
}
