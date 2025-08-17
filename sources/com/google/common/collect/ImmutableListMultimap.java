package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {

    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        public ImmutableListMultimap<K, V> d() {
            return (ImmutableListMultimap) super.a();
        }

        public Builder<K, V> e(K k2, V v2) {
            super.c(k2, v2);
            return this;
        }
    }

    ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i2) {
        super(immutableMap, i2);
    }

    static <K, V> ImmutableListMultimap<K, V> s(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        ImmutableList<E> immutableList;
        if (collection.isEmpty()) {
            return u();
        }
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        int i2 = 0;
        for (Map.Entry entry : collection) {
            Object key = entry.getKey();
            Collection collection2 = (Collection) entry.getValue();
            if (comparator == null) {
                immutableList = ImmutableList.n(collection2);
            } else {
                immutableList = ImmutableList.y(comparator, collection2);
            }
            if (!immutableList.isEmpty()) {
                builder.f(key, immutableList);
                i2 += immutableList.size();
            }
        }
        return new ImmutableListMultimap<>(builder.c(), i2);
    }

    public static <K, V> ImmutableListMultimap<K, V> u() {
        return EmptyImmutableListMultimap.f30505h;
    }

    /* renamed from: t */
    public ImmutableList<V> o(K k2) {
        ImmutableList<V> immutableList = (ImmutableList) this.f30530f.get(k2);
        if (immutableList == null) {
            return ImmutableList.r();
        }
        return immutableList;
    }
}
