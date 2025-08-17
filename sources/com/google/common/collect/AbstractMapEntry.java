package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Map;

abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    AbstractMapEntry() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!Objects.a(getKey(), entry.getKey()) || !Objects.a(getValue(), entry.getValue())) {
            return false;
        }
        return true;
    }

    public abstract K getKey();

    public abstract V getValue();

    public int hashCode() {
        int i2;
        Object key = getKey();
        Object value = getValue();
        int i3 = 0;
        if (key == null) {
            i2 = 0;
        } else {
            i2 = key.hashCode();
        }
        if (value != null) {
            i3 = value.hashCode();
        }
        return i2 ^ i3;
    }

    public V setValue(V v2) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
