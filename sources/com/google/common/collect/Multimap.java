package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface Multimap<K, V> {
    Collection<Map.Entry<K, V>> a();

    Map<K, Collection<V>> asMap();

    boolean b(Object obj, Object obj2);

    void clear();

    Collection<V> get(K k2);

    Set<K> keySet();

    boolean put(K k2, V v2);

    boolean remove(Object obj, Object obj2);

    int size();

    Collection<V> values();
}
