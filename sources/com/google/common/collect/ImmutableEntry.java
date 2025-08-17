package com.google.common.collect;

import java.io.Serializable;

class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    final K f30510b;

    /* renamed from: c  reason: collision with root package name */
    final V f30511c;

    ImmutableEntry(K k2, V v2) {
        this.f30510b = k2;
        this.f30511c = v2;
    }

    public final K getKey() {
        return this.f30510b;
    }

    public final V getValue() {
        return this.f30511c;
    }

    public final V setValue(V v2) {
        throw new UnsupportedOperationException();
    }
}
