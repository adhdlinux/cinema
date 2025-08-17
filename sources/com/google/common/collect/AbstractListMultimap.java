package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements ListMultimap<K, V> {
    protected AbstractListMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    /* renamed from: A */
    public List<V> get(K k2) {
        return (List) super.get(k2);
    }

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean put(K k2, V v2) {
        return super.put(k2, v2);
    }

    /* access modifiers changed from: package-private */
    public <E> Collection<E> w(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> x(K k2, Collection<V> collection) {
        return y(k2, (List) collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public abstract List<V> q();
}
