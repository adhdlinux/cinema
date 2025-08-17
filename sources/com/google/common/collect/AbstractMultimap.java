package com.google.common.collect;

import com.google.common.collect.Multimaps;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class AbstractMultimap<K, V> implements Multimap<K, V> {

    /* renamed from: b  reason: collision with root package name */
    private transient Collection<Map.Entry<K, V>> f30466b;

    /* renamed from: c  reason: collision with root package name */
    private transient Set<K> f30467c;

    /* renamed from: d  reason: collision with root package name */
    private transient Collection<V> f30468d;

    /* renamed from: e  reason: collision with root package name */
    private transient Map<K, Collection<V>> f30469e;

    class Entries extends Multimaps.Entries<K, V> {
        Entries() {
        }

        /* access modifiers changed from: package-private */
        public Multimap<K, V> a() {
            return AbstractMultimap.this;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractMultimap.this.h();
        }
    }

    class Values extends AbstractCollection<V> {
        Values() {
        }

        public void clear() {
            AbstractMultimap.this.clear();
        }

        public boolean contains(Object obj) {
            return AbstractMultimap.this.c(obj);
        }

        public Iterator<V> iterator() {
            return AbstractMultimap.this.i();
        }

        public int size() {
            return AbstractMultimap.this.size();
        }
    }

    AbstractMultimap() {
    }

    public Collection<Map.Entry<K, V>> a() {
        Collection<Map.Entry<K, V>> collection = this.f30466b;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<K, V>> e2 = e();
        this.f30466b = e2;
        return e2;
    }

    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.f30469e;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> d2 = d();
        this.f30469e = d2;
        return d2;
    }

    public boolean b(Object obj, Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        if (collection == null || !collection.contains(obj2)) {
            return false;
        }
        return true;
    }

    public boolean c(Object obj) {
        for (Collection contains : asMap().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract Map<K, Collection<V>> d();

    /* access modifiers changed from: package-private */
    public abstract Collection<Map.Entry<K, V>> e();

    public boolean equals(Object obj) {
        return Multimaps.a(this, obj);
    }

    /* access modifiers changed from: package-private */
    public abstract Set<K> f();

    /* access modifiers changed from: package-private */
    public abstract Collection<V> g();

    /* access modifiers changed from: package-private */
    public abstract Iterator<Map.Entry<K, V>> h();

    public int hashCode() {
        return asMap().hashCode();
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> i() {
        return Maps.n(a().iterator());
    }

    public Set<K> keySet() {
        Set<K> set = this.f30467c;
        if (set != null) {
            return set;
        }
        Set<K> f2 = f();
        this.f30467c = f2;
        return f2;
    }

    public boolean put(K k2, V v2) {
        return get(k2).add(v2);
    }

    public boolean remove(Object obj, Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        if (collection == null || !collection.remove(obj2)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return asMap().toString();
    }

    public Collection<V> values() {
        Collection<V> collection = this.f30468d;
        if (collection != null) {
            return collection;
        }
        Collection<V> g2 = g();
        this.f30468d = g2;
        return g2;
    }
}
