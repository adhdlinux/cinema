package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Multimaps {

    private static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {

        /* renamed from: h  reason: collision with root package name */
        transient Supplier<? extends List<V>> f30637h;

        CustomListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
            super(map);
            this.f30637h = (Supplier) Preconditions.l(supplier);
        }

        /* access modifiers changed from: package-private */
        public Map<K, Collection<V>> d() {
            return s();
        }

        /* access modifiers changed from: package-private */
        public Set<K> f() {
            return t();
        }

        /* access modifiers changed from: protected */
        /* renamed from: z */
        public List<V> q() {
            return (List) this.f30637h.get();
        }
    }

    static abstract class Entries<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        Entries() {
        }

        /* access modifiers changed from: package-private */
        public abstract Multimap<K, V> a();

        public void clear() {
            a().clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().b(entry.getKey(), entry.getValue());
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().remove(entry.getKey(), entry.getValue());
        }

        public int size() {
            return a().size();
        }
    }

    private Multimaps() {
    }

    static boolean a(Multimap<?, ?> multimap, Object obj) {
        if (obj == multimap) {
            return true;
        }
        if (obj instanceof Multimap) {
            return multimap.asMap().equals(((Multimap) obj).asMap());
        }
        return false;
    }

    public static <K, V> ListMultimap<K, V> b(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
        return new CustomListMultimap(map, supplier);
    }
}
